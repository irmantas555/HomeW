package org.irmantas.hw0531;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.sstore.SessionStore;
import org.irmantas.tst.SequenceCalc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CalculatorServer extends AbstractVerticle {
    private final Logger logger = LoggerFactory.getLogger(CalculatorServer.class);
    char testC;
    int replStage;
    SequenceCalc sequenceCalc = new SequenceCalc();

    private static int sesionIndex = 1;
    Map<Integer, TreeMap<Double, String>> rezults = new HashMap<>();

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        Router router = Router.router(vertx);

        SessionStore store = SessionStore.create(vertx);
        router.route().handler(StaticHandler.create());
        router.route().handler(SessionHandler.create(store));
        router.route().handler(BodyHandler.create());
        router.route().handler(CorsHandler.create(".+")
                .maxAgeSeconds(600)
                .allowedMethod(HttpMethod.GET)
                .allowedMethod(HttpMethod.POST)

                .allowedMethod(HttpMethod.PUT)
                .allowedMethod(HttpMethod.DELETE)
                .allowedMethod(HttpMethod.OPTIONS)
                .allowedHeader("Content-Type")
                .allowedHeader("Accept")
                .allowedHeader("Accept-Language")
                .allowedHeader("Authorization"));
        router.post("/calculator/:session").handler(this::calculate);
        router.get("/calculator/:new").handler(this::newClaculator);

        vertx.createHttpServer().requestHandler(router).listen(8080, res -> { //inform us on server launch
            if (res.succeeded()) {
                System.out.println("Server is now listening!");
            } else {
                System.out.println("Failed to bind server port may be busy!");
            }
        });
        ;
    }

    private void newClaculator(RoutingContext routingContext) {
        sesionIndex++;
        rezults.put(sesionIndex, new TreeMap<>());
        JsonObject responseJson = new JsonObject().put("session", sesionIndex)
                .put("response", "You are free to go!");
    }

    private void calculate(RoutingContext routingContext) {
        String sequenceToCalculate;
        Double rezultatas = 0.00;
        TreeMap<Double, String> previous = null;
        boolean sequential;
        int thisSession = Integer.parseInt(routingContext.request().getParam("session"));
//        logger.info("Session we get " + thisSession);
        if (thisSession != 0) {
        previous = rezults.get(Integer.valueOf(thisSession));
        }
        if (thisSession == 0) {
            thisSession = ++sesionIndex;
        }

        JsonObject jsonObject = routingContext.getBodyAsJson();
//        logger.info(jsonObject);
        sequential = jsonObject.getBoolean("sequential");
//        logger.info(sequential);
        sequenceToCalculate = jsonObject.getString("sequence");
//        logger.info(sequenceToCalculate);
        if (sequential == true) {
//            logger.info("getting bad rezutl");
        rezultatas = sequenceCalc.sequenceOperations(sequenceToCalculate,previous.lastKey());
        } else {
//            logger.info("getting rezutl");
        rezultatas = sequenceCalc.sequenceOperations(sequenceToCalculate,0.00);
        }
//        logger.info(rezultatas);
        String stringRezult = String.format("%.2f",rezultatas);
//        previous.put(rezultatas,sequenceToCalculate);
        HttpServerResponse response = routingContext.response();
        JsonObject responseJson = new JsonObject().put("session", thisSession)
                .put("rezult", stringRezult);
        response.putHeader("Access-Control-Allow-Origin", "*")
                .putHeader("Access-Control-Allow-Methods", "*")
                .putHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .putHeader("content-type", "application/json")
                .end(responseJson.encodePrettily());
    }




}

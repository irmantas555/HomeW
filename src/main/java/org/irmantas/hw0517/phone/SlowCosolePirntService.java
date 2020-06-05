package org.irmantas.hw0517.phone;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.Timed;

import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

public interface SlowCosolePirntService {

    public static void printSlow(int interval, String message){
        char[] arr = message.toCharArray();
        Character[] Arr = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Arr[i] = Character.valueOf(arr[i]);
        }
        Observable<Character> observable = Observable.fromArray(Arr);
//        Observable<Timed<Character[]>> timedObservable = Observable.fromArray(Arr,80,TimeUnit.MILLISECONDS);
        Observable newO = Observable.just(message);
//        Observable.interval(0,1,TimeUnit.SECONDS)


//        observable
////                .map(character -> Observable.just(character,80,TimeUnit.MILLISECONDS))
//                .doOnNext(c->{
//            System.out.println(c);
//                    ThreadUtils.sleep(80);
//        }).subscribe(System.out::println);
        observable
                .timeInterval(TimeUnit.SECONDS)
                .subscribe(character->{

                System.out.print(character);
                    });
//        Observable.interval(Time)
//                .

    }
}


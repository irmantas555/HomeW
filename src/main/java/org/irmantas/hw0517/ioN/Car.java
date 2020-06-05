package org.irmantas.hw0517.ioN;

import java.io.Serializable;

public class Car implements Serializable {
    private String make;
    private String model;
    private String productionBeginYear;
    private String productionEndYear;
    private int doorQty;
    private String bodyStyle;

    public Car() {
    }

    public Car(String make, String model, String productionBeginYear, String productionEndYear, int doorQty, String bodyStyle) {
        this.make = make;
        this.model = model;
        this.productionBeginYear = productionBeginYear;
        this.productionEndYear = productionEndYear;
        this.doorQty = doorQty;
        this.bodyStyle = bodyStyle;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getProductionBeginYear() {
        return productionBeginYear;
    }

    public String getProductionEndYear() {
        return productionEndYear;
    }

    public int getDoorQty() {
        return doorQty;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductionBeginYear(String productionBeginYear) {
        this.productionBeginYear = productionBeginYear;
    }

    public void setProductionEndYear(String productionEndYear) {
        this.productionEndYear = productionEndYear;
    }

    public void setDoorQty(int doorQty) {
        this.doorQty = doorQty;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", productionBeginYear='" + productionBeginYear + '\'' +
                ", productionEndYear='" + productionEndYear + '\'' +
                ", doorQty=" + doorQty +
                ", bodyStyle='" + bodyStyle + '\'' +
                '}';
    }
}

package org.irmantas.hw0517.phone;

public class Iphone extends Phone{
        private String iOsVersion;
        private boolean retina;

        public Iphone() {

        }

    public Iphone(String iOsVersion, boolean retina) {
        this.iOsVersion = iOsVersion;
        this.retina = retina;
    }

    public Iphone(long number, String macAdress, long IMEI, String os, double screenSize, String iOsVersion, boolean retina,String model) {
        super(number, macAdress, IMEI, os, screenSize, model);
        this.iOsVersion = iOsVersion;
        this.retina = retina;
    }

    public void setiOsVersion(String iOsVersion) {
        this.iOsVersion = iOsVersion;
    }

    public void setRetina(boolean retina) {
        this.retina = retina;
    }
}

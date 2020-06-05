package org.irmantas.hw0517.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phone {
    private String model;
    private long number;
    private String macAdress;
    private long IMEI;
    private String os;
    private double screenSize;
    public Phone responder;
    List<Phone> contacts = new ArrayList();
    List<String> responses = new ArrayList<>();

    public Phone() {
    }

    public Phone(long number, String macAdress, long IMEI, String os, double screenSize,String model) {
        this.number = number;
        this.macAdress = macAdress;
        this.IMEI = IMEI;
        this.os = os;
        this.screenSize = screenSize;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public long getNumber() {
        return number;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public long getIMEI() {
        return IMEI;
    }

    public String getOs() {
        return os;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public List<String> dial(int numberToDial) throws InterruptedException {
        responses.add("Dialing other phone number: " + numberToDial);
        if (!contacts.isEmpty()) {
            contacts.stream()
                    .filter(phone -> phone.getNumber() == numberToDial)
                    .forEach(phone -> {
                        this.responder = phone;
                        responses.add(phone.answer(this));
                    });
        }

        return responses;
    }



    private int wait(int c, int timout) {
        try {
//            System.out.println("Im in wait sequence");
            Thread.sleep(timout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c;
    }

    private String answer(Phone incoming) {
        return ("Answering a call to number: " + incoming.getNumber());
    }

    public List<Phone> getContacts() {
        return contacts;
    }

    public void setContacts(List<Phone> contacts) {
        this.contacts = contacts;
    }

    public String answer(String question) {
        Map<String, String> answersMap = new HashMap<>();
        answersMap.put("What is your phone model", "What is your phone model " + "Responder: My phone is: " + responder.getModel());
        answersMap.put("What is your phone screen size", "What is your phone screen size " + "Responder: My phone phone screen size is: " + responder.getScreenSize());
        answersMap.put("What is your phone operating system","What is your phone operating system " + "Responder: My phone operating system is: " + responder.getOs());
        return answersMap.get(question);
    }
}

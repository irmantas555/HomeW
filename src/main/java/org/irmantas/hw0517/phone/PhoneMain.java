package org.irmantas.hw0517.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneMain {
        static PrintingSlow ps = new PrintInSteps();
    public static void main(String[] args) throws InterruptedException {
        Phone petrasPhone = new Iphone11ProMax(8672566,"2S:8J:HS:V9:OO", 55246146,"iOS 13",6.5,
                "13",true,true,"Iphone 11 Pro Max","Petras");
        Phone ausraPhone = new P40Pro(89067112,"DF:K4:RR:7J:O9", 374636166,
                "Android 10",6.58,true,true,"Huawei P40 Pro","Ausra");
        Phone tomasPhone = new GalaxyS20Ultra5G(89825477,"FA:U4:KI:43:OP", 464166131,
                "Android 10",6.9,true,true,true,"Samsung Galaxy S20 Ultra 5G","Tomas");
        petrasPhone.setContacts(Arrays.asList(ausraPhone,tomasPhone));
        ausraPhone.setContacts(Arrays.asList(petrasPhone,tomasPhone));
        tomasPhone.setContacts(Arrays.asList(ausraPhone,petrasPhone));

        petrasPhone.dial(89825477).stream()
                .forEach(string ->printStringInSlow(100, string));
        List<String> petrasAnswers = new ArrayList<>();
        petrasAnswers.add(petrasPhone.answer("What is your phone model"));
        petrasAnswers.add(petrasPhone.answer("What is your phone screen size"));
        petrasAnswers.add(petrasPhone.answer("What is your phone operating system"));
        petrasAnswers.stream()
                .forEach(string ->printStringInSlow(50, string));

        tomasPhone.dial(89067112).stream()
                .forEach(string ->printStringInSlow(100, string));
        List<String> tomasAnswers = new ArrayList<>();
        tomasAnswers.add(tomasPhone.answer("What is your phone model"));
        tomasAnswers.add(tomasPhone.answer("What is your phone screen size"));
        tomasAnswers.add(tomasPhone.answer("What is your phone operating system"));
        tomasAnswers.stream()
                .forEach(string ->printStringInSlow(50, string));









    }

    private static void printStringInSlow(int interval, String string) {
        new Thread(()->ps.printSlow(interval,string)).start();
        int time = string.length()*100;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.company;

import com.company.Observer.Listener;
import com.company.StrBuilder.StrBuilder;

public class Main {

    public static void main(String[] args) {

        StrBuilder a = new StrBuilder("Baba-boba");

        Listener hear1 = new Listener();
        Listener hear2 = new Listener();
        Listener hear3 = new Listener();

        a.AddObserver(hear1);
        a.AddObserver(hear2);
        a.AddObserver(hear3);

        a.append(" abo-ba");

        a.append(" 888");

    }
}
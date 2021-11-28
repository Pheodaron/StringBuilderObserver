package com.company.Observer;

import com.company.StrBuilder.StrBuilder;

public class Listener implements Observer{
    public void HandleEvent(StrBuilder s) {
        System.out.println("CHANGED: " + s.toString());
    }
}

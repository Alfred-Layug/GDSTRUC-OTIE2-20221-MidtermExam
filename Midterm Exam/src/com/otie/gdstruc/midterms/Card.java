package com.otie.gdstruc.midterms;

public class Card {

    private String name;
    private int value;

    Card(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
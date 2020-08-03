package common.impl;

import common.Instrument;

public abstract class Stringed implements Instrument {

    @Override
    public String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        System.out.println("adjust in " + getClass());
    }
}

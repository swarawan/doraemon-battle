package com.swarawan.doraemon.model;

public class Stun {

    private double stunChance;
    private int stunDuration;

    public Stun(double stunChance, int stunDuration) {
        this.stunChance = stunChance;
        this.stunDuration = stunDuration;
    }

    public double getStunChance() {
        return stunChance;
    }

    public int getStunDuration() {
        return stunDuration;
    }
}

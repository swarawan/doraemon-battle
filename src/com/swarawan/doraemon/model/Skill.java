package com.swarawan.doraemon.model;

public class Skill {

    private String name;
    private String desc;
    private int damage;
    private int manaConsume;
    private Stun stun;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaConsume() {
        return manaConsume;
    }

    public void setManaConsume(int manaConsume) {
        this.manaConsume = manaConsume;
    }

    public Stun getStun() {
        return stun;
    }

    public void setStun(Stun stun) {
        this.stun = stun;
    }
}

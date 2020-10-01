package com.example.basic;

public class Weapon {
    String name; // 武器名称
    int hurt; // 伤害值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public Weapon(String name, int hurt) {
        this.name = name;
        this.hurt = hurt;
    }
}

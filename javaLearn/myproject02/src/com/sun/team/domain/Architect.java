package com.sun.team.domain;

/**
 * @program: basic-code
 * @description:
 * @author: tmac24
 * @create: 2021-01-20 18:28
 */
public class Architect extends Designer{

    private int stock;//股票数量

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock  + "\t" + getEquipment().getDescription();
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

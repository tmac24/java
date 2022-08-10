package com.sun.team.domain;

/**
 * @program: basic-code
 * @description:
 * @author: tmac24
 * @create: 2021-01-20 16:48
 */
public class NoteBook implements Equipment {

    private String model;
    private double price;

    public NoteBook() {
        super();
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "（" + price + ")";
    }
}

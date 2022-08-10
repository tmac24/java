package com.sun.team.domain;

/**
 * @program: basic-code
 * @description:
 * @author: tmac24
 * @create: 2021-01-20 16:51
 */
public class Printer implements Equipment {
    private String name;
    private String type;

    public Printer() {
        super();
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}

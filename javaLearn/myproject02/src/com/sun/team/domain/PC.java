package com.sun.team.domain;

public class PC implements Equipment {

    private String model;//机器编号
    private String dispaly;//显示器名称

    public PC() {
        super();
    }

    public PC(String model, String dispaly) {
        this.model = model;
        this.dispaly = dispaly;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDispaly() {
        return dispaly;
    }

    public void setDispaly(String dispaly) {
        this.dispaly = dispaly;
    }

    @Override
    public String getDescription() {
        return model + "(" + dispaly + ")";
    }
}

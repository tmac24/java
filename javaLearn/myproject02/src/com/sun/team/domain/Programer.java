package com.sun.team.domain;

import com.sun.team.service.Status;

/**
 * @program: basic-code
 * @description:
 * @author: tmac24
 * @create: 2021-01-20 18:13
 */
public class Programer extends Employee{
    private int memberId;//开发团队中的id
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programer() {
        super();
    }

    public Programer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}

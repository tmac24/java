package com.sun.team.service;

import com.sun.team.domain.*;

import static com.sun.team.service.Data.*;

/**
 * @program: basic-code
 * @description: 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作的方法
 * @author: tmac24
 * @create: 2021-01-20 18:31
 */
public class NameListService {

    private Employee[] employees;

    /**
     * 给employees及数组元素初始化
     */
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            //获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            //获取其他基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;

            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }

    /**
     * 获取指定index上的员工设备
     * @param index
     * @return
     */
    private Equipment creatEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        String model = EQUIPMENTS[index][1];
        switch (type){
            case PC:
                String dispaly = EQUIPMENTS[index][2];
                return new PC(model, dispaly);
            case NOTEBOOK:
                double price= Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(model, price);
            case PRINTER:
                return new Printer(model, EQUIPMENTS[index][2]);
        }
        return null;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }

        throw new TeamException("找不到指定的员工");
    }

    public static void main(String[] args) {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
     }
}

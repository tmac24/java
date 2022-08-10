package com.sun.p2.ui;

import com.sun.p2.bean.Customer;
import com.sun.p2.service.CustomerList;
import com.sun.p2.util.CMUtility;

/**
 * @program: basic-code
 * @description: 视图，负责菜单的显示和处理用户的操作
 * @author: tmac24
 * @create: 2021-01-18 19:13
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("kebo", '男', 13, "15129502769", "727924283@qq.com");
        customerList.addCustomer(customer);
    }

    /**
     * 客户管理界面
     */
    public void enterMainMenu() {

        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n---------------------------------客户信息管理软件---------------------------------");
            System.out.println("                                    1添加客户");
            System.out.println("                                    2修改客户");
            System.out.println("                                    3删除客户");
            System.out.println("                                    4客户列表");
            System.out.println("                                    5退  出\n");
            System.out.print("                           请选择（1-5）: ");

            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.print("确认是否退出（Y/N）：");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }

            }
        }

    }

    private void addNewCustomer() {
        System.out.println("---------------------------------添加客户---------------------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);

        // 封装到对象中
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("添加成功！");
        } else {
            System.out.println("客户目录已满，添加失败！");
        }
    }

    private void modifyCustomer() {
        System.out.println("---------------------------------修改客户---------------------------------");
        Customer cust;
        int number;
        for (; ; ) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            cust = customerList.getCustomer(number - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }

        //修改客户信息
        System.out.print("姓名（" + cust.getName() + "):");
        String name = CMUtility.readString(10, cust.getName());
        System.out.print("性别（" + cust.getGender() + "):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄（" + cust.getAge() + "):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话（" + cust.getPhone() + "):");
        String phone = CMUtility.readString(13, cust.getPhone());
        System.out.print("邮箱（" + cust.getEmail() + "):");
        String email = CMUtility.readString(30, cust.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);

        boolean isRepalaced = customerList.replaceCustomer(number - 1, newCust);
        if (isRepalaced) {
            System.out.println("修改完成");
        } else {
            System.out.println("修改失败");
        }
    }

    private void deleteCustomer() {
        System.out.println("---------------------------------删除客户---------------------------------");
        int number;
        for (; ; ) {
            System.out.print("请选择待删除客户编号(-1退出)：");
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            Customer customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户");
            } else {
                break;
            }
        }
        //找到了指定客户
        System.out.print("确认是否删除（Y/N）:");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y') {
            boolean isSucessed = customerList.deleteCustomer(number - 1);
            if (isSucessed) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else {
            return;
        }
    }

    private void listAllCustomer() {
        System.out.println("---------------------------------客户列表---------------------------------");

        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println((i + 1) + "\t\t" + cust.getName() + "\t" + cust.getGender() + "\t\t" + cust.getAge() + "\t\t" + cust.getPhone() + "\t\t" + cust.getEmail());
            }
        }

        System.out.println("---------------------------------客户列表完成-------------------------------");

    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}

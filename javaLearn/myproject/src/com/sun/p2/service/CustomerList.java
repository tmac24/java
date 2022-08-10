package com.sun.p2.service;

import com.sun.p2.bean.Customer;

/**
 * @program: basic-code
 * @description: 顾客列表
 * @author: tmac24
 * @create: 2021-01-18 18:53
 */
public class CustomerList {
    private Customer[] customers; // 用来保存客户对象的数组
    private int total = 0; // 记录已保存客户对象的数量

    /**
     * 初始化构造器
     * @param totalCustomer，指定数组的长度
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     *
     * 将指定的客户添加到数组中
     * @param customer
     * @return 成功或失败
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length){
            return false;
        }

        customers[total] = customer;
        total++;
        return true;
    }

    /**
     * 修改指定索引位置的客户信息
     * @param index
     * @param customer
     * @return
     */
    public boolean replaceCustomer(int index, Customer customer) {
        if (index < 0 || index >= total){
            return false;
        }
        customers[index] = customer;
        return true;
    }

    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total){
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i+1];
        }

        //最后的元素需要置为空
        customers[--total] = null;
        return true;
    }

    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    public int getTotal() {
        return total;
    }
}

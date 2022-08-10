package com.sun.team.service;

/**
 * @program: basic-code
 * @description: 自定义异常类
 * @author: tmac24
 * @create: 2021-01-23 10:05
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3387516993124229948L;

    public TeamException(){
        super();
    }

    public TeamException(String msg){
        super(msg);
    }
}

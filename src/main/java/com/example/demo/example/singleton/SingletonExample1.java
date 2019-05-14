package com.example.demo.example.singleton;

import com.example.demo.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * 24到26行在多线程下如果两个线程同时判断为空，可能会实例化两次
 */
@NotThreadSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1(){

    }

    //单例对象
    private static SingletonExample1 instance = null;


    //静态的工厂方法
    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}

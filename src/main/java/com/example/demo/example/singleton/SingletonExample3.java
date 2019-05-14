package com.example.demo.example.singleton;

import com.example.demo.annoations.NotRecommend;
import com.example.demo.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * synchronized 同步工厂方法  不推荐
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance = null;


    //静态的工厂方法  synchronized
    public static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}

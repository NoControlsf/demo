package com.example.demo.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    //修饰一个代码块
    public  void test1(int j){
        synchronized (this){
            for(int i = 0; i < 10; i++){
                log.info("test1 - {} - {}", j, i);
            }
        }
    }

    //修饰一个方法
    public  synchronized void test2(int j){
        for(int i = 0; i < 10; i++){
            log.info("test2 - {} - {}", j, i);
        }
    }

    public static void main(String[] args){

        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();

        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //执行同个对象多个同步代码块
        /*executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example1.test1(2);
        });*/

        //执行同个对象多个同步方法
        /*executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example1.test2(2);
        });*/

        //执行不同对象代码块
        /*executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });*/

        //执行不同对象多个同步方法
        executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example2.test2(2);
        });
        executorService.shutdown();
    }
}

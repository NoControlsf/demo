package com.example.demo.example.syncContainer;

import com.example.demo.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class VectorExample2 {

    //请求总数
    public static int clientTotal =5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;


    private static Vector<Integer> vector = new Vector<>();
    public static void main(String[] args) throws Exception {


        for(int i = 0; i < 100; i++){
            vector.add(i);
        }

        Thread thread1 = new Thread(){
            public void run(){
                for(int i = 0; i < vector.size(); i++){
                    vector.remove(i);
                }
            }
        };

        Thread thread2 = new Thread(){
            public void run(){
                for(int i = 0; i < vector.size(); i++){
                    vector.get(i);
                }
            }
        };
        thread1.start();
        thread2.start();

    }

    //设置为局部变量
    private static void update(int i){
        vector.add(i);
    }
}

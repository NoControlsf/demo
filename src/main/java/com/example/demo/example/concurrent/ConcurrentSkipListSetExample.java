package com.example.demo.example.concurrent;

import com.example.demo.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.*;

@Slf4j
@ThreadSafe
public class ConcurrentSkipListSetExample {

    //请求总数
    public static int clientTotal =5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;



    //并发情况下不支持批量操作 addAll removeAll线程不安全
    private static Set<Integer> set = new ConcurrentSkipListSet<>();
    public static void main(String[] args) throws Exception {

        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0; i < clientTotal; i++){
            final int count = i;
            executorService.execute(()->{

                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception", e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", set.size());

    }

    //设置为局部变量
    private static void update(int i){
        set.add(i);
    }
}

package com.example.demo.example.atomic;

import com.example.demo.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;


@Slf4j
@ThreadSafe
public class AtomicExample5 {
    //AtomicIntegerFieldUpdater用法
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    //必须使用volatile修饰 通过加入内存屏障和禁止重排序优化来实现
    @Getter
    public volatile int count = 100;

    public static void main(String[] args){
        AtomicExample5 example5 = new AtomicExample5();

        if(updater.compareAndSet(example5, 100, 120)){
            log.info("update success 1, {}", example5.getCount());
        }

        if(updater.compareAndSet(example5, 100, 120)){
            log.info("update success 2, {}", example5.getCount());
        }else {
            log.info("update failed, {}", example5.getCount());
        }
    }
}


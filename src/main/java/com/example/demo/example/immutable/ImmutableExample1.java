package com.example.demo.example.immutable;

import com.example.demo.annoations.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        //a = 2; 编译报错 final修饰不可更改
        //b = "3"; 编译报错 final修饰不可更改
        //map = Maps.newHashMap(); 引用类型指针指向不能修改 但能修改引用类型里的值
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

    private void test(final int a){
        // a = 1; 编译报错 final修饰入参不可更改
    }
}

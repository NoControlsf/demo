package com.example.demo.example.publish;

import com.example.demo.annoations.NotRecommend;
import com.example.demo.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

//对象未完成构造前不应该将其发布
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape (){

        new InnerClass();
    }

    //内部类
    private  class InnerClass{

        public InnerClass(){
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args){
        new Escape();
    }

}

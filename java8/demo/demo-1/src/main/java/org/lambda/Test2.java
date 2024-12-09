package org.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class Test2 {
    // 一.无参数
    @Test
    public void test2_1() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        Runnable runnable2 = () -> System.out.println("world");
        runnable.run();
        runnable2.run();
    }
    //二. 需要参数但是没有返回值。
    @Test
    public void test2_2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Consumer<String> consumer2 = s -> System.out.println(s);
        consumer.accept("谎言和誓言的有什么区别");
        consumer2.accept("一个是听的人当真了，一个是说的人当真了");
        //共6种不一一测试，都是省略一些类型（类型推断）或括号。
    }
}

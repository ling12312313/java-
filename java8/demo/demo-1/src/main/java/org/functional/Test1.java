package org.functional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 java四大内置函数式接口
  Consume<T>  消费型   void accept(T t)
  Supplier<T>  供给型   T get()
  Function<T,R>  函数型 R apply(T t)
  Predicate<T>   断言型   boolean test(T t)
*/
public class Test1 {
    //Consume  传入参数 无返回值 sout
    @Test
    public void test1() {
        happy(100, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费了" + aDouble);
            }
        });
       happy(500, money -> System.out.println("消费了" + money));
    }
    public void happy(double money, Consumer<Double> consumer) {
           consumer.accept(money);
    }

    //Predicate  传入参数 判定并返回值 判定结果布尔值
    @Test
    public void test2() {
        List<String> list = Arrays.asList("琴","莫娜","芭芭拉","刻晴","甘雨","神里绫华","令");
        List<String> l2 = filter(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("令");
            }
        });
        List<String> l3 = filter(list, s -> s.contains("令"));
        System.out.println(l2);
        System.out.println(l3);
    }
    public List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                result.add(s);
            }
        }
        return result;
    }
    //Supplier 无参数 有返回值 放回随机值
    @Test
    public void test3() {
        List<String> list = Arrays.asList("琴","莫娜","芭芭拉","刻晴","甘雨","神里绫华","令");
        String name1 = randomName(new Supplier<String>() {
            @Override
            public String get() {
                return list.get((int) (Math.random() * list.size()));
            }
        }, list);

        String name2 = randomName(() -> list.get((int) (Math.random() * list.size())), list);
        System.out.println(name1);
        System.out.println(name2);
    }
    public String randomName(Supplier<String> supplier,List<String> list) {
        return supplier.get();
    }

    // Function 传入参数 有返回值 返回字符串长度
    @Test
    public void test4() {
        List<String> list = Arrays.asList("琴","莫娜","芭芭拉","刻晴","甘雨","神里绫华","令");
        List<Integer> l1 = getLength(list, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });

        List<Integer> l2 = getLength(list, s -> s.length());
        System.out.println(l1);
        System.out.println(l2);
    }
    public List<Integer> getLength(List<String> list, Function<String, Integer> function) {
         List<Integer> result = new ArrayList<>();
        for (String s : list) {
             result.add(function.apply(s));
         }
        return result;
    }

}

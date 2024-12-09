package org.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
/*-
  简化匿名类实现接口。接口的实例
  本质：函数式接口的实例。
  函数式接口：只有一个抽象方法的接口。
  所有匿名表达式都可以用lambda简化
 ->操作符
 ->左边 参数
 ->右边 lambda体
* */
public class Test1 {
    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println("常规");
        System.out.println(comparator.compare(1, 2));
        System.out.println("lambda");

        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator1.compare(1, 2));

        System.out.println("方法内联");

        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(1, 2));
    }
}

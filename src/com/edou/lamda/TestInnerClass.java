package com.edou.lamda;

import org.junit.Test;

/**
 * @ClassName TestInnerClass
 * @Description 测试匿名内部类访问局部变量是否加final
 * @Author 中森明菜
 * @Date 2020/9/27 8:46
 * @Version 1.0
 */
public class TestInnerClass {
    @Test
    public void testRef() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("test1");
        Runnable r1 = () -> {
        // threadLocal = new ThreadLocal<>();
            threadLocal.set("test2");
            String result = threadLocal.get();
            // test2
            System.out.println(result);
        };
        r1.run();
        Runnable r2 = () -> {
            threadLocal.set("test3");
            String result = threadLocal.get();
            // test3
            System.out.println(result);
        };
        r2.run();
    }
    @Test
    public void testBasicValue() {
        int a = 1;
        Runnable r = () -> {
            // a = 2
            System.out.println(a);
        };
        r.run();
    }
}

package iorl.aop.controller;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("123");
        List<Integer> list2 = list;
        System.out.println(list2.get(0).intValue());
    }
}

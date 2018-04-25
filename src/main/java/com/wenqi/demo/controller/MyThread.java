package com.wenqi.demo.controller;

import java.util.*;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.print("=======");
    }
    public static void main(String[] args){
//        Set set=new TreeSet();
////        set.add("AAA");
////        Set hashSet=new HashSet();
////        hashSet.add("aaa");
////        MyThread myThread=new MyThread();
////        Thread thread = new Thread(myThread);
////        thread.start();
        Map<String,String> map=new HashMap<String,String>();
        map.put("111","aaa");
        map.put("222","bbb");
        map.put("333","ccc");
        map.put("444","ddd");
//        for (Object s:map.keySet()
//             ) {
//            System.out.println(map.get(s));
//        }
        for (Map.Entry e:map.entrySet()
             ) {
            System.out.println(e.getKey()+"="+e.getValue());
        }
        System.out.println("=======================");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> entry = iterator.next();
                System.out.println(entry.getKey()+"="+entry.getValue());
        }
        System.out.println("=======================");
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Iterator it=set.iterator();it.hasNext();
             ) {
            System.out.println(it.next());
        }
    }
}

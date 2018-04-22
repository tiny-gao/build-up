package com.tinygao.asm;

/**
 * Created by tinygao on 2017/8/29 0029.
 */
public class Person {
    public void say() {
        System.out.println("I am a man");
    }

    public static void main(String[] args) {
        java.net.URL url = Person.class.getResource("/nativelib/Windows_7-amd64/hadoop.dll");
        System.out.println(url);
    }
}

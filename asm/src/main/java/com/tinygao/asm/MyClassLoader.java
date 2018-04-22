package com.tinygao.asm;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tinygao on 2017/8/22 0022.
 */
public class MyClassLoader extends  ClassLoader {
    public Class defineClass(String name, byte[]b) {
        return defineClass(name, b, 0, b.length);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, URISyntaxException, IOException {
        MyClassLoader myClassLoader = new MyClassLoader();

        Path path = Paths.get(new URI("file:///d:/Comparable.class"));
        Class c = myClassLoader.defineClass("pkg.Comparable",Files.readAllBytes(path));

    }
}

package com.tinygao.asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by tinygao on 2017/8/29 0029.
 */
public class PersonTest extends  ClassLoader {
    public  void modifyMethod() throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        ClassReader reader = new ClassReader("com.tinygao.asm.Person");
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        PersonModify adapter = new PersonModify(writer);
        reader.accept(adapter, ClassReader.SKIP_DEBUG);

        byte[] classFile = writer.toByteArray();
        Class clazz = this.defineClass("com.tinygao.asm.Person", classFile, 0, classFile.length);
        PersonTest.class.getClassLoader().loadClass("com.tinygao.asm.Person");
        System.out.println(PersonTest.class.getClassLoader());
        Object obj = clazz.newInstance();
        clazz.getDeclaredMethod("say").invoke(obj);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Person person = new Person();
        person.say();
        PersonTest p = new PersonTest();
        p.modifyMethod();
    }
}

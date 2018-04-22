package com.tinygao.asm;

import com.google.common.io.Files;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.*;

/**
 * Created by tinygao on 2017/8/22 0022.
 */
public class ClassWriterTest {

    //创建一个类保存起来
    public static void main(String[] args) throws IOException {
        ClassWriter  cw = new ClassWriter(0 );
        cw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable", null, "java/lang/Object",
                new String[] { "pkg/Mesurable" });
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        byte[] b = cw.toByteArray();
        File file = new File("d:/Comparable.class");
        Files.write(b, file);
    }
}

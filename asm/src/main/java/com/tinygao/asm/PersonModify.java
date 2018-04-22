package com.tinygao.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM4;

/**
 * Created by tinygao on 2017/8/29 0029.
 */
public class PersonModify extends ClassVisitor {


    public PersonModify(
            ClassVisitor cv) {
        super(ASM4, cv);
    }
    public MethodVisitor visitMethod(int access, String name,
                                     String desc, String signature, String[] exceptions) {
        if (name.equals("say")) {
            // 不要委托至下一个访问器 -> 这样将移除该方法
            return null;
        }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}

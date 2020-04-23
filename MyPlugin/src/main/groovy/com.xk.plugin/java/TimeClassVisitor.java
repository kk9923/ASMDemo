package com.xk.plugin.java;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class TimeClassVisitor extends ClassVisitor {

    private String mClassName;

    public TimeClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        this.mClassName = name;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if (!name.equals("<init>") && mv != null && mClassName.startsWith("com/kx/asm")) {
//            return new LogMethodTimeVisitor(mv,access,name,desc,mClassName);
            return new SystemOutMethodTimeVisitor(mv,access,name,desc,mClassName);
        }
        return mv;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        return super.visitField(access, name, desc, signature, value);
    }
}

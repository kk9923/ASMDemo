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
        //System.out.println("LifecycleClassVisitor : visitMethod : " + name);
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        //匹配FragmentActivity
//        if ("android/support/v4/app/FragmentActivity".equals(this.mClassName)) {
//            if (methods.contains(name)) {
//                //处理onCreate
//                return new OnCreateMethodVisitor(mv,access,name,desc,mClassName);
//            }
//        }
        if (!name.equals("<init>") && mv != null && mClassName.startsWith("com/kx/asm")) {
            return new OnCreateMethodVisitor(mv,access,name,desc,mClassName);
        }
        return mv;
     //   return mv;
//        if (mv != null && name.equals("process")) {
//            mv = new LifecycleOnCreateMethodVisitor(mv);
//        if (!name.equals("<init>") && mv != null ) {
//            mv = new LifecycleOnCreateMethodVisitor(mv,name);
//        }
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        return super.visitField(access, name, desc, signature, value);
    }
}

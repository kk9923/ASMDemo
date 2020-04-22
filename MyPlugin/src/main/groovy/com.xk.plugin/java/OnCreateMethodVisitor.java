package com.xk.plugin.java;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

public class OnCreateMethodVisitor extends AdviceAdapter {

    private String methodName;
    private String mClassName;

    public OnCreateMethodVisitor(MethodVisitor mv, int access, String name, String desc, String mClassName) {
        super(Opcodes.ASM4, mv, access, name, desc);
        this.methodName = name;
        this.mClassName = mClassName;
    }

    private int timeLocalIndex = 0;

    @Override
    protected void onMethodEnter() {
        timeLocalIndex = newLocal(Type.LONG_TYPE);
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitVarInsn(LSTORE, timeLocalIndex);

    }

    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
        int durationId = newLocal(Type.LONG_TYPE);
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitVarInsn(LLOAD, timeLocalIndex);
        mv.visitInsn(LSUB);
        mv.visitVarInsn(LSTORE, durationId);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
        mv.visitInsn(DUP);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
        mv.visitLdcInsn(" MethodTime " + "" + methodName + "() is ");
//        mv.visitLdcInsn("ClassName = " + mClassName + "   MethodTime " + "" + methodName + "() is ");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
        mv.visitVarInsn(LLOAD, durationId);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);


    }
}

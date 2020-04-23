package com.xk.plugin.java;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

public class LogMethodTimeVisitor extends AdviceAdapter {

    private String methodName;
    private String mClassName;

    public LogMethodTimeVisitor(MethodVisitor mv, int access, String name, String desc, String mClassName) {
        super(Opcodes.ASM4, mv, access, name, desc);
        this.methodName = name;
        this.mClassName = mClassName;
    }

    private int enterTime = 0;

    @Override
    protected void onMethodEnter() {
        enterTime = newLocal(Type.LONG_TYPE);
        mv.visitMethodInsn(INVOKESTATIC,"java/lang/System","currentTimeMillis","()J",false);
        mv.visitVarInsn(LSTORE,enterTime);
    }

    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
        int exitTime = newLocal(Type.LONG_TYPE);
        mv.visitMethodInsn(INVOKESTATIC,"java/lang/System","currentTimeMillis","()J",false);
        mv.visitVarInsn(LSTORE,exitTime);

        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(INVOKEVIRTUAL,"java/lang/Object","getClass","()Ljava/lang/Class;",false);
        mv.visitMethodInsn(INVOKEVIRTUAL,"java/lang/Class","getSimpleName","()Ljava/lang/String;",false);

        mv.visitVarInsn(ASTORE,5);

        mv.visitVarInsn(Opcodes.ALOAD, 5);
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
        mv.visitInsn(DUP);
        mv.visitMethodInsn(INVOKESPECIAL,"java/lang/StringBuilder","<init>","()V",false);
        mv.visitLdcInsn(" LogMethodTime   " + "" + methodName + "() is ");
        mv.visitMethodInsn(INVOKEVIRTUAL,"java/lang/StringBuilder","append","(Ljava/lang/String;)Ljava/lang/StringBuilder;",false);
        mv.visitVarInsn(LLOAD, exitTime);
        mv.visitVarInsn(LLOAD, enterTime);
        mv.visitInsn(LSUB);
        mv.visitMethodInsn(INVOKEVIRTUAL,"java/lang/StringBuilder","append","(J)Ljava/lang/StringBuilder;",false);
        mv.visitMethodInsn(INVOKEVIRTUAL,"java/lang/StringBuilder","toString","()Ljava/lang/String;",false);
        mv.visitMethodInsn(INVOKESTATIC,"android/util/Log","e","(Ljava/lang/String;Ljava/lang/String;)I",false);
        mv.visitInsn(Opcodes.POP);

    }
}

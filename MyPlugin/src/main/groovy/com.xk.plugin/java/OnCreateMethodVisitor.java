package com.xk.plugin.java;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

public class OnCreateMethodVisitor extends AdviceAdapter {

    public OnCreateMethodVisitor( MethodVisitor mv, int access, String name, String desc) {
        super(Opcodes.ASM4, mv,access,name,desc);
    }
    private int timeLocalIndex = 0;
    @Override
    protected void onMethodEnter() {
//        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J",false);
//        // 1        
//        timeLocalIndex = newLocal(Type.LONG_TYPE);
//        mv.visitVarInsn(LSTORE, timeLocalIndex);
        mv.visitLdcInsn("TAG");
        mv.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder");
        mv.visitInsn(Opcodes.DUP);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
        mv.visitLdcInsn("-------> onCreate : ");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;", false);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Class", "getSimpleName", "()Ljava/lang/String;", false);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "android/util/Log", "e", "(Ljava/lang/String;Ljava/lang/String;)I", false);
        mv.visitInsn(Opcodes.POP);

    }

    @Override
    protected void onMethodExit(int opcode) {
//        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis","()J",false);
//       mv.visitVarInsn(LLOAD, timeLocalIndex);
//        mv.visitInsn(LSUB);
//        mv.visitVarInsn(LSTORE, timeLocalIndex);
//        int stringBuilderIndex = newLocal(Type.getType("java/lang/StringBuilder"));
//        mv.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder");
//        mv.visitInsn(Opcodes.DUP);
//        mv.visitMethodInsn(Opcodes.INVOKESPECIAL,"java/lang/StringBuilder","<init>","()V",false);
//        mv.visitVarInsn(Opcodes.ASTORE, stringBuilderIndex);
//        mv.visitVarInsn(Opcodes.ALOAD,stringBuilderIndex);
//        mv.visitLdcInsn("com/sample/asm/SampleApplication.onCreate\u00a0time:\u00a0");
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
//        mv.visitInsn(Opcodes.POP);mv.visitVarInsn(Opcodes.ALOAD, stringBuilderIndex);
//        mv.visitVarInsn(Opcodes.LLOAD,timeLocalIndex);mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/lang/StringBuilder","append","(J)Ljava/lang/StringBuilder;",false);
//        mv.visitInsn(Opcodes.POP);mv.visitLdcInsn("Geek");
//        mv.visitVarInsn(Opcodes.ALOAD,stringBuilderIndex);
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/lang/StringBuilder","toString","()Ljava/lang/String;",false);
//        mv.visitMethodInsn(Opcodes.INVOKESTATIC,"android/util/Log","d","(Ljava/lang/String;Ljava/lang/String;)I",false);
//        // 2        
//        mv.visitInsn(Opcodes.POP);

    }
}

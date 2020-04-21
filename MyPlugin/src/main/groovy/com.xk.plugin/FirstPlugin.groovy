package com.xk.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class FirstPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println("----------------------------")
        println("自定义Gradle插件")
        println("----------------------------")
        println("添加Gradle插件")
        println("----------------------------")

        // 注册 transform
        project.extensions.getByType(AppExtension).registerTransform(new MyTransform())
    }
}
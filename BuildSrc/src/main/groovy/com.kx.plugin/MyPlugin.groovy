package com.kx.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project;

class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        System.out.println("========================")
        System.out.println("自定义插件")
        System.out.println("========================")
//        project.android.registerTransform(new MyTransform(project))
    }
}

package com.kx.plugin

import org.gradle.api.Project

class Plugin implements org.gradle.api.Plugin<Project> {

    @Override
    void apply(Project project) {
        System.out.println("========================")
        System.out.println("自定义插件Plugin")
        System.out.println("========================")
        project.tasks.create("mytask", Task.class)
//        project.android.registerTransform(new MyTransform(project))
    }
}

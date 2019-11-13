package com.kx.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class Task extends DefaultTask {
    @TaskAction
    void action() {
        System.out.println("========================")
        System.out.println("自定义Task")
        System.out.println("========================")
    }
}

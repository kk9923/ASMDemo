package com.xk.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class FirstTask extends DefaultTask {

    @TaskAction
    void action() {
        println("----------------------------")
        println("自定义FirstTask")
        println("----------------------------")
    }
}
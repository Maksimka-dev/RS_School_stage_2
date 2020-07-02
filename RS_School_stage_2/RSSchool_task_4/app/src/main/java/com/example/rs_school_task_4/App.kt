package com.example.rs_school_task_4

import android.app.Application

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    init {
        instance = this
    }

}
package com.example.rs_school_task_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PrefAcrivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preference_acrivity)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.prefs_content,SettingsFragment())
            .commit()
    }
}
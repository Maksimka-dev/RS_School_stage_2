package com.example.rs_school_task_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// TODO naming
class PrefAcrivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO into constructor
        setContentView(R.layout.preference_acrivity)

        // TODO rotation???
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.prefs_content,SettingsFragment())
            .commit()
    }
}
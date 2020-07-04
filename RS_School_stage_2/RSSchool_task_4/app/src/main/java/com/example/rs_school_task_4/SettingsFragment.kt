package com.example.rs_school_task_4

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        return
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO onCreatePreferences is called inside super.onCreate(savedInstanceState)
        // TODO so this callback is redundant
        addPreferencesFromResource(R.xml.preference)
    }
}
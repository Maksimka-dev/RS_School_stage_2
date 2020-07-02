package com.example.rs_school_task_4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var model :EditText = findViewById(R.id.Model)
        var age :EditText = findViewById(R.id.Age)
        var color :EditText = findViewById(R.id.Color)


        var Add : Button = findViewById(R.id.btn_Add)
        Add.setOnClickListener{

            var intentAdd : Intent = Intent()
            intentAdd.putExtra("age", age.getText().toString())
            intentAdd.putExtra("color", color.getText().toString())
            intentAdd.putExtra("modelName", model.getText().toString())

            setResult(RESULT_OK, intentAdd)
            finish()

        }
    }
}
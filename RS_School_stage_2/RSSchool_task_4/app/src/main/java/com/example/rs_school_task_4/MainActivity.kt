package com.example.rs_school_task_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toolbar
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rs_school_task_4.Adapter.MyRecyclerViewAdepter
import com.example.rs_school_task_4.DB.Dao
import com.example.rs_school_task_4.DB.Table
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val dao = Dao()
    val myAdaptor = MyRecyclerViewAdepter()
    // TODO var and mutable list, could be changed any time
    var currentTable :MutableList<Table> = mutableListOf()

    // TODO lateinit var anyView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO it's possible to move it into constructor
        setContentView(R.layout.activity_main)

        val btnAdd :FloatingActionButton = findViewById(R.id.button_Add)
        btnAdd.setOnClickListener{

            val addIntent :Intent = Intent(this, AddActivity::class.java)
            // TODO requestCode is hardcoded
            startActivityForResult(addIntent,1)

        }

        val recyclerView = findViewById<RecyclerView>(R.id.DatabaseView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        currentTable = dao.queryForAll()
        // TODO
        myAdaptor.DelAllItem()
        myAdaptor.AddItems(currentTable)

        recyclerView.adapter = myAdaptor
    }


    override fun onResume() {
        // TODO use another callback to update ui
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        // TODO when, hardcoded keys
        if(prefs.getBoolean("modelName", false)){

            currentTable.sortBy { it.modelName }

        }else if (prefs.getBoolean("ade", false)){

            currentTable.sortBy { it.age }

        }else if (prefs.getBoolean("color", false)){

            currentTable.sortBy { it.color }

        }

        myAdaptor.DelAllItem()
        myAdaptor.AddItems(currentTable)
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        currentTable.clear()
    }

    // TODO adding new items is responsibility of AddActivity not MainActivity
    // TODO when it's implemented onActivityResult will be redundant and just lifecycle callbacks
    // TODO will be used
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return

        val addCar : Table = Table()
        // TODO vars, not safe data parsing
        addCar.age = data.getStringExtra("age").toInt()
        addCar.color = data.getStringExtra("color")
        addCar.modelName = data.getStringExtra("modelName")
        dao.add(addCar)
        currentTable.add(addCar)
        myAdaptor.DelAllItem()
        myAdaptor.AddItems(currentTable)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Sort_by -> {
                val prefIntent :Intent = Intent(this, PrefAcrivity::class.java)
                startActivity(prefIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
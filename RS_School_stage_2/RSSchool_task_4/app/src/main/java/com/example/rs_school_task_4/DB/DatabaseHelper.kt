package com.example.rs_school_task_4.DB

import android.database.sqlite.SQLiteDatabase
import com.example.rs_school_task_4.App
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

// TODO bind it to Application class, test.db is hardcoded
object DatabaseHelper : OrmLiteSqliteOpenHelper(App.instance, "test.db", null, 1) {

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTableIfNotExists(connectionSource, Table::class.java)
    }

    override fun onUpgrade(database: SQLiteDatabase?, connectionSource: ConnectionSource?, oldVersion: Int, newVersion: Int) {
        // TODO could cause an Exception
        TableUtils.dropTable<Table, Any>(connectionSource, Table::class.java, true)
        onCreate(database, connectionSource)
    }

}

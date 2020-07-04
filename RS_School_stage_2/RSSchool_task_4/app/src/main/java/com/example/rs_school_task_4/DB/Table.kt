package com.example.rs_school_task_4.DB

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

// TODO var, naming, fomatting
@DatabaseTable(tableName = "table")
data class Table(

    @DatabaseField(generatedId = true)
    var id: Int? = null,

    @DatabaseField
    var modelName: String = "",

    @DatabaseField
    var age: Int = 0,

    @DatabaseField
    var color: String = ""

)
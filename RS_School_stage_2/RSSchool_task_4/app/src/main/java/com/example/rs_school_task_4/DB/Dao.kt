package com.example.rs_school_task_4.DB

class Dao {

    private val dao = DatabaseHelper.getDao(Table::class.java)

    fun add(table: Table) = dao.createOrUpdate(table)

    fun update(table: Table) = dao.update(table)

    fun delete(table: Table) = dao.delete(table)

    fun queryForAll() = dao.queryForAll()

    fun removeAll() {
        for (table in queryForAll()) {
            dao.delete(table)
        }
    }
}
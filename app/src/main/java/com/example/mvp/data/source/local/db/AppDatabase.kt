package com.example.mvp.data.source.local.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AppDatabase(
    context: Context
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(UserTable.CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(UserTable.DROP_USER_TABLE)
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "db_MVP"
        private const val DATABASE_VERSION = 1

        private var instance: AppDatabase? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: AppDatabase(context).also {
                    instance = it
                }
            }
    }
}

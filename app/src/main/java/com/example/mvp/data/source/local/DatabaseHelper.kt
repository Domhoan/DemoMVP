package com.example.mvp.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mvp.data.model.User

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context,
    User.DATABASE_NAME,null, User.DATABASE_VERSION){

    private val CREATE_USER_TABLE = ("CREATE TABLE " + User.TABLE_USER + "("
            + User.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + User.COLUMN_USER_NAME
            + " TEXT," + User.COLUMN_USER_PASSWORD + " TEXT" + ")")

    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS ${User.TABLE_USER}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_USER_TABLE)
        onCreate(db)
    }


}

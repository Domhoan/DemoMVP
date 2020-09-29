package com.example.mvp.data.source.local

import android.content.ContentValues
import android.content.Context
import com.example.mvp.data.model.User

class UserDatabaseLocal(context: Context) : UserDAO {

    private val databaseHelper: DatabaseHelper = DatabaseHelper(context)

    override fun addUser(user: User) {
        val db = databaseHelper.writableDatabase
        val values = ContentValues()

        values.put(User.COLUMN_USER_NAME, user.userName)
        values.put(User.COLUMN_USER_PASSWORD, user.passWord)

        db.insert(User.TABLE_USER, null, values)
        db.close()
    }

    override fun checkUser(userName: String): Boolean {
        val columns = arrayOf(User.COLUMN_USER_ID)
        val db = databaseHelper.readableDatabase

        val selection = "${User.COLUMN_USER_NAME} = ?"
        val selectionArgs = arrayOf(userName)

        val cursor = db.query(User.TABLE_USER, columns,selection,selectionArgs,null, null,null)
        val cursorCount = cursor.count

        cursor.close()
        db.close()

        if(cursorCount > 0 ){
            return true
        }
        return false
    }

    override fun checkUser(userName: String, passWord: String): Boolean {
        val columns = arrayOf(User.COLUMN_USER_ID)
        val db = databaseHelper.readableDatabase

        val selection = "${User.COLUMN_USER_NAME} = ? AND ${User.COLUMN_USER_PASSWORD} = ?"
        val selectionArgs = arrayOf(userName,passWord)

        val cursor = db.query(User.TABLE_USER, columns,selection,selectionArgs,null, null,null)
        val cursorCount = cursor.count

        cursor.close()
        db.close()

        if(cursorCount > 0 ){
            return true
        }
        return false
    }


}

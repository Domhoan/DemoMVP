package com.example.mvp.data.source.local.dao

import android.content.Context
import com.example.mvp.data.model.User
import com.example.mvp.data.source.local.db.AppDatabase
import com.example.mvp.data.source.local.db.UserTable

class UserDaoImpl(context: Context) : UserDAO {

    private val writableDb = AppDatabase.getInstance(context).writableDatabase
    private val readableDb = AppDatabase.getInstance(context).readableDatabase

    override fun addUser(user: User): Boolean =
        writableDb.insert(
            UserTable.TABLE_NAME,
            null,
            user.getContentValues()
        ) > 0

    override fun isExistUser(userName: String): Boolean {
        val columns = arrayOf(UserTable.COLUMN_USER_ID)

        val selection = "${UserTable.COLUMN_USER_NAME} = ?"
        val selectionArgs = arrayOf(userName)

        val cursor = readableDb.query(
            UserTable.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        val cursorCount = cursor.count

        cursor.close()
        readableDb.close()

        return cursorCount > 0
    }

    override fun isExistUser(userName: String, passWord: String): Boolean {

        val columns = arrayOf(UserTable.COLUMN_USER_ID)

        val selection =
            "${UserTable.COLUMN_USER_NAME} = ? AND ${UserTable.COLUMN_USER_PASSWORD} = ?"
        val selectionArgs = arrayOf(userName, passWord)

        val cursor = readableDb.query(
            UserTable.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        val cursorCount = cursor.count

        cursor.close()
        readableDb.close()

        return cursorCount > 0
    }

    companion object {
        private var instance: UserDaoImpl? = null

        fun getInstance(context: Context) =
            instance ?: UserDaoImpl(context).also {
                instance = it
            }
    }
}

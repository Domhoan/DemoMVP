package com.example.mvp.data.source.local.dao

import com.example.mvp.data.model.User
import com.example.mvp.data.source.local.AppDatabase
import com.example.mvp.data.source.local.UserTable

class UserDaoImpl(appDatabase: AppDatabase) : UserDAO {

    private val writableDb = appDatabase.writableDatabase
    private val readableDb = appDatabase.readableDatabase

    override fun addUser(vararg user: User) = user.count {
        writableDb.insert(
            UserTable.TABLE_NAME,
            null,
            it.getContentValues()
        ) > 0
    }

    override fun checkUser(userName: String): Boolean {
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

        if (cursorCount > 0) {
            return true
        }
        return false
    }

    override fun checkUser(userName: String, passWord: String): Boolean {

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

        if (cursorCount > 0) {
            return true
        }
        return false
    }

    companion object {
        private var instance: UserDaoImpl? = null

        fun getInstance(appDatabase: AppDatabase) = instance ?: synchronized(this) {
            instance ?: UserDaoImpl(appDatabase).also {
                instance = it
            }
        }
    }


}

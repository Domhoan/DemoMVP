package com.example.mvp.data.source.local


object UserTable {

    const val TABLE_NAME = "user"

    const val COLUMN_USER_ID = "user_id"
    const val COLUMN_USER_NAME = "user_name"
    const val COLUMN_USER_PASSWORD = "user_password"

    const val CREATE_USER_TABLE =
        """
        CREATE TABLE IF NOT EXISTS $TABLE_NAME (
        $COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
        $COLUMN_USER_NAME TEXT,
        $COLUMN_USER_PASSWORD TEXT
        );"""

    const val DROP_USER_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"


}

package com.example.library

import android.content.Context
import android.content.SharedPreferences

const val CRED_INFO = "credInfo"

class Cache {

    fun save(context: Context, key: String, value: String) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(CRED_INFO, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun delete(context: Context, key: String) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(CRED_INFO, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }

    fun get(context: Context, key: String): String? {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(CRED_INFO, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, null)
    }


}
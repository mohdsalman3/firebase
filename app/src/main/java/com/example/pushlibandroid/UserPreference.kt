package com.example.pushlibandroid

import android.content.Context
import android.content.SharedPreferences

const val KEY_LOGIN = "key_login"
class UserPreference(context: Context) {
    private  val preferences : SharedPreferences = context.getSharedPreferences(KEY_LOGIN, Context.MODE_PRIVATE)

    fun isLoggedIn():Boolean = preferences.getBoolean(KEY_LOGIN,false)

    fun setLoginState(loginIn:Boolean){
        preferences.edit().putBoolean(KEY_LOGIN,loginIn).apply()
    }
}
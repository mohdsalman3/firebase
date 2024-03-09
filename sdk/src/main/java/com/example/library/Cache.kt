package com.example.library

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


const val CRED_INFO = "credInfo"

internal object Cache {

    private var sharedPreferences: SharedPreferences? = null
    internal const val USER_TOKEN  = "kjdhkwehdkjhaklshncklf"

    fun initPref(applicationContext: Context) {
        val masterKey: MasterKey = MasterKey.Builder(applicationContext)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        sharedPreferences = EncryptedSharedPreferences.create(
            applicationContext,
            "secret_shared_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    }

    fun save(key: String, value: String) {
        val editor: SharedPreferences.Editor? = sharedPreferences?.edit()
        editor?.putString(key, value)
        editor?.apply()
    }

    fun delete(key: String) {
        val editor: SharedPreferences.Editor? = sharedPreferences?.edit()
        editor?.remove(key)
        editor?.apply()
    }

    fun get(key: String): String? {
        return sharedPreferences?.getString(key, null)
    }


}
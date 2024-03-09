package com.example.library

import android.content.Context
import com.example.library.Cache.USER_TOKEN
import com.example.library.callback.ISdkInitCallback
import com.example.library.data.Config

class PushClient {

    companion object {
        private var config: Config? = null
        /**
         * This method will be used for init push client
         */
        fun initPushClient(
            applicationContext: Context,
            config: Config,
            callback: ISdkInitCallback
        ) {
            this.config = config
            Cache.initPref(applicationContext)
            // todo this method will be used for Init push client
        }


        fun saveFCMToken(token: String?) {
            // todo this method will be save Fcm Token  in local database along with it
            //  also call api to save token on server

            Cache.save(USER_TOKEN, token.nullToEmpty())
            saveUserTokenOnServer(token)
        }

        private fun saveUserTokenOnServer(token: String?) {
            // Todo Api Call to server for save fcm token
        }


        internal fun getConfigForSdk():Config?{
            return config
        }

    }
}
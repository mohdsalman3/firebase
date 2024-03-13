package com.example.library


import android.content.Context
import android.widget.Toast
import com.example.library.Cache.USER_TOKEN
import com.example.library.callback.ISdkInitCallback
import com.example.library.data.Config
import com.example.library.data.modal.NotificationRequest
import com.example.library.viewmodel.NotificationViewModel

class PushClient {


    companion object {
        private var config: Config? = null
       private val viewModel= NotificationViewModel()

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

        fun showToast(applicationContext: Context,message:String?){
            Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
        }


        fun saveFCMToken(token: String?) {
            // todo this method will be save Fcm Token  in local database along with it
            //  also call api to save token on server

            Cache.save(USER_TOKEN, token.nullToEmpty())
            saveUserTokenOnServer(token)
        }

        private fun saveUserTokenOnServer(token: String?) {
            val request = token?.let {
                NotificationRequest(
                    appId = "com.example.pushlibandroid",
                    identifier = config?.configKey.nullToEmpty(),
                    token= it,
                    platform = "android"
                )
            }
            // Todo Api Call to server for save fcm token
            if (request != null) {
                viewModel.postNotification(request)
            }



        }


        internal fun getConfigForSdk():Config?{
            return config
        }

    }
}
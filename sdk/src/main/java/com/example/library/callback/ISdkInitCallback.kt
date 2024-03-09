package com.example.library.callback

import java.lang.Error

/**
 *  Created by ankur.khandelwal on 08/03/24
 *
 */
interface ISdkInitCallback {

    fun onSuccess()

    fun onError(error: String)
}
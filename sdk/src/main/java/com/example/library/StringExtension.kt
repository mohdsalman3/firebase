package com.example.library

/**
 *  Created by ankur.khandelwal on 08/03/24
 *
 */
const val EMPTY = ""

fun String?.nullToEmpty() = this ?: EMPTY
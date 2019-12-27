package com.shekharkg.tml_todo.extension

import java.text.SimpleDateFormat
import java.util.*


fun Long.toDateTime(): String {
    val format = SimpleDateFormat("MMM dd', 'HH:mm:", Locale.US)
    return format.format(this)
}
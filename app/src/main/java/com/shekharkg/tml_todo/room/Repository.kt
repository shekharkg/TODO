package com.shekharkg.tml_todo.room

import android.app.Application

class Repository private constructor(private val application: Application) {

    // For Singleton instantiation
    companion object {
        @Volatile
        private var sInstance: Repository? = null

        fun getInstance(application: Application) = sInstance ?: synchronized(this) {
            sInstance ?: Repository(application).also { sInstance = it }
        }
    }

}
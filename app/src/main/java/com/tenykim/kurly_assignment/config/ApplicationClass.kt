package com.tenykim.kurly_assignment.config

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {
    companion object {
        // GitHub API URL
        const val GITHUB_URL = "https://api.github.com"

        lateinit var retrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()

        // App
        retrofit = Retrofit.Builder()
            .baseUrl(GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

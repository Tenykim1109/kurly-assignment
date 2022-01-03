package com.tenykim.kurly_assignment.util

import com.tenykim.kurly_assignment.config.ApplicationClass
import com.tenykim.kurly_assignment.src.api.GithubApi

class RetrofitUtil {
    companion object {
        val repositoryService = ApplicationClass.retrofit.create(GithubApi::class.java)
    }
}
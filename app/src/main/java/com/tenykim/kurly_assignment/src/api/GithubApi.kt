package com.tenykim.kurly_assignment.src.api

import com.tenykim.kurly_assignment.src.data.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GithubApi {

    @Headers(
        "Accept: application/vnd.github.v3+json"
    )
    @GET("/search/repositories")
    fun searchRepositories(@Query("q") q: String) : Call<Repository>
}
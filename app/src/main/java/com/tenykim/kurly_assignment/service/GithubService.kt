package com.tenykim.kurly_assignment.service

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tenykim.kurly_assignment.util.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import values.GithubResponse


class GithubService {
    private val TAG = "GithubService_MJ"

    fun getRepository(query: String) : MutableLiveData<GithubResponse> {
        val responseLiveData: MutableLiveData<GithubResponse> = MutableLiveData()

        RetrofitUtil.repositoryService.searchRepositories(query).enqueue(object : Callback<GithubResponse> {
            override fun onResponse(call: Call<GithubResponse>, response: Response<GithubResponse>) {
                if (response.code() == 200) {
                    Log.d(TAG, "response = ${response.body()}")
                    responseLiveData.value = response.body() as GithubResponse
                } else {
                    Log.d(TAG, "Search Repository: Error code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                Log.e(TAG, "Failed")
            }
        })

        return responseLiveData
    }
}
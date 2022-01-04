package com.tenykim.kurly_assignment.src.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tenykim.kurly_assignment.databinding.ActivityMainBinding
import com.tenykim.kurly_assignment.service.GithubService
import com.tenykim.kurly_assignment.src.data.Item

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var repoList: MutableList<Item>
    private lateinit var repoAdapter: RepositoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.search.setOnClickListener {
            val q = binding.keyword.text.toString()

            // 검색할 때마다 새로운 결과를 보여주기 위함
            repoList = mutableListOf()

            // LiveData 사용
            val response = GithubService().getRepository(q)
            response.observe(this, { response ->
                response.items.let {
                    for (item in it) {
                        repoList.add(item)
                    }
                }

                repoAdapter = RepositoryListAdapter(repoList)
                binding.viewResult.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = repoAdapter
                }

                if (repoAdapter.itemCount == 0) {
                    Toast.makeText(this, "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show()
                }
            })

            // EditText clear
            binding.keyword.text.clear()
        }
    }
}
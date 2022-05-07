package com.example.aplikasigit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser:RecyclerView
    private val list=ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser=findViewById(R.id.rv_users)
        rvUser.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val listHero = ArrayList<User>()
            for (i in dataUsername.indices) {
                val hero = User(dataUsername[i],dataName[i],dataLocation[i],dataRepository[i],dataCompany[i],dataFollowers[i],dataFollowing[i], dataAvatar.getResourceId(i, -1))
                listHero.add(hero)
            }
            return listHero
        }

    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                sendSelectedHero(data)
            }
        })
    }

    private fun sendSelectedHero(user: User) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_USER, user)
        startActivity(intent)
    }
}
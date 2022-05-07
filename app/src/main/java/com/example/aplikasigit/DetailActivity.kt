package com.example.aplikasigit

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_USER="extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val tvUsername:TextView=findViewById(R.id.tv_detail_usernama)
        val tvName:TextView=findViewById(R.id.tv_detail_nama)
        val tvLocation:TextView=findViewById(R.id.tv_location)
        val tvRepo:TextView=findViewById(R.id.tv_repo)
        val tvCompany:TextView=findViewById(R.id.tv_company)
        val tvFollowers:TextView=findViewById(R.id.tv_follower)
        val tvFollowing:TextView=findViewById(R.id.tv_following)
        val imgAvatar:ImageView=findViewById(R.id.img_avatar)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        tvUsername.text="@"+user.username
        tvName.text=user.name
        tvLocation.text=user.location
        println(user.repository)
        tvRepo.text=user.repository
        tvCompany.text=user.company
        tvFollowers.text=user.followers
        tvFollowing.text=user.following
        Glide.with(this)
            .load(user.avatar)
            .placeholder(R.drawable.cat_svgrepo_com)
            .into(imgAvatar)

    }
}
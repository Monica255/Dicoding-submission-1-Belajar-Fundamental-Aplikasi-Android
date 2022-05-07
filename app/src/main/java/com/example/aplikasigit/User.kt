package com.example.aplikasigit

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var username: String,
    var name: String,
    var location:String,
    var repository:String,
    var company:String,
    var followers:String,
    var following:String,
    var avatar:Int
):Parcelable

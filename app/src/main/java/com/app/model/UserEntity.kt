package com.app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserEntity(val userId : Int,
                      val userName : String,
                      val userDistance : Int) : Parcelable
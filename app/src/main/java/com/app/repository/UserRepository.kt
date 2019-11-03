package com.app.repository

import android.app.Application
import com.app.helper.DistanceCalculatorHelper
import com.app.helper.JsonReaderHelper
import com.app.model.UserEntity
import com.app.utils.Constants.Companion.SOURCE_LATITUDE
import com.app.utils.Constants.Companion.SOURCE_LONGITUDE
import com.app.utils.Constants.Companion.USER_ID
import com.app.utils.Constants.Companion.USER_LATITUDE
import com.app.utils.Constants.Companion.USER_LONGITUDE
import com.app.utils.Constants.Companion.USER_NAME
import org.json.JSONArray
import java.util.ArrayList

class UserRepository(private val context : Application) {

    fun getUserListAsync() : ArrayList<UserEntity> {

        val response = JsonReaderHelper.readJSONFile(context)

        val jsonArray = JSONArray(response)

        val userArrayList : ArrayList<UserEntity> = ArrayList()

        if(jsonArray.length() >= 1) {

            for(i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val latitude : String = jsonObject.getString(USER_LATITUDE)
                val longitude : String = jsonObject.getString(USER_LONGITUDE)
                val userId : Int = jsonObject.getInt(USER_ID)
                val userName : String = jsonObject.getString(USER_NAME)

                val distance : Int = DistanceCalculatorHelper.getDistance(SOURCE_LATITUDE,SOURCE_LONGITUDE
                    ,latitude.toDouble(),longitude.toDouble())

                if(distance < 100) {
                    val userEntity = UserEntity(userId,userName,distance)
                    userArrayList.add(userEntity)
                }
            }
        }

        return userArrayList
    }

}
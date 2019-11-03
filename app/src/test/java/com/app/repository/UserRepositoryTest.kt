package com.app.repository

import com.app.helper.JsonReaderTest
import com.app.model.UserEntity
import com.app.utils.ConstantsTest.Companion.USER_ID_TAG
import com.app.utils.ConstantsTest.Companion.USER_NAME_TAG
import com.app.utils.ConstantsTest.Companion.USER_DATA_SIZE
import com.app.utils.ConstantsTest.Companion.USER_ID
import com.app.utils.ConstantsTest.Companion.USER_NAME
import org.json.JSONArray
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.ArrayList

@RunWith(JUnit4::class)
class UserRepositoryTest {

    private var userArrayList : ArrayList<UserEntity> = ArrayList()

    @Before
    fun setUp()
    {
        try
        {
            val response = JsonReaderTest.readJSONFile()

            val jsonArray = JSONArray(response)

            if(jsonArray.length() >= 1) {

                for(i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val userId : Int = jsonObject.getInt(USER_ID_TAG)
                    val userName : String = jsonObject.getString(USER_NAME_TAG)

                    val userEntity = UserEntity(userId,userName,0)
                    userArrayList.add(userEntity)
                }
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test
    fun `get near-by customer and succeed`() {

        assertEquals(USER_DATA_SIZE, userArrayList.size)
        assertEquals(USER_ID,userArrayList[4].userId)

        assertTrue(userArrayList[1].userName == USER_NAME)
        assertTrue(userArrayList[5].userDistance == 0)

        assertNotNull("", userArrayList[1].userName)

        assertFalse(userArrayList[1].userDistance == 100)
    }
}
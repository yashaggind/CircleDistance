package com.app.helper

import com.app.utils.ConstantsTest.Companion.DEGREE
import com.app.utils.ConstantsTest.Companion.MILES
import com.app.utils.ConstantsTest.Companion.RADIAN
import com.app.utils.ConstantsTest.Companion.SOURCE_LATITUDE_TAG
import com.app.utils.ConstantsTest.Companion.SOURCE_LONGITUDE_TAG
import com.app.utils.ConstantsTest.Companion.USER_LATITUDE_TAG
import com.app.utils.ConstantsTest.Companion.USER_LONGITUDE_TAG
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DistanceCalculatorTest {

    @Test
    fun `calculate customer distance`() {

        DistanceCalculatorHelper.getDistance(SOURCE_LATITUDE_TAG,SOURCE_LONGITUDE_TAG,
            USER_LATITUDE_TAG,USER_LONGITUDE_TAG)
    }

    @Test
    fun `convert distance into Radians`() {
        DistanceCalculatorHelper.distanceInRadians(SOURCE_LATITUDE_TAG,SOURCE_LONGITUDE_TAG,
            USER_LATITUDE_TAG,USER_LONGITUDE_TAG)
    }

    @Test
    fun `convert Radian into Degree`() {
        DistanceCalculatorHelper.convertIntoDegree(RADIAN)
    }

    @Test
    fun `convert degree into Miles`() {
        DistanceCalculatorHelper.convertIntoMiles(DEGREE)
    }

    @Test
    fun `convert miles into Kms`() {
        DistanceCalculatorHelper.convertIntoKms(MILES)
    }
}
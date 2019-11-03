package com.app.helper

import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

object DistanceCalculatorHelper {

    fun getDistance(sourceLat : Double, sourceLong : Double,
                    destLat : Double, destLong : Double) : Int {

        // get distance in radians
        val radian = distanceInRadians(
            Math.toRadians(sourceLat), Math.toRadians(sourceLong),
            Math.toRadians(destLat), Math.toRadians(destLong)
        )

        val degree = convertIntoDegree(radian)

        // each degree on a great circle of Earth is 60 nautical miles
        val miles : Double = convertIntoMiles(degree)

        return convertIntoKms(miles)
    }

    /**
     * Method to get distance in radians
     * @param sourceLat,
     * @param sourceLong,
     * @param destLat,
     * @param destLong
     * @return
     */

    fun distanceInRadians(
        sourceLat: Double, sourceLong: Double
        , destLat: Double, destLong: Double
    ): Double {
        return acos(
            sin(sourceLat) * sin(destLat) + cos(sourceLat) * cos(destLat) * cos(
                sourceLong - destLong
            )
        )
    }

    /**
     * Method to get distance in radians and convert into degree
     * @param radian
     * @return
     */

    fun convertIntoDegree(radian: Double): Double = Math.toDegrees(radian)

    /**
     * Method to get distance in degree and convert into miles
     * @param degree
     * @return
     */

    fun convertIntoMiles(degree: Double): Double = 60 * degree

    /**
     * Method to get distance in miles and convert into Kilometers
     * @param miles
     * @return
     */

    fun convertIntoKms(miles: Double): Int = (1.609 * miles).toInt()
}
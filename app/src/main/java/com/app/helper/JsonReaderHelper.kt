package com.app.helper

import android.app.Application
import com.app.utils.Constants
import java.io.InputStream

object JsonReaderHelper {

    fun readJSONFile(context : Application) : String
    {
        val inputStream : InputStream = context.assets.open(Constants.JSON_FILE_NAME)
        val size : Int = inputStream.available()

        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        return String(buffer)
    }
}
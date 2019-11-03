package com.app.helper

import com.app.utils.ConstantsTest.Companion.JSON_FILE_NAME
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

object JsonReaderTest
{
    @Throws(IOException::class)
    fun readJSONFile(): String
    {
        val assetBasePath = "src/test/assets/"
        val fileName = JSON_FILE_NAME
        val br = BufferedReader(InputStreamReader(FileInputStream(assetBasePath + fileName)))
        val sb = StringBuilder()
        var line: String? = br.readLine()
        while (line != null)
        {
            sb.append(line)
            line = br.readLine()
        }

        return sb.toString()
    }
}

package io.kotlin.kotlinclean.feed.test

import com.squareup.moshi.JsonReader
import okio.Buffer
import java.io.FileInputStream
import java.io.IOException
import java.nio.file.Paths

class TestResources {

    companion object {
        @Throws(IOException::class)
        fun jsonReaderFrom(jsonPath: String): JsonReader {
            val file = Paths.get("./core/src/test/resources/$jsonPath").toFile()
            val fileInputStream = FileInputStream(file)
            return JsonReader.of(Buffer().readFrom(fileInputStream))
        }
    }
}

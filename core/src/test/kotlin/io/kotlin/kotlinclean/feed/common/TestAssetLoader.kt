package io.kotlin.kotlinclean.feed.common

import io.kotlin.kotlinclean.common.AssetLoader
import java.io.FileInputStream
import java.io.InputStream
import java.nio.file.Paths

class TestAssetLoader : AssetLoader {

    override fun loadAsset(assetName: String): InputStream {
        val file = Paths.get("build/resources/test/$assetName").toFile()
        return FileInputStream(file)
    }

}

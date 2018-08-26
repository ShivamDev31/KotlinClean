package io.kotlin.kotlinclean.common

import android.content.Context
import java.io.IOException
import java.io.InputStream

class AndroidAssetLoader(private val context: Context): AssetLoader {

    @Throws(IOException::class)
    override fun loadAsset(assetName: String): InputStream {
        return context.assets.open(assetName)
    }

}

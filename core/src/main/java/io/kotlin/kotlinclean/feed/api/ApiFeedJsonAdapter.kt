package io.kotlin.kotlinclean.feed.api

import com.squareup.moshi.*

class ApiFeedJsonAdapter(private val mediaAdapter: JsonAdapter<List<ApiMedia>>) : JsonAdapter<ApiFeed>() {
    override fun fromJson(reader: JsonReader): ApiFeed {
        val componentJson: Map<String, Any> = reader.readJsonValue() as Map<String, Any>
        val type = componentJson["type"] as String

        return when (type) {
            "Ad" -> {
                readAd(componentJson)
            }
            "Tip" -> {
                readTip(componentJson)
            }
            "Question" -> {
                readQuestion(componentJson)
            }
            "Quiz" -> {
                readQuiz(componentJson)
            }
            else -> ApiFeed.UNKNOWN
        }

    }

    private fun readAd(componentJson: Map<String, Any>): ApiFeed {
        val code = componentJson["code"] as Int
        val title = componentJson["title"] as String
        val body = componentJson["body"] as String
        val tag = componentJson["tag"] as String
        val supportText = componentJson["supportText"] as String
        val mediaList = mediaAdapter.fromJsonValue(componentJson["mediaList"])
        return ApiAdFeed(code, title, body, tag, supportText, mediaList)
    }

    private fun readTip(componentJson: Map<String, Any>): ApiFeed {
        val code = componentJson["code"] as Int
        val title = componentJson["title"] as String
        val body = componentJson["body"] as String
        val tag = componentJson["tag"] as String
        val supportText = componentJson["supportText"] as String
        val mediaList = mediaAdapter.fromJsonValue(componentJson["mediaList"])
        return ApiTipFeed(code, title, body, tag, supportText, mediaList)
    }

    private fun readQuestion(componentJson: Map<String, Any>): ApiFeed {
        val code = componentJson["code"] as Int
        val title = componentJson["title"] as String
        val body = componentJson["body"] as String
        val tag = componentJson["tag"] as String
        val supportText = componentJson["supportText"] as String
        val mediaList = mediaAdapter.fromJsonValue(componentJson["mediaList"])
        return ApiQuestionsFeed(code, title, body, tag, supportText, mediaList)
    }

    private fun readQuiz(componentJson: Map<String, Any>): ApiFeed {
        val code = componentJson["code"] as Int
        val title = componentJson["title"] as String
        val body = componentJson["body"] as String
        val tag = componentJson["tag"] as String
        val supportText = componentJson["supportText"] as String
        val mediaList = mediaAdapter.fromJsonValue(componentJson["mediaList"])
        return ApiQuizFeed(code, title, body, tag, supportText, mediaList)
    }

    override fun toJson(writer: JsonWriter?, value: ApiFeed?) {
        throw UnsupportedOperationException("JSON serialization is not implemented yet")
    }

    companion object {
        fun from(moshi: Moshi): ApiFeedJsonAdapter {
            val mediaJsonAdapter: JsonAdapter<List<ApiMedia>> = moshi.adapter(Types.newParameterizedType(List::class.java, ApiMedia::class.java))
            return ApiFeedJsonAdapter(mediaJsonAdapter)
        }
    }

}

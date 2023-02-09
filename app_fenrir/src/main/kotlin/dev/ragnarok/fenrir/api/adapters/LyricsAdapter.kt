package dev.ragnarok.fenrir.api.adapters

import dev.ragnarok.fenrir.api.model.VKApiLyrics
import dev.ragnarok.fenrir.nonNullNoEmpty
import dev.ragnarok.fenrir.util.AppTextUtils
import dev.ragnarok.fenrir.util.serializeble.json.JsonElement

class LyricsAdapter : AbsAdapter<VKApiLyrics>("VKApiLyrics") {
    @Throws(Exception::class)
    override fun deserialize(
        json: JsonElement
    ): VKApiLyrics {
        if (!checkObject(json)) {
            throw Exception("$TAG error parse object")
        }
        val response = VKApiLyrics()
        val root = json.asJsonObject
        if (hasObject(root, "lyrics")) {
            root["lyrics"]?.asJsonObject?.let {
                val str = StringBuilder()
                if (hasArray(it, "text")) {
                    for (s in it["text"]?.asJsonArray.orEmpty()) {
                        str.append(s.asPrimitiveSafe?.content.orEmpty()).append("\r\n")
                    }
                }
                if (hasArray(it, "timestamps")) {
                    for (s in it["timestamps"]?.asJsonArray.orEmpty()) {
                        if (!checkObject(s)) {
                            continue
                        }
                        val begin = optInt(s, "begin", 0)
                        val end = optInt(s, "end", 0)
                        str.append("[").append(AppTextUtils.getDurationStringMS(begin))
                            .append(" - ").append(AppTextUtils.getDurationStringMS(end))
                            .append("] ")
                            .append(optString(s, "line").orEmpty())
                            .append("\r\n")
                    }
                }
                if (str.isNotEmpty()) {
                    response.text = str.toString()
                }
            }
        }
        response.text?.let {
            val op = optString(root, "credits")
            if (op.nonNullNoEmpty()) {
                response.text += "\r\n" + op
            }
        }
        return response
    }

    companion object {
        private val TAG = LyricsAdapter::class.java.simpleName
    }
}
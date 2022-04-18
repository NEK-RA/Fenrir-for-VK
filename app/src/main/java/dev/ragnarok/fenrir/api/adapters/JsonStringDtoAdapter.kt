package dev.ragnarok.fenrir.api.adapters

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import dev.ragnarok.fenrir.api.model.VKApiJsonString
import java.lang.reflect.Type

class JsonStringDtoAdapter : AbsAdapter(), JsonDeserializer<VKApiJsonString> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): VKApiJsonString {
        val story = VKApiJsonString()
        if (!checkObject(json)) {
            return story
        }
        val root = json.asJsonObject
        story.json_data = root.toString()
        return story
    }
}
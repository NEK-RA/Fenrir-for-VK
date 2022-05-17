package dev.ragnarok.fenrir.api.model.upload

import com.google.gson.annotations.SerializedName

class UploadPhotoToMessageDto {
    @SerializedName("server")
    var server = 0

    @SerializedName("photo")
    var photo: String? = null

    @SerializedName("hash")
    var hash: String? = null
    override fun toString(): String {
        return "UploadPhotoToMessageDto{" +
                "server=" + server +
                ", photo='" + photo + '\'' +
                ", hash='" + hash + '\'' +
                '}'
    }
}
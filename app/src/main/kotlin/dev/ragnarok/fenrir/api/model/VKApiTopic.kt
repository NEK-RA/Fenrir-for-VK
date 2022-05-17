package dev.ragnarok.fenrir.api.model

/**
 * An audio object describes an audio file and contains the following fields.
 */
class VKApiTopic : Commentable {
    var id = 0
    var owner_id = 0
    var title: String? = null
    var created: Long = 0
    var created_by = 0
    var updated: Long = 0
    var updated_by = 0
    var is_closed = false
    var is_fixed = false
    var comments: CommentsDto? = null
    var first_comment: String? = null
    var last_comment: String? = null
}
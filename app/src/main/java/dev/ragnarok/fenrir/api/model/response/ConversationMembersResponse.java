package dev.ragnarok.fenrir.api.model.response;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import dev.ragnarok.fenrir.api.model.VKApiCommunity;
import dev.ragnarok.fenrir.api.model.VKApiConversationMembers;
import dev.ragnarok.fenrir.api.model.VKApiUser;

public class ConversationMembersResponse {

    @Nullable
    @SerializedName("items")
    public List<VKApiConversationMembers> conversationMembers;

    @Nullable
    @SerializedName("profiles")
    public List<VKApiUser> profiles;

    @Nullable
    @SerializedName("groups")
    public List<VKApiCommunity> groups;
}

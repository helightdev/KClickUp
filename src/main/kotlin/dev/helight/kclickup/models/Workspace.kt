package dev.helight.kclickup.models


import com.google.gson.annotations.SerializedName

data class Workspace(
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("color")
    val color: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("members")
    val members: List<Member>,
    @SerializedName("name")
    val name: String,
    @SerializedName("roles")
    val roles: List<Role>
) {
    data class Member (
        @SerializedName("user")
        val user: User
    )


}


package dev.helight.kclickup.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("color")
    val color: String?,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("initials")
    val initials: String,
    @SerializedName("profilePicture")
    val profilePicture: String,
    @SerializedName("role")
    val role: Int,
    @SerializedName("username")
    val username: String
)
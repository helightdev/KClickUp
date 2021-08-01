package dev.helight.kclickup.models

import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("custom")
    val custom: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("inherited_role")
    val inheritedRole: Int,
    @SerializedName("name")
    val name: String
)
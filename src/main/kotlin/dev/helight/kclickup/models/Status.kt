package dev.helight.kclickup.models

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("color")
    val color: String?,
    @SerializedName("orderindex")
    val orderindex: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("type")
    val type: String?
)
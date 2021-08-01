package dev.helight.kclickup.models

import com.google.gson.annotations.SerializedName

data class TaskPriority(
    @SerializedName("color")
    val color: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("orderindex")
    val orderindex: String,
    @SerializedName("priority")
    val priority: String
)
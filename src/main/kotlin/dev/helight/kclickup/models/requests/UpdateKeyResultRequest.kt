package dev.helight.kclickup.models.requests


import com.google.gson.annotations.SerializedName

data class UpdateKeyResultRequest(
    @SerializedName("note")
    val note: String? = null,
    @SerializedName("steps_current")
    val stepsCurrent: Double
)
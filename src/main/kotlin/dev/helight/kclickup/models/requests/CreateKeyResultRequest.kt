package dev.helight.kclickup.models.requests


import com.google.gson.annotations.SerializedName

data class CreateKeyResultRequest(
    @SerializedName("list_ids")
    val listIds: List<Any> = listOf(),
    @SerializedName("name")
    val name: String,
    @SerializedName("owners")
    val owners: List<Int> = listOf(),
    @SerializedName("steps_end")
    val stepsEnd: Double = 1.0,
    @SerializedName("steps_start")
    val stepsStart: Double = 0.0,
    @SerializedName("task_ids")
    val taskIds: List<Any> = listOf(),
    @SerializedName("type")
    val type: String = "number",
    @SerializedName("unit")
    val unit: String? = null
)
package dev.helight.kclickup.models.requests


import com.google.gson.annotations.SerializedName

data class TaskUpdateRequest(
    @SerializedName("archived")
    val archived: Boolean? = null,
    @SerializedName("assignees")
    val assignees: Assignees? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("priority")
    val priority: Int? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("time_estimate")
    val timeEstimate: Int? = null
) {
    data class Assignees(
        @SerializedName("add")
        val add: List<Int> = listOf(),
        @SerializedName("rem")
        val rem: List<Int> = listOf()
    )
}
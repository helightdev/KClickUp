package dev.helight.kclickup.models.requests


import com.google.gson.annotations.SerializedName

data class TaskCreateRequest(
    @SerializedName("assignees")
    val assignees: List<Int> = listOf(),
    @SerializedName("check_required_custom_fields")
    val checkRequiredCustomFields: Boolean = false,
    @SerializedName("custom_fields")
    val customFields: List<CustomField> = listOf(),
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("due_date")
    val dueDate: Long? = null,
    @SerializedName("due_date_time")
    val dueDateTime: Boolean = false,
    @SerializedName("links_to")
    val linksTo: String? = null,
    @SerializedName("name")
    val name: String,
    @SerializedName("notify_all")
    val notifyAll: Boolean = true,
    @SerializedName("parent")
    val parent: String? = null,
    @SerializedName("priority")
    val priority: Int? = null,
    @SerializedName("start_date")
    val startDate: Long? = null,
    @SerializedName("start_date_time")
    val startDateTime: Boolean = false,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("tags")
    val tags: List<String> = listOf(),
    @SerializedName("time_estimate")
    val timeEstimate: Int? = null,
) {
    data class CustomField(
        @SerializedName("id")
        val id: String,
        @SerializedName("value")
        val value: Any?
    )
}
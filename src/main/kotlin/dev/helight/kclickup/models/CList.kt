package dev.helight.kclickup.models

import com.google.gson.annotations.SerializedName

data class CList(
    @SerializedName("assignee")
    val assignee: Any?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("due_date")
    val dueDate: String?,
    @SerializedName("due_date_time")
    val dueDateTime: Boolean?,
    @SerializedName("folder")
    val folder: ReducedFolder?,
    @SerializedName("id")
    val id: String,
    @SerializedName("inbound_address")
    val inboundAddress: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("orderindex")
    val orderindex: Int,
    @SerializedName("priority")
    val priority: Priority?,
    @SerializedName("space")
    val space: Space,
    @SerializedName("start_date")
    val startDate: String?,
    @SerializedName("start_date_time")
    val startDateTime: Boolean?,
    @SerializedName("status")
    val status: ListStatus?,
    @SerializedName("statuses")
    val statuses: List<TaskPriority>,
    @SerializedName("task_count")
    val taskCount: Int?
) {
    data class ReducedFolder(
        @SerializedName("access")
        val access: Boolean,
        @SerializedName("hidden")
        val hidden: Boolean,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    )

    data class ListStatus(
        @SerializedName("status")
        val status: String,
        @SerializedName("color")
        val color: String
    )

    data class Priority(
        @SerializedName("color")
        val color: String,
        @SerializedName("priority")
        val priority: String
    )

}
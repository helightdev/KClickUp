package dev.helight.kclickup.models

import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.ClickUpClient

data class Folder(
    @SerializedName("hidden")
    val hidden: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("lists")
    val lists: List<Any>,
    @SerializedName("name")
    val name: String,
    @SerializedName("orderindex")
    val orderindex: Int,
    @SerializedName("override_statuses")
    val overrideStatuses: Boolean,
    @SerializedName("space")
    val space: ReducedSpace,
    @SerializedName("task_count")
    val taskCount: String
) {
    data class ReducedSpace(
        @SerializedName("access")
        val access: Boolean,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    )

    fun space(client: ClickUpClient): Space = client.getSpace(space.id)
}
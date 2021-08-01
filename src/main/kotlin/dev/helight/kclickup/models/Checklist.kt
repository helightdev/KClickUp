package dev.helight.kclickup.models


import com.google.gson.annotations.SerializedName

data class Checklist(
    @SerializedName("creator")
    val creator: Int,
    @SerializedName("date_created")
    val dateCreated: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("name")
    val name: String,
    @SerializedName("orderindex")
    val orderindex: Int,
    @SerializedName("resolved")
    val resolved: Int,
    @SerializedName("task_id")
    val taskId: String,
    @SerializedName("unresolved")
    val unresolved: Int
) {
    data class Item(
        @SerializedName("assignee")
        val assignee: Any?,
        @SerializedName("children")
        val children: List<Any>,
        @SerializedName("date_created")
        val dateCreated: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("orderindex")
        val orderindex: Int,
        @SerializedName("parent")
        val parent: Any?,
        @SerializedName("resolved")
        val resolved: Boolean
    )
}
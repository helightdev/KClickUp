package dev.helight.kclickup.models


import com.google.gson.annotations.SerializedName

data class KeyResult(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("creator")
    val creator: Int,
    @SerializedName("date_created")
    val dateCreated: String,
    @SerializedName("goal_id")
    val goalId: String,
    @SerializedName("goal_pretty_id")
    val goalPrettyId: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("last_action")
    val lastAction: LastAction,
    @SerializedName("name")
    val name: String,
    @SerializedName("owners")
    val owners: List<User>,
    @SerializedName("percent_completed")
    val percentCompleted: Int?,
    @SerializedName("subcategory_ids")
    val subcategoryIds: List<Any>,
    @SerializedName("task_ids")
    val taskIds: List<Any>,
    @SerializedName("type")
    val type: String,
    @SerializedName("unit")
    val unit: String
) {
    data class LastAction(
        @SerializedName("date_modified")
        val dateModified: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("key_result_id")
        val keyResultId: String,
        @SerializedName("note")
        val note: String,
        @SerializedName("steps_before")
        val stepsBefore: Double?,
        @SerializedName("steps_current")
        val stepsCurrent: Double?,
        @SerializedName("steps_taken")
        val stepsTaken: Double?,
        @SerializedName("userid")
        val userid: Int
    )
}
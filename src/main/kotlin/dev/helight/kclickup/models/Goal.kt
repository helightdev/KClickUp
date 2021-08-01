package dev.helight.kclickup.models


import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.ClickUpClient

data class Goal(
    @SerializedName("archived")
    val archived: Boolean,
    @SerializedName("color")
    val color: String,
    @SerializedName("creator")
    val creator: Int,
    @SerializedName("date_created")
    val dateCreated: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("due_date")
    val dueDate: String,
    @SerializedName("folder_id")
    val folderId: Any?,
    @SerializedName("history")
    val history: List<Any>,
    @SerializedName("id")
    val id: String,
    @SerializedName("key_results")
    val keyResults: List<KeyResult>?,
    @SerializedName("members")
    val members: List<User>,
    @SerializedName("multiple_owners")
    val multipleOwners: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("owners")
    val owners: List<User>,
    @SerializedName("percent_completed")
    val percentCompleted: Int,
    @SerializedName("pretty_id")
    val prettyId: String,
    @SerializedName("pretty_url")
    val prettyUrl: String,
    @SerializedName("private")
    val `private`: Boolean,
    @SerializedName("start_date")
    val startDate: String?,
    @SerializedName("team_id")
    val teamId: String
) {
    fun renew(client: ClickUpClient): Goal {
        return client.getGoal(id)
    }
}
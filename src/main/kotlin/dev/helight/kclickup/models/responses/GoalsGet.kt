package dev.helight.kclickup.models.responses


import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.models.Goal
import dev.helight.kclickup.models.User

data class GoalsGet(
    @SerializedName("folders")
    val folders: List<GoalFolder>,
    @SerializedName("goals")
    val goals: List<Goal>
) {
    data class GoalFolder(
        @SerializedName("creator")
        val creator: Int,
        @SerializedName("date_created")
        val dateCreated: String,
        @SerializedName("goal_count")
        val goalCount: Int,
        @SerializedName("goals")
        val goals: List<Goal>,
        @SerializedName("id")
        val id: String,
        @SerializedName("members")
        val members: List<User>,
        @SerializedName("name")
        val name: String,
        @SerializedName("private")
        val `private`: Boolean,
        @SerializedName("team_id")
        val teamId: String
    )
}
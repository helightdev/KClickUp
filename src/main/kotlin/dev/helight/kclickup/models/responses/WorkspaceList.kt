package dev.helight.kclickup.models.responses


import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.models.Workspace

data class WorkspaceList(
    @SerializedName("teams")
    val teams: List<Workspace>
)
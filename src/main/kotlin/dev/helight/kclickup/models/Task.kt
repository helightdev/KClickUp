package dev.helight.kclickup.models


import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("archived")
    val archived: Boolean,
    @SerializedName("assignees")
    val assignees: List<User>,
    @SerializedName("checklists")
    val checklists: List<Checklist>,
    @SerializedName("creator")
    val creator: User,
    @SerializedName("custom_fields")
    val customFields: List<CustomField>,
    @SerializedName("custom_id")
    val customId: String?,
    @SerializedName("date_closed")
    val dateClosed: String?,
    @SerializedName("date_created")
    val dateCreated: String,
    @SerializedName("date_updated")
    val dateUpdated: String?,
    /*
    @SerializedName("dependencies")
    val dependencies: List<Any>,
     */
    @SerializedName("description")
    val description: String,
    @SerializedName("due_date")
    val dueDate: String?,
    @SerializedName("folder")
    val folder: FolderReduced,
    @SerializedName("id")
    val id: String,
    @SerializedName("linked_tasks")
    val linkedTasks: List<Any>,
    @SerializedName("list")
    val list: CList,
    @SerializedName("name")
    val name: String,
    @SerializedName("orderindex")
    val orderindex: String,
    @SerializedName("parent")
    val parent: String?,
    @SerializedName("permission_level")
    val permissionLevel: String,
    @SerializedName("points")
    val points: Int,
    @SerializedName("priority")
    val priority: TaskPriority?,
    @SerializedName("project")
    val project: ProjectReduced,
    @SerializedName("space")
    val space: IdSpace,
    @SerializedName("start_date")
    val startDate: String?,
    @SerializedName("status")
    val status: Status,
    /*
    @SerializedName("tags")
    val tags: List<Any>,
    */
    @SerializedName("team_id")
    val teamId: String,
    @SerializedName("text_content")
    val textContent: String,
    /*
    @SerializedName("time_estimate")
    val timeEstimate: Any?,
    */
    @SerializedName("url")
    val url: String,
    @SerializedName("watchers")
    val watchers: List<User>
) {

    data class CustomField(
        @SerializedName("date_created")
        val dateCreated: String,
        @SerializedName("hide_from_guests")
        val hideFromGuests: Boolean,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("required")
        val required: Boolean,
        @SerializedName("type")
        val type: String,
        @SerializedName("type_config")
        val typeConfig: TypeConfig,
        @SerializedName("value")
        val value: String
    ) {
        data class TypeConfig(
            @SerializedName("include_guests")
            val includeGuests: Boolean,
            @SerializedName("include_team_members")
            val includeTeamMembers: Boolean
        )
    }

    data class FolderReduced(
        @SerializedName("access")
        val access: Boolean,
        @SerializedName("hidden")
        val hidden: Boolean,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    )

    data class ProjectReduced(
        @SerializedName("access")
        val access: Boolean,
        @SerializedName("hidden")
        val hidden: Boolean,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    )

    data class IdSpace(
        @SerializedName("id")
        val id: String
    )

}
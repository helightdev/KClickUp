package dev.helight.kclickup.models


import com.google.gson.annotations.SerializedName

data class Space(
    @SerializedName("features")
    val features: Features,
    @SerializedName("id")
    val id: String,
    @SerializedName("multiple_assignees")
    val multipleAssignees: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("private")
    val `private`: Boolean,
    @SerializedName("statuses")
    val statuses: List<Status>
) {
    data class Features(
        @SerializedName("checklists")
        val checklists: Checklists,
        @SerializedName("custom_fields")
        val customFields: CustomFields,
        @SerializedName("dependency_warning")
        val dependencyWarning: DependencyWarning,
        @SerializedName("due_dates")
        val dueDates: DueDates,
        @SerializedName("portfolios")
        val portfolios: Portfolios,
        @SerializedName("remap_dependencies")
        val remapDependencies: RemapDependencies,
        @SerializedName("tags")
        val tags: Tags,
        @SerializedName("time_estimates")
        val timeEstimates: TimeEstimates,
        @SerializedName("time_tracking")
        val timeTracking: TimeTracking
    ) {
        data class Checklists(
            @SerializedName("enabled")
            val enabled: Boolean
        )

        data class CustomFields(
            @SerializedName("enabled")
            val enabled: Boolean
        )

        data class DependencyWarning(
            @SerializedName("enabled")
            val enabled: Boolean
        )

        data class DueDates(
            @SerializedName("enabled")
            val enabled: Boolean,
            @SerializedName("remap_closed_due_date")
            val remapClosedDueDate: Boolean,
            @SerializedName("remap_due_dates")
            val remapDueDates: Boolean,
            @SerializedName("start_date")
            val startDate: Boolean
        )

        data class Portfolios(
            @SerializedName("enabled")
            val enabled: Boolean
        )

        data class RemapDependencies(
            @SerializedName("enabled")
            val enabled: Boolean
        )

        data class Tags(
            @SerializedName("enabled")
            val enabled: Boolean
        )

        data class TimeEstimates(
            @SerializedName("enabled")
            val enabled: Boolean
        )

        data class TimeTracking(
            @SerializedName("enabled")
            val enabled: Boolean
        )
    }


}


package dev.helight.kclickup.models.responses

import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.models.Task

data class TaskList(
    @SerializedName("tasks")
    val tasks: List<Task>
)


package dev.helight.kclickup.models.responses

import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.models.Goal

data class SingleGoalGet(
    @SerializedName("goal")
    val goal: Goal
)


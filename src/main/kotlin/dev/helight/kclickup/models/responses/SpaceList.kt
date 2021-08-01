package dev.helight.kclickup.models.responses


import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.models.Space

data class SpaceList(
    @SerializedName("spaces")
    val spaces: List<Space>
)
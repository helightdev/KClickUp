package dev.helight.kclickup.models.responses


import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.models.CList

data class ListList(
    @SerializedName("lists")
    val lists: List<CList>
)


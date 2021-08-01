package dev.helight.kclickup.models.responses

import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.models.Folder

data class FolderList(
    @SerializedName("folders")
    val folders: List<Folder>
)



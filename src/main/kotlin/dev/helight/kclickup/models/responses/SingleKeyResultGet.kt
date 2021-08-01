package dev.helight.kclickup.models.responses

import com.google.gson.annotations.SerializedName
import dev.helight.kclickup.models.KeyResult

data class SingleKeyResultGet(
    @SerializedName("key_result")
    val keyResult: KeyResult
)
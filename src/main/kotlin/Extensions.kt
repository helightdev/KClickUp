import dev.helight.kclickup.ClickUpClient
import okhttp3.OkHttpClient
import okhttp3.Request

object Extensions {

    inline fun<reified T> Request.executeAndParse(client: OkHttpClient): T {
        val response = client.newCall(this).execute()
        println(response)
        val body = response.body!!.string()
        println(body)
        return ClickUpClient.gson.fromJson(body, T::class.java)
    }

}
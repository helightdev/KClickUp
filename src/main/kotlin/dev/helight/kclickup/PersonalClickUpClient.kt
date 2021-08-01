package dev.helight.kclickup

import okhttp3.*

class PersonalClickUpClient(val apiToken: String, override val endpoint: ClickUp.Endpoint) : ClickUpClient, Interceptor {

   override val client: OkHttpClient = OkHttpClient.Builder()
       .addInterceptor(this)
       .build()

    init {

    }

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request().newBuilder()
            .header("Authorization", apiToken)
            .build())
    }


}
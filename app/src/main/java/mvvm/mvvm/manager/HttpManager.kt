package mvvm.mvvm.manager

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal  class HttpManager {
    private val url = "https://api.etherscan.io/"

    private val gson = GsonBuilder()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
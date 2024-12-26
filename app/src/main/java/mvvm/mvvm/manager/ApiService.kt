package mvvm.mvvm.manager

import mvvm.mvvm.model.EtherPrice
import mvvm.mvvm.model.GasOracle
import mvvm.mvvm.model.SuccessResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "BEDYUP9DK9JH71W72V8DK635KTXPMMZHIN"

interface ApiService {


    @GET("api")
    suspend fun getGasOracle(
        @Query("module") module: String = "gastracker",
        @Query("action") action: String = "gasoracle",
        @Query("apikey") apikey: String = API_KEY,
    ): SuccessResponse<GasOracle>

    @GET("api")
    suspend fun getEtherLastPrice(
        @Query("module") module: String = "stats",
        @Query("action") action: String = "ethprice",
        @Query("apikey") apikey: String = API_KEY,
    ): SuccessResponse<EtherPrice>
}
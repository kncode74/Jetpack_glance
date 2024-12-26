package mvvm.mvvm.repository

import mvvm.mvvm.model.EtherPrice
import mvvm.mvvm.model.GasOracle
import mvvm.mvvm.model.SuccessResponse
import mvvm.mvvm.manager.ApiService

interface GasTrackRepository {
    suspend fun getGasOracle(): SuccessResponse<GasOracle>
    suspend fun getEtherLastPrice(): SuccessResponse<EtherPrice>
}

class GasTrackerRepositoryImpl(
    private val service: ApiService
) : GasTrackRepository {
    override suspend fun getGasOracle(): SuccessResponse<GasOracle> {
        return service.getGasOracle()
    }

    override suspend fun getEtherLastPrice(): SuccessResponse<EtherPrice> {
        return service.getEtherLastPrice()
    }

}
package mvvm.mvvm.usecase

import mvvm.mvvm.model.EtherPrice
import mvvm.mvvm.model.SuccessResponse
import mvvm.mvvm.repository.GasTrackRepository
import org.koin.java.KoinJavaComponent.getKoin

class GetEtherLastPriceUseCase(
    private val repository: Lazy<GasTrackRepository> = getKoin().inject()
) {
    suspend fun invoke(): SuccessResponse<EtherPrice> {
        return repository.value.getEtherLastPrice()
    }
}
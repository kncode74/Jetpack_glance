package mvvm.mvvm.usecase

import mvvm.mvvm.model.GasOracle
import mvvm.mvvm.model.SuccessResponse
import mvvm.mvvm.repository.GasTrackRepository
import org.koin.java.KoinJavaComponent.getKoin

class GetGasOracleUseCase(
    private val repository: Lazy<GasTrackRepository> = getKoin().inject()
) {
    suspend fun invoke(): SuccessResponse<GasOracle> {
        return repository.value.getGasOracle()
    }
}
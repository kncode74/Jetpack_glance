package mvvm.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import mvvm.mvvm.usecase.GasTrackerData
import mvvm.mvvm.usecase.GetAllDataUseCase

class GasTrackerViewModel(
    private val getAllDataUseCase: GetAllDataUseCase = GetAllDataUseCase()
): ViewModel() {

    private var _gasTrackerData = MutableStateFlow(GasTrackerData())
    val gasTrackerData: StateFlow<GasTrackerData> = _gasTrackerData.asStateFlow()

    init {
        getGasTrackerData()
    }

    private fun getGasTrackerData() = viewModelScope.launch {
        val response = getAllDataUseCase.invoke()
        _gasTrackerData.value = response
    }
}
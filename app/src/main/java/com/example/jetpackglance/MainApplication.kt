package com.example.jetpackglance

import android.app.Application
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport
import mvvm.mvvm.GasTrackerViewModel
import mvvm.mvvm.manager.HttpManager
import mvvm.mvvm.repository.GasTrackRepository
import mvvm.mvvm.repository.GasTrackerRepositoryImpl
import mvvm.mvvm.usecase.GetAllDataUseCase
import mvvm.mvvm.usecase.GetEtherLastPriceUseCase
import mvvm.mvvm.usecase.GetGasOracleUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)

            val module = module {
                single { HttpManager().getApiService() }
                single<GasTrackRepository> { GasTrackerRepositoryImpl(get()) }
                factory { GetGasOracleUseCase() }
                factory { GetEtherLastPriceUseCase() }
                factory { GetAllDataUseCase() }
                viewModel { GasTrackerViewModel() }
            }

            modules(listOf(module))
        }
    }
}
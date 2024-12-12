package ru.multiplatform.spend_sense

import android.app.Application
import android.content.Context
import org.koin.dsl.module
import ru.multiplatform.spend_sense.di.initKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(appModule = module {
            single<Context> { this@App.applicationContext }
        })
        instance = this
    }

    companion object {
        lateinit var instance: App
    }
}
package com.melichallenge.application

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.melichallenge.framework.di.networkModule
import com.melichallenge.framework.di.repositoryModules
import com.melichallenge.framework.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MeliChallengeApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MeliChallengeApplication)
            modules(
                viewModelModules,
                repositoryModules,
                networkModule
            )
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        var instance: MeliChallengeApplication? = null
            private set
    }
}
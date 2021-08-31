package com.coreclouet.mypokedex

import android.app.Application
import com.coreclouet.data.di.databaseModule
import com.coreclouet.data.di.networkingModule
import com.coreclouet.data.di.repositoryModule
import com.coreclouet.domain.di.interactionModule
import com.coreclouet.mypokedex.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

  companion object {
    lateinit var instance: Application
      private set
  }

  override fun onCreate() {
    super.onCreate()
    instance = this

    startKoin {
      androidContext(this@App)
      modules(appModules + domainModules + dataModules)
    }
  }
}

val appModules = listOf(presentationModule)
val domainModules = listOf(interactionModule)
val dataModules = listOf(networkingModule, repositoryModule, databaseModule)

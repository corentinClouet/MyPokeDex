package com.coreclouet.domain.di

import com.coreclouet.domain.interaction.GetVersionGroupUseCase
import com.coreclouet.domain.interaction.GetVersionListUseCase
import com.coreclouet.domain.interaction.GetVersionUseCase
import org.koin.dsl.module

val interactionModule = module {
  factory { GetVersionListUseCase(get()) }
  factory { GetVersionUseCase(get()) }
  factory { GetVersionGroupUseCase(get()) }
}

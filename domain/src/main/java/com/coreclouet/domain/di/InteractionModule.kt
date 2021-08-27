package com.coreclouet.domain.di

import com.coreclouet.domain.interaction.GetVersionListUseCase
import com.coreclouet.domain.interaction.GetVersionUseCase
import org.koin.dsl.module

val interactionModule = module {
  factory<GetVersionListUseCase> { GetVersionListUseCase(get()) }
  factory<GetVersionUseCase> { GetVersionUseCase(get()) }
}

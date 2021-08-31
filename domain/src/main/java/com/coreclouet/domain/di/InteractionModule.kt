package com.coreclouet.domain.di

import com.coreclouet.domain.interaction.*
import org.koin.dsl.module

val interactionModule = module {
  factory { GetVersionListUseCase(versionRepository = get()) }
  factory { GetVersionUseCase(versionRepository = get()) }
  factory { GetVersionGroupListUseCase(versionGroupRepository = get()) }
  factory { GetVersionGroupUseCase(versionGroupRepository = get()) }
  factory { GetGenerationUseCase(generationRepository = get()) }
  factory { GetGenerationListUseCase(generationRepository = get()) }
}

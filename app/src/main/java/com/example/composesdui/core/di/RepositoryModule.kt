package com.example.composesdui.core.di

import com.example.composesdui.api.repository.SDxRepository
import org.koin.dsl.module

val repoModule = module {
    factory {
        SDxRepository()
    }
}
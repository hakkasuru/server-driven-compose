package com.example.composesdui.core.di

import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.core.delegate.ui.UIDelegateImpl
import com.example.composesdui.dashboard.DashboardViewModel
import com.example.composesdui.ui.common.page.CommonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        DashboardViewModel(repo = get(), uiDelegate = get())
    }

    viewModel {
        CommonViewModel(repo = get(), uiDelegate = get())
    }

    factory<UIDelegate> {
        UIDelegateImpl()
    }
}
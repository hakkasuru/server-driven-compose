package com.example.composesdui.dashboard

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composesdui.core.delegate.action.ActionDelegate
import com.example.composesdui.ui.common.CommonPageComposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun DashboardPage(vm: DashboardViewModel = koinViewModel()) {
    val actionDelegate = LocalContext.current as ActionDelegate
    val actionState = vm.actionFlow.collectAsStateWithLifecycle().value
    val uiState = vm.uiState.observeAsState(DashboardViewModel.State.Idle).value

    Crossfade(targetState = uiState, label = "dashboard crossfade") { state ->
        when (state) {
            is DashboardViewModel.State.Idle -> { Text(text = "idle") }
            is DashboardViewModel.State.Loading -> { Text(text = "loading") }
            is DashboardViewModel.State.Error -> { Text(text = "error") }
            is DashboardViewModel.State.Content -> { CommonPageComposable(state.page, vm) }
        }
    }

    LaunchedEffect(actionState) {
        actionState?.let { actionDelegate.handleAction(it) }
    }

    LaunchedEffect(true) {
        vm.submitAction(DashboardViewModel.Action.FetchDashboard)
    }
}
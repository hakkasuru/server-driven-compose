package com.example.composesdui.ui.common.page

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
fun CommonPage(
    page: String,
    vm: CommonViewModel = koinViewModel()
) {
    val actionDelegate = LocalContext.current as ActionDelegate
    val actionState = vm.actionFlow.collectAsStateWithLifecycle().value
    val uiState = vm.uiState.observeAsState(CommonViewModel.State.Idle).value

    Crossfade(targetState = uiState, label = "dashboard crossfade") { state ->
        when (state) {
            is CommonViewModel.State.Idle -> { Text(text = "idle") }
            is CommonViewModel.State.Loading -> { Text(text = "loading") }
            is CommonViewModel.State.Error -> { Text(text = "error") }
            is CommonViewModel.State.Content -> { CommonPageComposable(state.page, vm) }
        }
    }

    LaunchedEffect(actionState) {
        actionState?.let { actionDelegate.handleAction(it) }
    }

    LaunchedEffect(true) {
        vm.submitAction(CommonViewModel.Action.FetchPage(page))
    }
}
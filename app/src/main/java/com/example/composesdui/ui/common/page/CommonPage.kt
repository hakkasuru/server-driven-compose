package com.example.composesdui.ui.common.page

import androidx.compose.animation.Crossfade
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import com.example.composesdui.ui.common.CommonPageComposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun CommonPage(
    page: String,
    vm: CommonViewModel = koinViewModel()
) {
    val uiState = vm.uiState.observeAsState(CommonViewModel.State.Idle).value
    Crossfade(targetState = uiState, label = "dashboard crossfade") { state ->
        when (state) {
            is CommonViewModel.State.Idle -> { Text(text = "idle") }
            is CommonViewModel.State.Loading -> { Text(text = "loading") }
            is CommonViewModel.State.Error -> { Text(text = "error") }
            is CommonViewModel.State.Content -> { CommonPageComposable(state.page) }
        }
    }
    LaunchedEffect(true) {
        vm.submitAction(CommonViewModel.Action.FetchPage(page))
    }
}
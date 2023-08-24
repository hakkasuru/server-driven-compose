package com.example.composesdui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composesdui.api.model.SDPage
import com.example.composesdui.api.repository.SDxRepository
import com.example.composesdui.core.delegate.ui.UIDelegate
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val repo: SDxRepository,
    private val uiDelegate: UIDelegate
) : ViewModel(), UIDelegate by uiDelegate {

    sealed class State {
        object Idle : State()
        object Loading : State()
        object Error : State()
        class Content(val page: SDPage) : State()
    }

    sealed class Action {
        object FetchDashboard : Action()
    }

    private val _uiState: MutableLiveData<State> = MutableLiveData(State.Idle)
    val uiState: LiveData<State>
        get() = _uiState

    fun submitAction(action: Action) {
        when (action) {
            is Action.FetchDashboard -> {
                viewModelScope.launch {
                    repo.getPage("dashboard")
                        .onStart { _uiState.value = State.Loading }
                        .catch { _uiState.value = State.Error }
                        .collect { _uiState.value = State.Content(it) }
                }
            }
        }
    }
}
package com.example.composesdui.ui.common.page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composesdui.api.model.SDPage
import com.example.composesdui.api.repository.SDxRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CommonViewModel(
    private val repo: SDxRepository
) : ViewModel() {

    sealed class State {
        object Idle : State()
        object Loading : State()
        object Error : State()
        class Content(val page: SDPage) : State()
    }

    sealed class Action {
        class FetchPage(val id: String) : Action()
    }

    private val _uiState: MutableLiveData<State> = MutableLiveData(State.Idle)
    val uiState: LiveData<State>
        get() = _uiState

    fun submitAction(action: Action) {
        when (action) {
            is Action.FetchPage -> {
                viewModelScope.launch {
                    repo.getPage(action.id)
                        .onStart { _uiState.value = State.Loading }
                        .catch { _uiState.value = State.Error }
                        .collect { _uiState.value = State.Content(it) }
                }
            }
        }
    }
}
package com.example.vkeducationdemo.ui.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkeducationdemo.domain.repository.CatalogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val repository: CatalogRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(Channel.BUFFERED)
    val events: Flow<AppListEvent> = _events.receiveAsFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = AppListState.Loading
            _state.value = try {
                AppListState.Content(apps = repository.getCatalog())
            } catch (cancellationException: CancellationException) {
                throw cancellationException
            } catch (e: Exception) {
                AppListState.Error
            }
        }
    }

    fun onToolbarClick() {
        _events.trySend(AppListEvent.ToolbarClicked)
    }
}

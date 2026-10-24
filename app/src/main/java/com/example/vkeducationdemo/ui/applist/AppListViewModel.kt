package com.example.vkeducationdemo.ui.applist

import androidx.lifecycle.ViewModel
import com.example.vkeducationdemo.data.Apps
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

internal class AppListViewModel : ViewModel() {

    private val _state = MutableStateFlow(AppListState(apps = Apps))
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(Channel.BUFFERED)
    val events: Flow<AppListEvent> = _events.receiveAsFlow()

    fun onToolbarClick() {
        _events.trySend(AppListEvent.ToolbarClicked)
    }
}

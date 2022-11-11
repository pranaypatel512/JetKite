/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pranay.jetkite.dashboard.ui.watchlist

import androidx.lifecycle.ViewModel
import com.pranay.jetkite.dashboard.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor() : ViewModel() {

    private val _tabState = MutableStateFlow(
        WatchListTabState(
            titles = listOf(R.string.mw1, R.string.mw2, R.string.mw3, R.string.mw4, R.string.mw5, R.string.mw6, R.string.mw7, R.string.mw8),
            currentIndex = 0
        )
    )
    val tabState: StateFlow<WatchListTabState> = _tabState.asStateFlow()

    fun switchTab(newIndex: Int) {
        if (newIndex != tabState.value.currentIndex) {
            _tabState.update {
                it.copy(currentIndex = newIndex)
            }
        }
    }
}

data class WatchListTabState(
    val titles: List<Int>,
    val currentIndex: Int
)

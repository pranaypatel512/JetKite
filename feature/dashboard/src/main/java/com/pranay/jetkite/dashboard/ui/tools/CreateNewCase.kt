package com.pranay.jetkite.dashboard.ui.tools

sealed class CreateNewCase {
    object CreateNewBasket : CreateNewCase()
    object CreateNewSIP : CreateNewCase()
    object CreateNewAlert : CreateNewCase()
}

package com.insecticidepls.walletest.presentation.state

import androidx.compose.ui.graphics.Color

data class TransactionUIItem(
    val desc: String,
    val amount: Float,
    val date: String,
    val color: Color
)

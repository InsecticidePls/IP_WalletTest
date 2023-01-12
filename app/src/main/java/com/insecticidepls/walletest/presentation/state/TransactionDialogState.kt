package com.insecticidepls.walletest.presentation.state

import com.insecticidepls.walletest.presentation.types.TransactionType

data class TransactionDialogState(
    val isOpen: Boolean = false,
    val type: TransactionType = TransactionType.Deposit,
    val isConfirmButtonEnabled: Boolean = false,
    val curValueInput: String = ""
)

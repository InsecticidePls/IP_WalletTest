package com.insecticidepls.walletest.domain.usecase

import java.text.DecimalFormatSymbols

class InputValueUseCase {

    operator fun invoke(
        amount: String
    ): Boolean {
        val decimalFormat = DecimalFormatSymbols
            .getInstance().currency.currencyCode

        val regNull = "0+$decimalFormat?[0]{0,2}"
        val regDefault = "[0-9]*$decimalFormat?[0-9]{1,2}"

        return when (amount.matches(Regex(regNull))) {
            false -> return false
            else -> amount.matches(Regex(regDefault))
        }
    }
}

package com.insecticidepls.walletest.util

import java.text.DecimalFormatSymbols
import java.util.Locale
import kotlin.math.absoluteValue

private const val ONE_HUNDRED = 100

fun Float.formatToPrice(
    locale: Locale,
    alwaysUseTwoCommaDigits: Boolean = false
): String {
    val separator = DecimalFormatSymbols.getInstance(locale).decimalSeparator
    val multiplied10Pow2 = (this * ONE_HUNDRED).toInt()
    val valueBeforeComma = multiplied10Pow2 / ONE_HUNDRED
    val commaValues = multiplied10Pow2.absoluteValue % ONE_HUNDRED
    return if (commaValues != 0 || alwaysUseTwoCommaDigits) {
        val commaValuesString = if (commaValues == 0) { "00" }
        else { "$commaValues" }
        return "R\$ $valueBeforeComma$separator$commaValuesString"
    } else {
        "R\$ $valueBeforeComma"
    }
}

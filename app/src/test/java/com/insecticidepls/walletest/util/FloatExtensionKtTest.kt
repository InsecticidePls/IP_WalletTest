package com.insecticidepls.walletest.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.Locale


class FloatExtensionKtTest {

    @Test
    fun floatGerman_WithoutCommaValue() {
        val number = 10f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("R\$ 10")
    }

    @Test
    fun floatUS_WithoutCommaValue() {
        val number = 10f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("R\$ 10")
    }

    @Test
    fun floatGerman_WithOneCommaValue() {
        val number = 10.5f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("R\$ 10,50")
    }

    @Test
    fun floatToUS_WithOneCommaValue() {
        val number = 10.5f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("R\$ 10.50")
    }

    @Test
    fun float_WithTwoCommaValues() {
        val number = 11.51f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("R\$ 11,51")
    }

    @Test
    fun floatIsZero_ToSingleZero() {
        val number = 0f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("R\$ 0")
    }

    @Test
    fun floatIsZero_WithTwoCommaValues_NoCommaValueForced() {
        val number = 0f
        val result = number.formatToPrice(Locale.US, alwaysUseTwoCommaDigits = true)
        assertThat(result).isEqualTo("R\$ 0.00")
    }

    @Test
    fun negativeFloat_WithCommaValueFormattedCorrectly() {
        val number = -1.20f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("R\$ -1.20")
    }

    @Test
    fun negativeFloat_WithoutCommaValueFormattedCorrectly() {
        val number = -5f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("R\$ -5")
    }

    @Test
    fun negativeFloat_WithoutCommaValue_ForcedTwoCommasFormattedCorrectly() {
        val number = -5f
        val result = number.formatToPrice(Locale.US, alwaysUseTwoCommaDigits = true)
        assertThat(result).isEqualTo("R\$ -5.00")
    }

}

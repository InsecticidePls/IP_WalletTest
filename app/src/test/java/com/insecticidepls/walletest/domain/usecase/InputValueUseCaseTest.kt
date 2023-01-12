package com.insecticidepls.walletest.domain.usecase

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class InputValueUseCaseTest {
    private val inputValueUseCase = InputValueUseCase()

    @Test
    fun zeroWithoutComma_ReturnFalse() {
        val result = inputValueUseCase("0")
        assertThat(result).isFalse
    }

    @Test
    fun zeroWithComma_ReturnFalse() {
        val result = inputValueUseCase("0,00")
        assertThat(result).isFalse
    }

    @Test
    fun multipleZerosWithComma_ReturnFalse() {
        val result = inputValueUseCase("000,00")
        assertThat(result).isFalse
    }

    @Test
    fun zeroBeforeCommaValueAfter_ReturnTrue() {
        val result = inputValueUseCase("0,20")
        assertThat(result).isTrue
    }

    @Test
    fun zeroBeforeCommaSecondValueAfter_ReturnsTrue(){
        val result = inputValueUseCase("0,02")
        assertThat(result).isTrue
    }

    @Test
    fun singleValue_ReturnsTrue(){
        val result = inputValueUseCase("2")
        assertThat(result).isTrue
    }

    @Test
    fun normalValueCommaValueAfter_ReturnsTrue(){
        val result = inputValueUseCase("2,1")
        assertThat(result).isTrue
    }

    @Test
    fun normalValueTwoCommaValuesAfter_ReturnsTrue(){
        val result = inputValueUseCase("2,13")
        assertThat(result).isTrue
    }

    @Test
    fun tooLongValue_ReturnsFalse(){
        val result = inputValueUseCase("2,131")
        assertThat(result).isFalse
    }

    @Test
    fun noValue_ReturnsFalse(){
        val result = inputValueUseCase("1412a")
        assertThat(result).isFalse
    }

    @Test
    fun leadingZero_ReturnsTrue(){
        val result = inputValueUseCase("02,21")
        assertThat(result).isTrue
    }
}

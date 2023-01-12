package com.insecticidepls.walletest.domain.usecase

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CalculateListSumUseCaseTest {
    private val calculateListSumUseCase = CalculateListSumUseCase()

    @Test
    fun resultEmptyListIsNull(){
        val result = calculateListSumUseCase(emptyList())
        assertThat(result).isEqualTo(0f)
    }

    @Test
    fun resultOneListValue(){
        val result = calculateListSumUseCase(listOf(2.3f))
        assertThat(result).isEqualTo(2.3f)
    }

    @Test
    fun resultMultipleListValues(){
        val result = calculateListSumUseCase(listOf(2.3f,3.12f,5f))
        assertThat(result).isEqualTo(10.42f)
    }

    @Test
    fun resultMultipleListValues_NegativeNumber(){
        val result = calculateListSumUseCase(listOf(2.3f,3.12f,-15f))
        assertThat(result).isEqualTo(-9.58f)
    }
}

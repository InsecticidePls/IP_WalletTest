package com.insecticidepls.walletest.domain.usecase

class CalculateListSumUseCase {

    operator fun invoke(
        list: List<Float>
    ): Float {
        var result = 0f
        for (value in list) {
            result += value
        }
        return result
    }
}

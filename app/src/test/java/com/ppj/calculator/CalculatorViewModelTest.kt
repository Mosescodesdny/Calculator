package com.ppj.calculator

import com.ppj.calculator.viewmodel.CalculatorViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CalculatorViewModelTest {

    @Test
    fun fullFlow_isCorrect() {
        val vm = CalculatorViewModel()

        vm.onNumberClick(2)
        vm.onOperatorClick('+')
        vm.onNumberClick(3)
        vm.onEquals()

        assertEquals("5.0", vm.state.display)
    }
}
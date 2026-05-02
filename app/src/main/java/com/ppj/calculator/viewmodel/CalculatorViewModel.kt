package com.ppj.calculator.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ppj.calculator.domain.CalculatorEngine
import com.ppj.calculator.domain.Token

data class CalculatorState(
    val display: String = "0",
    val tokens: List<Token> = emptyList()
)

class CalculatorViewModel : ViewModel() {

    private val engine = CalculatorEngine()

    var state by mutableStateOf(CalculatorState())
        private set

    fun onNumberClick(num: Int) {
        state = state.copy(
            display = if (state.display == "0") "$num" else state.display + num
        )
    }

    fun onOperatorClick(op: Char) {
        val number = state.display.toDoubleOrNull() ?: return

        state = state.copy(
            tokens = state.tokens + Token.Number(number) + Token.Operator(op),
            display = "0"
        )
    }

    fun onEquals() {
        val number = state.display.toDoubleOrNull() ?: return

        val result = engine.evaluate(
            state.tokens + Token.Number(number)
        )

        state = CalculatorState(display = result.toString())
    }

    fun onClear() {
        state = CalculatorState()
    }
}
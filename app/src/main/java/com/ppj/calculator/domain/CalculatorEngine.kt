package com.ppj.calculator.domain

class CalculatorEngine {

    fun evaluate(tokens: List<Token>): Double {
        if (tokens.isEmpty()) return 0.0

        var result = (tokens[0] as Token.Number).value

        var i = 1
        while (i < tokens.size) {
            val op = tokens[i] as Token.Operator
            val next = tokens[i + 1] as Token.Number

            result = when (op.symbol) {
                '+' -> result + next.value
                '-' -> result - next.value
                '*' -> result * next.value
                '/' -> result / next.value
                else -> result
            }

            i += 2
        }

        return result
    }
}
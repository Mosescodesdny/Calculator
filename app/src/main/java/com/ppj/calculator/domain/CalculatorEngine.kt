package com.ppj.calculator.domain

class CalculatorEngine {

    fun evaluate(tokens: List<Token>): Double {
        if (tokens.isEmpty()) return 0.0

        // Step 1: collapse * and /
        val processed = mutableListOf<Token>()

        var i = 0
        while (i < tokens.size) {
            val token = tokens[i]

            if (token is Token.Number) {
                if (i + 1 < tokens.size && tokens[i + 1] is Token.Operator) {
                    val op = tokens[i + 1] as Token.Operator

                    if (op.symbol == '*' || op.symbol == '/') {
                        val next = tokens[i + 2] as Token.Number

                        val result = if (op.symbol == '*') {
                            token.value * next.value
                        } else {
                            token.value / next.value
                        }

                        processed.add(Token.Number(result))
                        i += 3
                        continue
                    }
                }

                processed.add(token)
                i++
            } else {
                processed.add(token)
                i++
            }
        }

        // Step 2: handle + and -
        var result = (processed[0] as Token.Number).value

        i = 1
        while (i < processed.size) {
            val op = processed[i] as Token.Operator
            val next = processed[i + 1] as Token.Number

            result = when (op.symbol) {
                '+' -> result + next.value
                '-' -> result - next.value
                else -> result
            }

            i += 2
        }

        return result
    }
}
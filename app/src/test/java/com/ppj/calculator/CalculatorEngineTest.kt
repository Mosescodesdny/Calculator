package com.ppj.calculator

import com.ppj.calculator.domain.CalculatorEngine
import com.ppj.calculator.domain.Token
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorEngineTest {

    private val engine = CalculatorEngine()

    @Test
    fun addition_isCorrect() {
        val result = engine.evaluate(
            listOf(
                Token.Number(2.0),
                Token.Operator('+'),
                Token.Number(3.0)
            )
        )

        assertEquals(5.0, result, 0.0)
    }

    @Test
    fun subtraction_isCorrect() {
        val result = engine.evaluate(
            listOf(
                Token.Number(10.0),
                Token.Operator('-'),
                Token.Number(4.0)
            )
        )

        assertEquals(6.0, result, 0.0)
    }

    @Test
    fun multiplication_isCorrect() {
        val result = engine.evaluate(
            listOf(
                Token.Number(6.0),
                Token.Operator('*'),
                Token.Number(2.0)
            )
        )

        assertEquals(12.0, result, 0.0)
    }

    @Test
    fun division_isCorrect() {
        val result = engine.evaluate(
            listOf(
                Token.Number(8.0),
                Token.Operator('/'),
                Token.Number(2.0)
            )
        )

        assertEquals(4.0, result, 0.0)
    }

    @Test
    fun division_byZero() {
        val result = engine.evaluate(
            listOf(
                Token.Number(8.0),
                Token.Operator('/'),
                Token.Number(0.0)
            )
        )

        println(result) // observe behavior (Infinity?)
    }
}
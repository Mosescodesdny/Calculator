package com.ppj.calculator.domain

sealed class Token {
    data class Number(val value: Double) : Token()
    data class Operator(val symbol: Char) : Token()
}
package com.farkasatesz.myjetcalculator.viewModel

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorViewModelTest {

    private lateinit var viewModel : CalculatorViewModel
    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun getDisplayValue() {
        viewModel.addDigit("123")
        assertEquals("123", viewModel.displayValue.value)
    }

    @Test
    fun addDigit() {
        viewModel.addDigit("1")
        assertEquals("1", viewModel.displayValue.value)
    }

    @Test
    fun clear() {
        viewModel.addDigit("123")
        viewModel.clear()
        assertEquals("0", viewModel.displayValue.value)
    }

    @Test
    fun delete() {
        viewModel.addDigit("123")
        viewModel.delete()
        assertEquals("12", viewModel.displayValue.value)
    }

    @Test
    fun addDecimal() {
        viewModel.addDigit("123")
        viewModel.addDecimal()
        assertEquals("123.", viewModel.displayValue.value)
    }

    @Test
    fun add() {
        viewModel.add()
        assertEquals("+", viewModel.op)
    }

    @Test
    fun subtract() {
        viewModel.subtract()
        assertEquals("-", viewModel.op)
    }

    @Test
    fun multiply() {
        viewModel.multiply()
        assertEquals("*", viewModel.op)
    }

    @Test
    fun divide() {
        viewModel.divide()
        assertEquals("/", viewModel.op)
    }

    @Test
    fun percentage() {
        viewModel.percentage()
        assertEquals("%", viewModel.op)
    }

    @Test
    fun setPlusMinus(){
        viewModel.addDigit("123")
        viewModel.plusMinus()
        assertEquals("-123.0", viewModel.displayValue.value)
    }

    @Test
    fun addTwoNumbers(){
        viewModel.addDigit("123")
        viewModel.add()
        viewModel.addDigit("123")
        viewModel.equals()
        assertEquals("246.0", viewModel.displayValue.value)
    }

    @Test
    fun subtractTwoNumbers(){
        viewModel.addDigit("123")
        viewModel.subtract()
        viewModel.addDigit("123")
        viewModel.equals()
        assertEquals("0.0", viewModel.displayValue.value)
    }

    @Test
    fun multiplyTwoNumbers() {
        viewModel.addDigit("3")
        viewModel.multiply()
        viewModel.addDigit("3")
        viewModel.equals()
        assertEquals("9.0", viewModel.displayValue.value)
    }
}
package com.farkasatesz.myjetcalculator.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    val displayValue = mutableStateOf("")
    private val partValue = mutableStateOf("")

    var op = ""

    fun addDigit(digit: String) {
        when(displayValue.value){
            "0" -> displayValue.value = digit
            else -> displayValue.value += digit
        }
    }

    fun clear() {
        displayValue.value = ""
        partValue.value = ""
        op = ""
    }

    fun delete() {
        displayValue.value = displayValue.value.dropLast(1)
        if (displayValue.value.isEmpty()) {
            displayValue.value = ""
        }
        op = ""
    }

    fun addDecimal() {
        if (!displayValue.value.contains(".")) {
            displayValue.value += "."
        }
    }

    private fun numberToString(num: Double): String{
       return num.toString()
    }

    private fun stringToNumber(str: String): Double{
        return str.toDouble()
    }

    private fun setDisplayToPart(){
        partValue.value = displayValue.value
        displayValue.value = ""
    }

    fun add(){
        op = "+"
        setDisplayToPart()
    }

    fun subtract(){
        op = "-"
        setDisplayToPart()
    }

    fun multiply(){
        op = "*"
        setDisplayToPart()
    }

    fun divide(){
        op = "/"
        setDisplayToPart()
    }

    fun percentage(){
        op = "%"
        setDisplayToPart()
    }

    fun plusMinus(){
        if(displayValue.value.isNotBlank() && displayValue.value != "-" && displayValue.value != "."){
            displayValue.value = (stringToNumber(displayValue.value) * -1).toString()
        }
    }

    fun equals(){
        when(op){
            "+" -> {
                val result = stringToNumber(partValue.value) + stringToNumber(displayValue.value)
                displayValue.value = numberToString(result)
                op = ""
            }
            "." -> {
                addDecimal()
            }
            "-" -> {
                val result = stringToNumber(partValue.value) - stringToNumber(displayValue.value)
                displayValue.value = numberToString(result)
                op = ""
            }
            "*" -> {
                val result = stringToNumber(partValue.value) * stringToNumber(displayValue.value)
                displayValue.value = numberToString(result)
                op = ""
            }
            "/" -> {
                if (partValue.value == ""){
                    displayValue.value = "Error"
                    op = ""
                    return
                }
                val result = stringToNumber(partValue.value) / stringToNumber(displayValue.value)
                displayValue.value = numberToString(result)
                op = ""
            }
            "%" -> {
                val result = (stringToNumber(partValue.value) * stringToNumber(displayValue.value)) / 100
                displayValue.value = numberToString(result)
                op = ""
            }
        }
    }

}
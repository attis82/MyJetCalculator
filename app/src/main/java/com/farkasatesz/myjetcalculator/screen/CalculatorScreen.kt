package com.farkasatesz.myjetcalculator.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.farkasatesz.myjetcalculator.components.Display
import com.farkasatesz.myjetcalculator.components.KeyPad
import com.farkasatesz.myjetcalculator.viewModel.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    Surface(
        color = Color.DarkGray,
        border = BorderStroke(1.dp, Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Display(text = viewModel.displayValue.value )
            KeyPad(
                clear = {viewModel.clear()},
                delete = {viewModel.delete()},
                eq = {viewModel.equals()},
                setDigit = {viewModel.addDigit(it)},
                setDecimal = {viewModel.addDecimal()},
                plusMinus = {viewModel.plusMinus()},
                add = {viewModel.add()},
                subtract = {viewModel.subtract()},
                multiply = {viewModel.multiply()},
                divide = {viewModel.divide()},
                percentage = {viewModel.percentage()}
            )
        }

    }
}
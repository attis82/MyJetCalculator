package com.farkasatesz.myjetcalculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyButton(
    symbol: String,
    color: Color = Color.White,
    onClick: () -> Unit
) {
    TextButton(onClick = { onClick() }) {
        Text(text = symbol, color = color, fontSize = 20.sp)
    }

}

@Composable
fun Display(text: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(15.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = text,
            fontSize = 40.sp,
            color = Color.White
        )
    }
}

@Composable
fun KeyPad(
    clear: () -> Unit,
    delete: () -> Unit,
    eq: () -> Unit,
    setDigit: (String) -> Unit,
    setDecimal: () -> Unit,
    plusMinus: () -> Unit,
    add: () -> Unit,
    subtract: () -> Unit,
    multiply: () -> Unit,
    divide: () -> Unit,
    percentage: () -> Unit
) {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.padding(bottom = 50.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MyButton(symbol = "AC", color = Color.Red) {
                    clear()
                }
                MyButton(symbol = "DEL") {
                    delete()
                }
                MyButton(symbol = "%") {
                    percentage()
                }
                MyButton(symbol = "/") {
                    divide()
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MyButton(symbol = "9") {
                    setDigit("9")
                }
                MyButton(symbol = "8") {
                    setDigit("8")
                }
                MyButton(symbol = "7") {
                    setDigit("7")
                }
                MyButton(symbol = "*") {
                    multiply()
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MyButton(symbol = "6") {
                    setDigit("6")
                }
                MyButton(symbol = "5") {
                    setDigit("5")
                }
                MyButton(symbol = "4") {
                    setDigit("4")
                }
                MyButton(symbol = "-") {
                    subtract()
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MyButton(symbol = "3") {
                    setDigit("3")
                }
                MyButton(symbol = "2") {
                    setDigit("2")
                }
                MyButton(symbol = "1") {
                    setDigit("1")
                }
                MyButton(symbol = "+") {
                    add()
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MyButton(symbol = "+/-") {
                    plusMinus()
                }
                MyButton(symbol = "0") {
                    setDigit("0")
                }
                MyButton(symbol = ".") {
                    setDecimal()
                }
                MyButton(symbol = "=") {
                    eq()
                }
            }


        }
    }

}

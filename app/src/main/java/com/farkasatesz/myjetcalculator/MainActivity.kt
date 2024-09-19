package com.farkasatesz.myjetcalculator

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.farkasatesz.myjetcalculator.screen.CalculatorScreen
import com.farkasatesz.myjetcalculator.ui.theme.MyJetCalculatorTheme
import com.farkasatesz.myjetcalculator.viewModel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       hideBars(this.window)
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<CalculatorViewModel>()
            MyJetCalculatorTheme {
                Surface(
                    color = Color.DarkGray
                ){
                    CalculatorScreen(viewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.R)
fun hideBars(window: Window){
    WindowCompat.setDecorFitsSystemWindows(window, false)
    window.decorView.setOnApplyWindowInsetsListener { _, insets ->
        window.insetsController?.apply {
            hide(android.view.WindowInsets.Type.systemBars())
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
        insets
    }
}

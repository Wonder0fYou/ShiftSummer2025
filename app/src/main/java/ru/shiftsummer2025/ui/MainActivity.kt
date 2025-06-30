package ru.shiftsummer2025.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ru.shiftsummer2025.ShiftApplication
import ru.shiftsummer2025.design_system.theme.ShiftSummer2025Theme

class MainActivity : ComponentActivity() {

    private val component by lazy {
        (application as ShiftApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)

        enableEdgeToEdge()
        setContent {
            ShiftSummer2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}
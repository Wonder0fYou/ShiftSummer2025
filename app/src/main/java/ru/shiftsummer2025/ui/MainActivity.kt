package ru.shiftsummer2025.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ru.shiftsummer2025.ShiftApplication
import ru.shiftsummer2025.design_system.component.scaffold.ShiftScaffold
import ru.shiftsummer2025.design_system.theme.ShiftSummer2025Theme
import ru.shiftsummer2025.route.AppNavGraph

class MainActivity : ComponentActivity() {

    private val component by lazy {
        (application as ShiftApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            ShiftSummer2025Theme {
                ShiftScaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavGraph(
                        navHostController = navController,
                        appComponent = component,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                bottom = innerPadding.calculateBottomPadding()
                            )
                            .imePadding()
                    )
                }
            }
        }
    }
}
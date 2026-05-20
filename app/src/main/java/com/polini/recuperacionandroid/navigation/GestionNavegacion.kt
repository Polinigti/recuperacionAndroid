package com.polini.recuperacionandroid.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.google.firebase.auth.FirebaseAuth
import com.polini.recuperacionandroid.data.Juego
import com.polini.recuperacionandroid.viewmodel.JuegoViewModel

@Composable
fun GestionNavegacion(auth: FirebaseAuth){

    val pilaNavegacion = rememberNavBackStack(Routes.Login)
    val auth = FirebaseAuth.getInstance()
    val JuegoViewModel: JuegoViewModel = viewModel()

    NavDisplay(
        backStack = pilaNavegacion,
        onBack = {pilaNavegacion.removeLastOrNull()},
        entryProvider = { key ->

        }
    )

}
package com.polini.recuperacionandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.google.firebase.auth.FirebaseAuth
import com.polini.recuperacionandroid.screens.HomeScreen
import com.polini.recuperacionandroid.screens.LoginScreen
import com.polini.recuperacionandroid.screens.NuevoScreen
import com.polini.recuperacionandroid.viewmodel.JuegoViewModel
import com.polini.recuperacionandroid.data.Juego

@Composable
fun GestionNavegacion() {
    val pilaNavegacion = rememberNavBackStack(Routes.Login)

    val auth = FirebaseAuth.getInstance()
    val juegoViewModel: JuegoViewModel = viewModel()

    NavDisplay(
        backStack = pilaNavegacion,
        onBack = {
            pilaNavegacion.removeLastOrNull()
        }
    ) { key ->
        when (key) {
            is Routes.Login -> NavEntry(key) {
                LoginScreen(
                    auth = auth,
                    onLoginSuccess = {
                        pilaNavegacion.add(Routes.Home)
                    },
                    modifier = Modifier
                )
            }

            is Routes.Home -> NavEntry(key) {
                HomeScreen(
                    auth = auth,
                    onNavigateToNuevo = {
                        pilaNavegacion.add(Routes.Nuevo)
                    },
                    getJuegoViewModel = juegoViewModel
                )
            }

            is Routes.Nuevo -> NavEntry(key) {
                NuevoScreen(
                    onAgregarJuego = { juego ->
                        juegoViewModel.agregarJuego(
                            juego.nombre,
                            juego.nota,
                            juego.descripcion,
                            juego.consola,
                            juego.imagenUrl
                        )
                    },
                    onNavigateBack = {
                        pilaNavegacion.removeLastOrNull()
                    }
                )
            }

            else -> throw IllegalArgumentException("Unknown key: $key")
        }
    }
}
package com.polini.recuperacionandroid.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.polini.recuperacionandroid.component.TarjetaJuego
import com.polini.recuperacionandroid.viewmodel.JuegoViewModel

@Composable
fun HomeScreen(
    auth: FirebaseAuth,
    onNavigateToNuevo: () -> Unit,
    getJuegoViewModel: JuegoViewModel
) {
    val juegos by getJuegoViewModel.juegos.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Videojuegos",
            style = MaterialTheme.typography.titleMedium,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(30.dp))


        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(juegos) { juego ->
                TarjetaJuego(
                    juego = juego,
                    onEliminar = {
                        getJuegoViewModel.eliminarJuego(juego.id)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { onNavigateToNuevo() },
            modifier = Modifier.padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Agregar Juego")
        }
    }
}

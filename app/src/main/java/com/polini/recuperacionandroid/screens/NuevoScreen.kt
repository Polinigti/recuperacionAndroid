package com.polini.recuperacionandroid.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.polini.recuperacionandroid.data.Juego

@Composable
fun NuevoScreen(onAgregarJuego: (Juego) -> Unit, onNavigateBack: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var nota by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var consola by remember { mutableStateOf("") }
    var imagenUrl by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
        )
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = nota,
            onValueChange = { nota = it },
            label = { Text("Nota") },
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") },
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = consola,
            onValueChange = { consola = it },
            label = { Text("Plataforma") },
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = imagenUrl,
            onValueChange = { imagenUrl = it },
            label = { Text("URL Imagen") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    if (nombre.isNotBlank() && consola.isNotBlank()) {
                        val notaDouble = nota.toDoubleOrNull() ?: 0.0
                        onAgregarJuego(
                            Juego(
                                nombre = nombre,
                                nota = notaDouble,
                                descripcion = descripcion,
                                consola = consola,
                                imagenUrl = imagenUrl
                            )
                        )
                        nombre = ""
                        nota = ""
                        descripcion = ""
                        consola = ""
                        imagenUrl = ""
                        onNavigateBack()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5D7D7C)),
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Agregar")
            }
            Button(
                onClick = { onNavigateBack() },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Cancelar")
            }
        }
    }
}
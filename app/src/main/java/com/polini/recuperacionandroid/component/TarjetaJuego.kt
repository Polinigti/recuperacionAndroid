package com.polini.recuperacionandroid.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseAuth
import com.polini.recuperacionandroid.data.Juego

@Composable
fun TarjetaJuego(
    juego: Juego,
    onEliminar: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(juego.nota.toString(),)
            Spacer(modifier = Modifier.width(10.dp))
            AsyncImage(
                juego.imagenUrl,
                contentDescription = "Imagen del juego"
            )
        }
            Column(modifier = Modifier.weight(1f).padding(horizontal = 8.dp)) {
                Text(text = juego.nombre, style = MaterialTheme.typography.titleLarge)
                Text(juego.descripcion)
            }
            IconButton(onClick = onEliminar) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Eliminar")
            }
    }
}
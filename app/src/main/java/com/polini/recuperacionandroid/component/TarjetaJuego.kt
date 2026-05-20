package com.polini.recuperacionandroid.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.polini.recuperacionandroid.R
import com.polini.recuperacionandroid.data.Juego

@Composable
fun TarjetaJuego(
    juego: Juego,
    onEliminar: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {Column(Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${juego.nota}",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.width(8.dp))
            AsyncImage(model = juego.imagenUrl,
                contentDescription = "Imagen del juego",
                modifier = Modifier.size(40.dp))

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = juego.nombre,
                    style = MaterialTheme.typography.titleMedium
                )

                if (juego.consola == "nintendo"){
                    Image(
                        painter = painterResource(id = R.drawable.nintendo),
                        contentDescription = "Nintendo",
                        modifier = Modifier.size(24.dp)
                    )
                }else if (juego.consola == "play"){
                    Image(
                        painter = painterResource(id = R.drawable.ps),
                        contentDescription = "Play",
                        modifier = Modifier.size(24.dp)
                    )
                }else if (juego.consola == "pc"){
                    Image(
                        painter = painterResource(id = R.drawable.windows),
                        contentDescription = "Play",
                        modifier = Modifier.size(24.dp)
                    )
                }else if (juego.consola == "xbox"){
                    Image(
                        painter = painterResource(id = R.drawable.xbox),
                        contentDescription = "Xbox",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = juego.descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    fontStyle = FontStyle.Italic
                )
            }

            IconButton(
                onClick = {
                    onEliminar()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar"
                )
            }
        }
    }
    }

}
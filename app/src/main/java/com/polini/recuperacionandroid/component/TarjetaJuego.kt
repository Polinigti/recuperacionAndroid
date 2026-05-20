package com.polini.recuperacionandroid.component

import androidx.compose.foundation.Image
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
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(juego.nota.toString(),)
            Spacer(modifier = Modifier.width(10.dp))
            AsyncImage(
                model = juego.imagenUrl,
                contentDescription = "Imagen del juego",
                modifier = Modifier.size(64.dp)
            )
            Column(modifier = Modifier.weight(1f).padding(horizontal = 16.dp), horizontalAlignment = Alignment.Start) {
                Text(text = juego.nombre, style = MaterialTheme.typography.titleMedium)
                    if (juego.consola == "nintendo"){
                        Image(
                            painterResource(R.drawable.nintendo),
                            contentDescription = "Logo consola"
                        )
                    } else if (juego.consola == "playstation") {
                    Image(
                        painterResource(R.drawable.ps),
                        contentDescription = "Logo consola"
                    )
                }else if (juego.consola == "xbox") {
                        Image(
                            painterResource(R.drawable.xbox),
                            contentDescription = "Logo consola"
                        )
                }else{
                        Image(
                            painterResource(R.drawable.windows),
                            contentDescription = "Logo consola"
                        )
                }
                Text(juego.descripcion, fontStyle = FontStyle.Italic)
            }
            Column (horizontalAlignment = Alignment.End) {

                IconButton(onClick = onEliminar) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Eliminar")
                }
            }
        }
    }
}
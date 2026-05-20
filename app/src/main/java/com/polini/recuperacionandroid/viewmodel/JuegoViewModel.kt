package com.polini.recuperacionandroid.viewmodel


import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.polini.recuperacionandroid.data.Juego
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class JuegoViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("juegos")

    private val _juegos = MutableStateFlow<List<Juego>>(emptyList())
    val juegos: StateFlow<List<Juego>> = _juegos

    init {
        getJuegos()
    }

    fun getJuegos() {
        collection.addSnapshotListener { snapshot, error ->
            if (snapshot != null) {
                val lista = snapshot.documents.mapNotNull { doc ->
                    val juego = doc.toObject(Juego::class.java)
                    juego?.id = doc.id
                    juego
                }

                _juegos.value = lista
            }
        }
    }

    fun agregarJuego(
        nombre: String,
        nota: Double,
        descripcion: String,
        consola: String,
        imagenUrl: String
    ) {
        val juego = Juego(
            nombre = nombre,
            nota = nota,
            descripcion = descripcion,
            consola = consola,
            imagenUrl = imagenUrl,
        )

        collection.add(juego)
    }

    fun eliminarJuego(id: String) {
        collection.document(id).delete()
    }
}

package com.polini.recuperacionandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.polini.recuperacionandroid.navigation.GestionNavegacion
import com.polini.recuperacionandroid.ui.theme.RecuperacionAndroidTheme

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        enableEdgeToEdge()

        setContent {
            RecuperacionAndroidTheme {
                GestionNavegacion()
            }
        }
    }
}
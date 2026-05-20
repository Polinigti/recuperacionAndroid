package com.polini.recuperacionandroid.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.polini.recuperacionandroid.R

@Composable
fun LoginScreen(auth: FirebaseAuth,modifier: Modifier,onLoginSuccess:()-> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(R.drawable.logo_app), contentDescription = "Logo")
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (visible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (visible) "Ocultar contraseña" else "Mostrar contraseña"

                IconButton(onClick = { visible = !visible }) {
                    Icon(imageVector = icon, contentDescription = description)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier.fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5D7D7C)),
            onClick = {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        onLoginSuccess()
                    }
                    .addOnFailureListener {
                        errorMessage = "Credenciales incorrectas o error de conexión."
                    }
            }else{
                errorMessage = "Por favor, rellene todos los campos."
            }
        }) {
            Text("Login")
        }

        errorMessage?.let { message ->
            AlertDialog(
                onDismissRequest = { errorMessage = null },
                confirmButton = {
                    Button(onClick = { errorMessage = null }) {
                        Text("Aceptar")
                    }
                },
                title = { Text("Error") },
                text = { Text(message) }
            )
        }
    }
}
package com.example.meuformulario

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.meuformulario.ui.theme.MeuformularioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeuformularioTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FormularioTela()
                }
            }
        }
    }
}

@Composable
fun FormularioTela() {
    val context = LocalContext.current

    var nome by remember { mutableStateOf(TextFieldValue("")) }
    var telefone by remember { mutableStateOf(TextFieldValue("")) }
    var curso by remember { mutableStateOf(TextFieldValue("")) }
    var serie by remember { mutableStateOf(TextFieldValue("")) }
    var observacoes by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Card(
            modifier = Modifier.size(120.dp),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Avatar",
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome") })
        OutlinedTextField(value = telefone, onValueChange = { telefone = it }, label = { Text("Telefone") })
        OutlinedTextField(value = curso, onValueChange = { curso = it }, label = { Text("Curso") })
        OutlinedTextField(value = serie, onValueChange = { serie = it }, label = { Text("Série") })
        OutlinedTextField(
            value = observacoes,
            onValueChange = { observacoes = it },
            label = { Text("Observações") },
            maxLines = 3,
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val mensagem = """
                Nome: ${nome.text}
                Telefone: ${telefone.text}
                Curso: ${curso.text}
                Série: ${serie.text}
                Observações: ${observacoes.text}
            """.trimIndent()

            Toast.makeText(context, mensagem, Toast.LENGTH_LONG).show()
        }) {
            Text("Enviar")
        }
    }
}

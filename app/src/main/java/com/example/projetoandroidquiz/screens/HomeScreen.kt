package com.example.projetoandroidquiz.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetoandroidquiz.components.LoadingComponent
import com.example.projetoandroidquiz.data.Nivel
import com.example.projetoandroidquiz.viewmodel.SharedViewModel
import kotlinx.coroutines.delay


@Composable
fun HomeScreen(
    navController: NavController, viewModel: SharedViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp), verticalArrangement = Arrangement.Center
    ) {

        var isLoading by remember { mutableStateOf<Boolean>(true) }

        LaunchedEffect(Unit) {
            delay(2000) // 2 segundos
            isLoading = false
        }

        if (isLoading) {
            LoadingComponent(true)
        } else {
            Text(
                text = "Escolha o nível", style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(32.dp))

            Nivel.entries.forEach { nivel ->
                if (nivel == Nivel.NONE) return@forEach
                Button(
                    onClick = {
                        viewModel.nivelSelecionado = nivel
                        navController.navigate("quiz")
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(nivel.name)
                }

            }
        }
    }

}
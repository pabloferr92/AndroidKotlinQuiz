package com.example.projetoandroidquiz.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.projetoandroidquiz.viewmodel.SharedViewModel

@Composable
fun ResultTopBar (navController: NavController) {
    @OptIn(ExperimentalMaterial3Api::class) (TopAppBar(
        title = { Text("Resultados") },
        navigationIcon = {
            IconButton (
                onClick = {
                    navController.navigate("home") {
                        launchSingleTop = true
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = false // limpa a pilha até o startDestination
                        }
                    }
                }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar para Home")
            }
        }))
}
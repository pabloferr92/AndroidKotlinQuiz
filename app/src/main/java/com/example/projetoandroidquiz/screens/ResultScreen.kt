package com.example.projetoandroidquiz.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetoandroidquiz.components.RespostaCard
import com.example.projetoandroidquiz.components.ResultTopBar
import com.example.projetoandroidquiz.data.Resposta
import com.example.projetoandroidquiz.viewmodel.SharedViewModel
import java.util.Locale


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ResultScreen(
    navController: NavController,
    viewModel: SharedViewModel,

    ) {


    Scaffold(
        topBar = { ResultTopBar(navController) },
        content = { innerPadding -> ResultContent(navController, viewModel) }
    )
}

@Composable
fun ResultContent (navController: NavController, viewModel: SharedViewModel) {
    val total = viewModel.listaRespostas.size
    val acertos =
        remember(viewModel.listaRespostas) { viewModel.listaRespostas.count { it.correcao } }
    val percentual = remember(acertos, total) { if (total > 0) acertos.toFloat() / total else 0f }
    val nota10 = remember(percentual) { percentual * 10f }
    val notaFormatada = remember(nota10) { String.format(Locale.getDefault(), "%.1f", nota10) }
    val percentualFormatado =
        remember(percentual) { String.format(Locale.getDefault(), "%.0f%%", percentual * 100f) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {

        // Lista de viewModel.listaRespostas
        LazyColumn(
            modifier = Modifier.weight(1f, fill = false), // ← NÃO preenche espaço vazio
        ) {
            itemsIndexed(viewModel.listaRespostas) { index, item ->



                    RespostaCard(item)

            }
        }
        ResumoNota(
            acertos = acertos,
            total = total,
            percentual = percentualFormatado,
            nota10 = notaFormatada
        )

    }
}

@Composable
private fun ResumoNota(
    acertos: Int, total: Int, percentual: String, nota10: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Resultado",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Acertos: $acertos de $total ($percentual)",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Nota (0–10): $nota10",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )
    }
}

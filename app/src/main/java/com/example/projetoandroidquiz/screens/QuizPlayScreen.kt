package com.example.projetoandroidquiz.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetoandroidquiz.data.Pergunta
import com.example.projetoandroidquiz.data.QuizRepo
import com.example.projetoandroidquiz.data.Resposta
import com.example.projetoandroidquiz.viewmodel.SharedViewModel


@Composable
fun QuizPlayScreen(
    navController: NavController,
    viewModel: SharedViewModel
) {

    fun onFinish(listaResposta: SnapshotStateList<Resposta>) {
        viewModel.listaRespostas = listaResposta
        navController.navigate("results")
        println("Lista de Respostas " + listaResposta.toString())
    }

    fun criarResposta(pergunta: Pergunta, selecionada: Int? = 0): Resposta {

        val resposta: Resposta = Resposta(
            pergunta,
            selecionada,
            pergunta.opcoes[selecionada!!].correta
        )

        return resposta

    }

    val listRespostas = remember { mutableStateListOf<Resposta>() }

    val localNivel = viewModel.nivelSelecionado

    val quizRepo: QuizRepo = QuizRepo(localNivel)

    var perguntas = remember { quizRepo.obterPerguntas() }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        var indiceAtual by remember { mutableStateOf(0) }

        val pergunta = perguntas[indiceAtual]

        var respostaSelecionada by remember { mutableStateOf<Int?>(null) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Texto da pergunta
            Text(
                text = pergunta.pergunta,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Opções
            pergunta.opcoes.forEachIndexed { index, opcao ->

                val selecionado = respostaSelecionada == index

                Button(
                    onClick = { respostaSelecionada = index },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selecionado) Color(0xFF4CAF50) else MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(text = opcao.texto)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {

                    listRespostas.add(criarResposta(pergunta, respostaSelecionada))

                    if (indiceAtual < perguntas.size - 1) {
                        indiceAtual++
                        respostaSelecionada = null
                    } else {
                        onFinish(listRespostas)
                    }
                },
                modifier = Modifier.align(Alignment.End),
                enabled = respostaSelecionada != null
            ) {
                Text(if (indiceAtual < perguntas.size - 1) "Próxima" else "Finalizar")
            }
        }


    }

}
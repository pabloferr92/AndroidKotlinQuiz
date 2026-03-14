package com.example.projetoandroidquiz.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetoandroidquiz.data.Resposta


@Composable
fun RespostaCard(resposta: Resposta) {


    val icone = if (resposta.correcao) Icons.Default.Check else Icons.Default.Close
    val corIcone = if (resposta.correcao) Color(0xFF36C441) else Color(0xFFE53935)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = resposta.pergunta.pergunta,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )



                Spacer(modifier = Modifier.height(8.dp))

                var respostaCorreta = resposta.pergunta.opcoes.filter { opcao -> opcao.correta == true }[0].texto


                Text(
                    text = "Escolha:  ${resposta.pergunta.opcoes[resposta.resposta!!].texto}",
                    color = Color(0xFF1A73E8),
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "Correção: ${respostaCorreta}",
                    color = Color(0xFF1A73E8),
                    fontWeight = FontWeight.Medium
                )
            }

            Icon(
                imageVector = icone,
                contentDescription = null,
                tint = corIcone,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

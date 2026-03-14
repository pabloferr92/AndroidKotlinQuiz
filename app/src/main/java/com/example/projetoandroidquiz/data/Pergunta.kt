package com.example.projetoandroidquiz.data



data class Opcao(
    val texto: String,
    val correta: Boolean
)


data class Pergunta(
    val id: Int,
    val pergunta: String,
    val opcoes: List<Opcao>,
    val respostaCorreta: Int,
    val nivel: Nivel
)
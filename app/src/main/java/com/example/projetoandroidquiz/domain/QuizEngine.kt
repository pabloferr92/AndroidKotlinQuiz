package com.example.projetoandroidquiz.domain

import com.example.projetoandroidquiz.data.Pergunta

class QuizEngine(private val perguntas: List<Pergunta>) {

    private var indiceAtual = 0
    var pontuacao = 0

    fun obterProximaPergunta(): Pergunta? {
        return if (indiceAtual < perguntas.size) {
            perguntas[indiceAtual++]
        } else {
            null
        }
    }

    fun corrigirResposta(resposta: Int, pergunta: Pergunta) {
        if (resposta == pergunta.respostaCorreta) {
            pontuacao++
        }
    }

}
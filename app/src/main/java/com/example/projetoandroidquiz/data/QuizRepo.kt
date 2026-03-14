package com.example.projetoandroidquiz.data

class QuizRepo (private val nivel : Nivel) {


    private val listaPerguntas =
        listOf(
            // FÁCEIS
            Pergunta(
                id = 1,
                pergunta = "Qual a capital do Brasil?",
                opcoes = mutableListOf(
                    Opcao("São Paulo", false),
                    Opcao("Brasília", true),
                    Opcao("Rio de Janeiro", false),
                    Opcao("Salvador", false)
                ),
                respostaCorreta = 1,
                nivel = Nivel.FACIL
            ),
            Pergunta(
                id = 2,
                pergunta = "Quanto é 2 + 2?",
                opcoes = mutableListOf(
                    Opcao("3", false),
                    Opcao("4", true),
                    Opcao("5", false),
                    Opcao("6", false)
                ),
                respostaCorreta = 1,
                nivel = Nivel.FACIL
            ),
            Pergunta(
                id = 3,
                pergunta = "Qual cor resulta da mistura de azul e amarelo?",
                opcoes = mutableListOf(
                    Opcao("Verde", true),
                    Opcao("Roxo", false),
                    Opcao("Laranja", false),
                    Opcao("Preto", false)
                ),
                respostaCorreta = 0,
                nivel = Nivel.FACIL
            ),

            // MÉDIAS
            Pergunta(
                id = 4,
                pergunta = "Qual planeta é conhecido como planeta vermelho?",
                opcoes = mutableListOf(
                    Opcao("Marte", true),
                    Opcao("Júpiter", false),
                    Opcao("Vênus", false),
                    Opcao("Saturno", false)
                ),
                respostaCorreta = 0,
                nivel = Nivel.MEDIO
            ),
            Pergunta(
                id = 5,
                pergunta = "Quantos continentes existem?",
                opcoes = mutableListOf(
                    Opcao("5", false),
                    Opcao("6", false),
                    Opcao("7", true),
                    Opcao("8", false)
                ),
                respostaCorreta = 2,
                nivel = Nivel.MEDIO
            ),
            Pergunta(
                id = 6,
                pergunta = "Quem pintou a Mona Lisa?",
                opcoes = mutableListOf(
                    Opcao("Michelangelo", false),
                    Opcao("Leonardo da Vinci", true),
                    Opcao("Van Gogh", false),
                    Opcao("Picasso", false)
                ),
                respostaCorreta = 1,
                nivel = Nivel.MEDIO
            ),

            // DIFÍCEIS
            Pergunta(
                id = 7,
                pergunta = "Qual é o maior oceano da Terra?",
                opcoes = mutableListOf(
                    Opcao("Atlântico", false),
                    Opcao("Índico", false),
                    Opcao("Ártico", false),
                    Opcao("Pacífico", true)
                ),
                respostaCorreta = 3,
                nivel = Nivel.DIFICIL
            ),
            Pergunta(
                id = 8,
                pergunta = "Qual linguagem é usada oficialmente para Android?",
                opcoes = mutableListOf(
                    Opcao("Swift", false),
                    Opcao("Kotlin", true),
                    Opcao("Ruby", false),
                    Opcao("Go", false)
                ),
                respostaCorreta = 1,
                nivel = Nivel.DIFICIL
            ),
            Pergunta(
                id = 9,
                pergunta = "Qual é o valor de PI aproximado?",
                opcoes = mutableListOf(
                    Opcao("2.14", false),
                    Opcao("3.14", true),
                    Opcao("4.13", false),
                    Opcao("3.41", false)
                ),
                respostaCorreta = 1,
                nivel = Nivel.DIFICIL
            )
        )


    public fun obterPerguntas(): List<Pergunta> {

        val perguntas_embaralhadas = listaPerguntas.map { it.copy(opcoes = it.opcoes.shuffled())}

        return perguntas_embaralhadas.filter { it.nivel == nivel }.shuffled()
    }

}
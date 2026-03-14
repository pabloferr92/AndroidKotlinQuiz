package com.example.projetoandroidquiz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import com.example.projetoandroidquiz.data.Nivel
import com.example.projetoandroidquiz.data.Pergunta
import com.example.projetoandroidquiz.data.Resposta

class SharedViewModel : ViewModel() {


    var listaRespostas = mutableStateListOf<Resposta>()

    var nivelSelecionado by mutableStateOf<Nivel>(Nivel.NONE)


}

package com.example.paratestar.dao

import com.example.paratestar.model.Produto

class ProdutosDao {

    fun adiciona(produto: Produto) {
       produtos.add(produto)
    }

    fun buscarTodos() : List<Produto> {
        return produtos.toList()
    }

    companion object { //solução para manter a mesma lista mesmo executando varias vezes
        private val produtos = mutableListOf<Produto>()
    }
}
package com.example.paratestar.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.paratestar.R
import com.example.paratestar.dao.ProdutosDao
import com.example.paratestar.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity((R.layout.activity_formulario_produto)) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cinfiguraBotaoSalvar()
    }

    private fun cinfiguraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.button)
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish() //usado para finalizar a activity e não ficar empilhando
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_nome)
        val nome = campoNome.text.toString()
        val campoDescricao = findViewById<EditText>(R.id.activity_descricao)
        val descricao = campoDescricao.text.toString()
        val campoValor = findViewById<EditText>(R.id.activity_valor)
        val valorEmText = campoValor.text.toString()
        val valor = if (valorEmText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmText)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}

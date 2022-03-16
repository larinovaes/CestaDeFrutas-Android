package com.example.paratestar.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paratestar.R
import com.example.paratestar.dao.ProdutosDao
import com.example.paratestar.recyclerView.ListaDeProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val dao = ProdutosDao()
    private val adapter = ListaDeProdutosAdapter(context = this, produto = dao.buscarTodos())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()

    }

    override fun onResume() {
        super.onResume()
        adapter.atualizarLista(dao.buscarTodos())
        configFab()
    }

    private fun configRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        //Indicando para o recyclerView por linha de codigo o que quero que aparça na tela
    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        //usando intent para chamar a proxima tela que voce quer, no caso activity
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }
}

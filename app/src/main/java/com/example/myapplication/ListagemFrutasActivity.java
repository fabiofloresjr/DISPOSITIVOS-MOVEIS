package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListagemFrutasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_frutas);
        List<Fruta> listaFruta = (List<Fruta>) getIntent().
                getSerializableExtra("lista");

        TextView textView = findViewById(R.id.textViewListagemFrutas);

        StringBuilder mensagem = new StringBuilder();
        for(int i=0; i < listaFruta.size(); i++){
            Fruta fruta = listaFruta.get(i);
            mensagem.append(fruta.getNome());
            mensagem.append(" R$ ");
            mensagem.append(fruta.getPreco());
            mensagem.append("\n");
            mensagem.append("---------------------------------");
            mensagem.append("\n");

        }

        textView.setText(mensagem.toString());




    }
    public void abreTelaAtualizacao(View view) {

        Intent intent = new Intent(this,UpdateFrutaActivity.class);
        startActivity(intent);
    }
    public void abreTelaDelete(View view) {

        Intent intent = new Intent(this,activity_delete_fruta.class);
        startActivity(intent);
    }
}
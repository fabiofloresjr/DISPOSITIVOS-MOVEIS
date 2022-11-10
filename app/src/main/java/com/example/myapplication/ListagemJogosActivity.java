package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListagemJogosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_jogos);
        List<Jogo> listaJogo = (List<Jogo>) getIntent().
                getSerializableExtra("lista");

        TextView textView = findViewById(R.id.textViewListagemJogos);

        StringBuilder mensagem = new StringBuilder();
        for(int i=0; i < listaJogo.size(); i++){
            Jogo jogo = listaJogo.get(i);
            mensagem.append(jogo.getNome());
            mensagem.append(" R$ ");
            mensagem.append(jogo.getPreco());
            mensagem.append("\n");
            mensagem.append("---------------------------------");
            mensagem.append("\n");

        }

        textView.setText(mensagem.toString());




    }
    public void abreTelaAtualizacao(View view) {

        Intent intent = new Intent(this, UpdateJogoActivity.class);
        startActivity(intent);
    }
    public void abreTelaDelete(View view) {

        Intent intent = new Intent(this, DeleteJogoActivity.class);
        startActivity(intent);
    }
    public void abreTelaCadastro(View view){

        Intent intent = new Intent(this, CadastroJogosActivity.class);
        startActivity(intent);
    }
}
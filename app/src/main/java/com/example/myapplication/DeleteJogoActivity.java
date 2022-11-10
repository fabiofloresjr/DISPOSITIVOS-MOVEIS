package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class DeleteJogoActivity extends AppCompatActivity {

    BancoDadosJogo bancoDadosJogo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_jogo);

        bancoDadosJogo = new BancoDadosJogo(this);
    }
    public void deletarJogo(View view){

        EditText nome = findViewById(R.id.editTextNomeJogoDelete);
        String nomeJogo = nome.getText().toString();

        bancoDadosJogo.deletarJogoPorNome(nomeJogo);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDadosJogo.buscaTodosJogos());

        Intent intent = new Intent(this, ListagemJogosActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
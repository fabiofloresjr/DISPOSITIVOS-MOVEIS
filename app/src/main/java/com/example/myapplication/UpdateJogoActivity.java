package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class UpdateJogoActivity extends AppCompatActivity {

    BancoDadosJogo bancoDadosJogo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_jogo);

        bancoDadosJogo = new BancoDadosJogo(this);
    }

    public void atualizarJogo(View view) {

        EditText nome1 = findViewById(R.id.editTextNomeJogoDelete);
        EditText novoPrecoJogo = findViewById(R.id.editTextNovoPrecoJogo);

        String nome = nome1.getText().toString();
        Float precoJogoFloat = Float.parseFloat(novoPrecoJogo.getText().toString());


        bancoDadosJogo.updatePrecoJogo(nome,precoJogoFloat);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDadosJogo.buscaTodosJogos());

        Intent intent= new Intent(this, ListagemJogosActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
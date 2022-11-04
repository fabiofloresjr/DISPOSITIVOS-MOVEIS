package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class activity_delete_fruta extends AppCompatActivity {

    BancoDadosFruta bancoDadosFruta = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_fruta);

        bancoDadosFruta = new BancoDadosFruta(this);
    }
    public void deletarFruta(View view){

        EditText nome = findViewById(R.id.editTextNomeFrutaDelete);
        String nomeFruta = nome.getText().toString();

        bancoDadosFruta.deletarFrutaPorNome(nomeFruta);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDadosFruta.buscaTodasFrutas());

        Intent intent = new Intent(this, ListagemFrutasActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
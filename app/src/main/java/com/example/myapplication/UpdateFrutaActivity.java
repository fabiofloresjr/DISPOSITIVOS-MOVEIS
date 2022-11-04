package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class UpdateFrutaActivity extends AppCompatActivity {

    BancoDadosFruta bancoDadosFruta = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_fruta);

        bancoDadosFruta = new BancoDadosFruta(this);
    }

    public void atualizarFruta(View view) {

        EditText nome1 = findViewById(R.id.editTextNomeFrutaDelete);
        EditText novoPrecoFruta = findViewById(R.id.editTextNovoPrecoFruta);

        String nome = nome1.getText().toString();
        Float precoFrutaFloat = Float.parseFloat(novoPrecoFruta.getText().toString());


        bancoDadosFruta.updatePrecoFruta(nome,precoFrutaFloat);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDadosFruta.buscaTodasFrutas());

        Intent intent= new Intent(this,ListagemFrutasActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
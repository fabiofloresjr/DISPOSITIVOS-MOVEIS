package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// para visualizar as tabelas, usar a ferramenta no android studio, chamada
// AAPP INSPECTION

public class BancoDadosFruta extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "fruta";
    private static int VERSAO = 3;

    public BancoDadosFruta(Context context){
        super(context,NOME_BANCO,null,VERSAO);
        String name = getDatabaseName();
        Log.i("frutas",name);

        getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("fruta","Sendo executado onCreate");

        String sql = "CREATE TABLE fruta (" +
                "id INTEGER PRIMARY KEY Autoincrement," +
                "nome TEXT NOT NULL," +
                "preco REAL NOT NULL)";

        sqLiteDatabase.execSQL(sql);

        Log.i("fruta","Executado onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("fruta","Executado onUpgrade");
    }

    // salvar por modo tradicional
    public void salvarFruta2(Fruta fruta){
         // insert into fruta values (null,'maca',5 );
        String sql = "insert into fruta values (null,'" +
                fruta.getNome()+ "', " + fruta.getPreco() + " )";
        Log.i("fruta","SQL salvarFruta2: " + sql);

        getWritableDatabase().execSQL(sql);

    }

    public List<Fruta> buscaTodasFrutas(){
        List<Fruta> listaFruta = new ArrayList<>();
        String sql = "select nome,preco from fruta";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Fruta fruta = new Fruta();
            fruta.setNome(cursor.getString(0));
            fruta.setPreco(cursor.getFloat(1));
            listaFruta.add(fruta);
            cursor.moveToNext();
        }
        cursor.close();
        return listaFruta;
    }
    public void deletarFrutaPorNome(String nomeFruta){
        String sql = "delete from fruta where nome == '" + nomeFruta + "'";
        Log.i("fruta","SQL deletarFrutaPorNome: " + sql);
        getWritableDatabase().execSQL(sql);
    }
    public void updatePrecoFruta(String nome, Float novoPreco){
        String sql = "update fruta set preco = '" + novoPreco + "' where nome == '" + nome + "'" ;
        Log.i("fruta","SQL updatePrecoFruta: " + sql);
        getWritableDatabase().execSQL(sql);
    }
    public void updateFruta(Integer id, Float novoPreco,String nome){
        StringBuilder sql = new StringBuilder();
        sql.append("update fruta set ");
        if(novoPreco != null && nome != null){
            sql.append(" preco = ").append(novoPreco).append(",");
            sql.append(" nome = ").append(nome);
        }
        sql.append(" where id = ").append(id);
        Log.i("fruta","SQL updateFruta: " + sql.toString());
        getWritableDatabase().execSQL(sql.toString());
    }

}
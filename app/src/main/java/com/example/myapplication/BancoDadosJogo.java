package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BancoDadosJogo extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "jogo";
    private static int VERSAO = 3;

    public BancoDadosJogo(Context context){
        super(context,NOME_BANCO,null,VERSAO);
        String name = getDatabaseName();
        Log.i("jogos",name);

        getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("jogos","Sendo executado onCreate");

        String sql = "CREATE TABLE jogo (" +
                "id INTEGER PRIMARY KEY Autoincrement," +
                "nome TEXT NOT NULL," +
                "preco REAL NOT NULL)";

        sqLiteDatabase.execSQL(sql);

        Log.i("jogo","Executado onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("jogo","Executado onUpgrade");
    }

    // salvar por modo tradicional
    public void salvarJogo(Jogo jogo){
         // insert into jogo values (null,'maca',5 );
        String sql = "insert into jogo values (null,'" +
                jogo.getNome()+ "', " + jogo.getPreco() + " )";
        Log.i("jogo","SQL salvarJogo: " + sql);

        getWritableDatabase().execSQL(sql);

    }

    public List<Jogo> buscaTodosJogos(){
        List<Jogo> listaJogo = new ArrayList<>();
        String sql = "select nome,preco from jogo";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Jogo jogo = new Jogo();
            jogo.setNome(cursor.getString(0));
            jogo.setPreco(cursor.getFloat(1));
            listaJogo.add(jogo);
            cursor.moveToNext();
        }
        cursor.close();
        return listaJogo;
    }
    public void deletarJogoPorNome(String nomeJogo){
        String sql = "delete from jogo where nome == '" + nomeJogo + "'";
        Log.i("jogo","SQL deletarJogoPorNome: " + sql);
        getWritableDatabase().execSQL(sql);
    }
    public void updatePrecoJogo(String nome, Float novoPreco){
        String sql = "update jogo set preco = '" + novoPreco + "' where nome == '" + nome + "'" ;
        Log.i("jogo","SQL updatePrecoJogo: " + sql);
        getWritableDatabase().execSQL(sql);
    }
    public void updateJogo(Integer id, Float novoPreco, String nome){
        StringBuilder sql = new StringBuilder();
        sql.append("update jogo set ");
        if(novoPreco != null && nome != null){
            sql.append(" preco = ").append(novoPreco).append(",");
            sql.append(" nome = ").append(nome);
        }
        sql.append(" where id = ").append(id);
        Log.i("jogo","SQL updateJogo: " + sql.toString());
        getWritableDatabase().execSQL(sql.toString());
    }

}
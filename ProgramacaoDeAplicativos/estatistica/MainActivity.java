package com.example.stat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    Repositorio r = new Repositorio();
    AlertDialog.Builder alerta;
    EditText a;
    EditText m;
    EditText i;
    EditText n;
    CheckBox m1;
    CheckBox m2;
    CheckBox m3;
    float[][] t;
    int qi;
    int qv = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alerta = new AlertDialog.Builder(this);
        a = (EditText) findViewById(R.id.a);
        m = (EditText) findViewById(R.id.m);
        i = (EditText) findViewById(R.id.i);
        n = (EditText) findViewById(R.id.n);
        m1 = (CheckBox) findViewById(R.id.media);
        m2 = (CheckBox) findViewById(R.id.mediana);
        m3 = (CheckBox) findViewById(R.id.moda);
    }

    public void cadastra(View view){
        String nome = a.getText().toString();
        int matricula = Integer.parseInt(m.getText().toString());
        int idade = Integer.parseInt(i.getText().toString());
        float nota = Float.parseFloat(n.getText().toString());
        r.alunos.add(new Aluno(nome, matricula, idade, nota));
        Toast.makeText(MainActivity.this, "Aluno cadastrado", Toast.LENGTH_LONG).show();
        a.setText(null);
        m.setText(null);
        i.setText(null);
        n.setText(null);

    }

    public void populaTabela(){
        Aluno[] va = r.alunos.toArray(new Aluno[qi]);
        for(int i = 0; i<qv; i++){
            for(int j = 0; j<qi; j++){
                if(i == 0){
                    t[j][i] = va[j].idade;
                }
                else{
                    t[j][i] = va[j].nota;
                }
            }
        }
    }

    public void calcula(View view){
        if(m1.isChecked()||m2.isChecked()||m3.isChecked()){
            qi = r.alunos.size();
            if(qi>0){
                t = new float[qi][qv];
                populaTabela();
                if(m1.isChecked()){
                    calculaMedia();
                }
                if(m2.isChecked()){
                    calculaMediana();
                }
                if(m3.isChecked()){
                    calculaModa();
                }
            }
            else{
                alerta.setTitle("ERRO");
                alerta.setMessage("Cadastre um aluno");
                alerta.show();
            }
        }
        else{
            alerta.setTitle("ERRO");
            alerta.setMessage("Selecione um cálculo");
            alerta.show();
        }

    }

    public void calculaMedia(){
        int qi = 0;
        for(Aluno a:r.alunos){
            qi++;
        }
        for(int i = 0; i<qv; i++) {
            float media = 0;
            for (int j = 0; j < qi; j++) {
                media = media + t[j][i];
            }
            media = media / qi;
            if(i == 0){
                alerta.setMessage("idade: "+media);
            }
            else{
                alerta.setMessage("nota: "+media);
            }
            alerta.setTitle("MÉDIA");
            alerta.show();
        }
    }
    public void calculaMediana(){
        int qi = 0;
        for(Aluno a:r.alunos){
            qi++;
        }
        for(int i = 0; i<qv; i++){
            float mediana = 0;
            float []vs = new float[qi];
            for(int j = 0; j<qi; j++){
                vs [j]= t[j][i];
            }
            Arrays.sort(vs);
            int meio = qi/2;
            if(qi%2 == 1 ){
                mediana = vs[meio];
            }
            else{
                mediana = (vs[meio-1]+vs[meio])/2;
            }
            if(i == 0){
                alerta.setMessage("idade: "+mediana);
            }
            else{
                alerta.setMessage("nota: "+mediana);
            }
            alerta.setTitle("MEDIANA");
            alerta.show();

        }

    }

    public void calculaModa(){
        int qi = 0;
        for(Aluno a:r.alunos){
            qi++;
        }
        for(int i = 0; i<qv; i++){
            int maximoOcorrencia = 0;
            LinkedList<Float> modas = new LinkedList<Float>();
            for(int j = 0; j<qi; j++){
                int contOcorrencia = 0;
                for(int k = 0; k<qi; k++){
                    if(t[k][i] == t[j][i] && k!=j){
                        contOcorrencia++;
                    }
                }
                if(contOcorrencia > maximoOcorrencia){
                    maximoOcorrencia = contOcorrencia;
                    modas.clear();
                    modas.add(t[j][i]);
                }
                else if(contOcorrencia == maximoOcorrencia && !modas.contains(t[j][i])){
                    modas.add(t[j][i]);
                }
            }

            String s = "";
            if(i == 0){
                s = "idade:\n";
            }
            else{
                s = "nota:\n";
            }
            alerta.setTitle("MODA(S)");
            for(float f:modas){
                s = s+f+"\n";
            }
            alerta.setMessage(s);
            alerta.show();
        }
    }

}
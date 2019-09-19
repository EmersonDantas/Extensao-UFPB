package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.extensaoufpb.extensaoufpb.R;

public class SignProjectActivity extends AppCompatActivity {

    private TextView txtNomeCoordenador, txtStatusProjeto, txtAnoProjeto, txtDescricao;
    private ImageView imgStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_project);

        txtNomeCoordenador = findViewById(R.id.nomeCoordenador);
        txtStatusProjeto = findViewById(R.id.statusProjetoTxt);
        txtAnoProjeto = findViewById(R.id.anoProjeto);
        txtDescricao = findViewById(R.id.descricaoProjeto);
        imgStatus = findViewById(R.id.statusProjetoImg);

        txtNomeCoordenador.setText("Ayla Rebouças");
        txtStatusProjeto.setText("Ativo");
        txtAnoProjeto.setText("2019");
        txtDescricao.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an " +
                "unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing " +
                "software like Aldus PageMaker including versions of Lorem Ipsum.");

        findViewById(R.id.btnCadastrarProjeto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirConfirmacao();
            }
        });
    }

    public void exibirConfirmacao(){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(this);
        mensagem.setTitle("Confirmação");
        mensagem.setIcon(null);
        mensagem.setMessage("Você está prestes a cadastrar o projeto X. Está de acordo?");
        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SignProjectActivity.this, "Projeto cadastrado!", Toast.LENGTH_LONG).show();
            }
        });
        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SignProjectActivity.this, "Cadastro cancelado!", Toast.LENGTH_LONG).show();
            }
        });
        mensagem.show();
    }
}
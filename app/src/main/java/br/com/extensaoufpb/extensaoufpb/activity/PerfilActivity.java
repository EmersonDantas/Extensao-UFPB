package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import br.com.extensaoufpb.extensaoufpb.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilActivity extends AppCompatActivity {

    private CircleImageView fotoUser;
    private EditText nomeUser;
    private EditText sobreNomeUser;
    private EditText emailUser;
    private Button btnEditarSenha, btnSair, btnVoltar, btnEditarPerfil;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        fotoUser = findViewById(R.id.foto_perfil);
        nomeUser = findViewById(R.id.txtNome);
        sobreNomeUser = findViewById(R.id.txtSobrenome);
        emailUser = findViewById(R.id.txtEmail);

        fotoUser.setImageResource(R.drawable.perfil);
        nomeUser.setText("Francivaldo");
        sobreNomeUser.setText("Napoleão");
        emailUser.setText("francivaldo.napoleao@dcx.ufpb.br");

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(PerfilActivity.this, BaseActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnEditarPerfil = findViewById(R.id.btnEditPerfil);
        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(PerfilActivity.this, EditPerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnEditarSenha = findViewById(R.id.btnEditSenha);
        btnEditarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(PerfilActivity.this, EditPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
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
        mensagem.setMessage("Deseja sair do sistema?");
        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(PerfilActivity.this, "Até a próxima!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(PerfilActivity.this, "Continuando...", Toast.LENGTH_LONG).show();
            }
        });
        mensagem.show();
    }
}
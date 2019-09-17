package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.extensaoufpb.extensaoufpb.R;

public class EditPasswordActivity extends AppCompatActivity {

    private Button btnSalvarNovaSenha, btnVoltarEditSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        btnSalvarNovaSenha = findViewById(R.id.btnSalvarNovaSenha);
        btnSalvarNovaSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirConfirmacao();
            }
        });

        btnVoltarEditSenha = findViewById(R.id.btnVoltarEditSenha);
        btnVoltarEditSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(EditPasswordActivity.this, PerfilActivity.class);
                startActivity(it);
                finish();
            }
        });
    }

    public void exibirConfirmacao(){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(this);
        mensagem.setTitle("Confirmação");
        mensagem.setIcon(null);
        mensagem.setMessage("Você está prestes a trocar sua senha. Tem certeza disso?");
        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EditPasswordActivity.this, "Senha alterada!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EditPasswordActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EditPasswordActivity.this, "Alteração cancelada!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EditPasswordActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mensagem.show();
    }
}

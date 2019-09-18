package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.extensaoufpb.extensaoufpb.R;

public class EditPerfilActivity extends AppCompatActivity {

    private ImageView img;
    private Button btnSalvarEditPerfil, btnVoltarEditPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_perfil);

        img = findViewById(R.id.foto_perfil);
        img.setImageResource(R.drawable.perfil);

        btnSalvarEditPerfil = findViewById(R.id.btnSalvarEditPerfil);
        btnSalvarEditPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirConfirmacao();
            }
        });

        btnVoltarEditPerfil = findViewById(R.id.btnVoltarEditPerfil);
        btnVoltarEditPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPerfilActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void exibirConfirmacao(){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(this);
        mensagem.setTitle("Confirmação");
        mensagem.setIcon(null);
        mensagem.setMessage("Você está prestes a editar os dados do seu perfil. Tem certeza disso?");
        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EditPerfilActivity.this, "Dados alterados!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EditPerfilActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EditPerfilActivity.this, "Alteração cancelada!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EditPerfilActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mensagem.show();
    }
}

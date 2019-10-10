package br.com.extensaoufpb.extensaoufpb.activity.ui.profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import br.com.extensaoufpb.extensaoufpb.Controller.FacadeQuestion;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.LoginActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener{

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


        init();
        enableAllClicks();
    }

    private void init() {
        fotoUser = findViewById(R.id.foto_perfil);
        nomeUser = findViewById(R.id.txtNome);
        sobreNomeUser = findViewById(R.id.txtSobrenome);
        emailUser = findViewById(R.id.txtEmail);
        fotoUser.setImageResource(R.drawable.emanoel);
        nomeUser.setText("Francivaldo");
        sobreNomeUser.setText("Napoleão");
        emailUser.setText("francivaldo.napoleao@dcx.ufpb.br");
        btnVoltar = findViewById(R.id.btnReturnPerfil);
        btnSair = findViewById(R.id.btnSair);
        btnEditarPerfil = findViewById(R.id.btnEditPerfil);
        btnEditarSenha = findViewById(R.id.btnEditSenha);
    }

    private void enableAllClicks() {

        btnVoltar.setOnClickListener(this);

        btnEditarPerfil.setOnClickListener(this);

        btnEditarSenha.setOnClickListener(this);

        btnSair.setOnClickListener(this);
    }

    public void exibirConfirmacao() {

        AlertDialog.Builder mensagem = new AlertDialog.Builder(this);
        mensagem.setTitle("Confirmação");
        mensagem.setIcon(null);
        mensagem.setMessage("Deseja sair do sistema?");

        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                FacadeQuestion.getInstance().logout();

                Toast.makeText(PerfilActivity.this, "Até a próxima!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });
        mensagem.show();
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btnSair:

                exibirConfirmacao();

                break;
            case R.id.btnEditPerfil:

                intent = new Intent(PerfilActivity.this, EditPerfilActivity.class);

                break;
            case R.id.btnEditSenha:

                intent = new Intent(PerfilActivity.this, EditPasswordActivity.class);

                break;

            case R.id.btnReturnPerfil:

                finish();

                break;

        }

        if(intent != null){

            startActivity(intent);
            finish();

        }

    }
}
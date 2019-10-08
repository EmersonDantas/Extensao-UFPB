package br.com.extensaoufpb.extensaoufpb.activity.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.LoginActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRegisterBack;
    private Button btnRegister;
    private Button btnGoToLogin;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findComponents();
    }

    private void findComponents(){
        btnRegisterBack = findViewById(R.id.btnRegisterBack);
        btnRegister = findViewById(R.id.btnRegister);
        btnGoToLogin = findViewById(R.id.btnGoToLogin);
        setListeners();
    }

    private void setListeners(){
        btnRegisterBack.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnGoToLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

    }
}

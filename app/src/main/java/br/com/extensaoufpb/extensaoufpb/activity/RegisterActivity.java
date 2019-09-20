package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.extensaoufpb.extensaoufpb.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRegisterBack;
    private Button btnRegister;
    private Button btnGoToLogin;

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
        switch (v.getId()){
            case(R.id.btnRegisterBack):
                finish();
                break;
            case(R.id.btnRegister):
                break;
            case(R.id.btnGoToLogin):
                break;
        }
    }
}

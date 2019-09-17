package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import br.com.extensaoufpb.extensaoufpb.R;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonBack;
    private Intent startIntent;

    private String emailCoordenetor = "coffeedevorg@gmail.com";
    private String emailOutros = "coffeedev@gmail.com";
    private String password = "extenssaoufpb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findComponent();
        init();

    }


    private void init(){

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startIntent = new Intent(LoginActivity.this, BaseActivity.class);
                startActivity(startIntent);
                finish();

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startIntent = new Intent(LoginActivity.this, BaseActivity.class);
                startActivity(startIntent);
                finish();

            }
        });

    }


    private void findComponent(){

        buttonLogin = findViewById(R.id.btnLogin);
        buttonBack = findViewById(R.id.btnBack);
    }
}

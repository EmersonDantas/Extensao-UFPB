package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.extensaoufpb.extensaoufpb.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent startLogin = new Intent(this, LoginActivity.class);
        startActivity(startLogin);
    }
}

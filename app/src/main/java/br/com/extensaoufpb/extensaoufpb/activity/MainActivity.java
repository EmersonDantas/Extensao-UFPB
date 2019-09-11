package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import br.com.extensaoufpb.extensaoufpb.R;

public class MainActivity extends AppCompatActivity {

    private final int TIME_SLEEP = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent startLogin = new Intent(MainActivity.this, LoginActivity.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.anim.fade_in , R.anim.fade_out);
                ActivityCompat.startActivity(MainActivity.this, startLogin,activityOptionsCompat.toBundle());
                finish();
            }
        },TIME_SLEEP);

    }
}

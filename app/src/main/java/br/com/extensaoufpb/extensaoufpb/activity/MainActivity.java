package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import br.com.extensaoufpb.extensaoufpb.R;

public class MainActivity extends AppCompatActivity {

    private final int TIME_SLEEP = 1500;
    private final int LIMITE_BAR = 2000;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        progressBarTime();




//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                final Intent startLogin = new Intent(MainActivity.this, LoginActivity.class);
//                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.anim.fade_in , R.anim.fade_out);
//                ActivityCompat.startActivity(MainActivity.this, startLogin,activityOptionsCompat.toBundle());
//                finish();
//            }
//        },TIME_SLEEP);

    }


    private void progressBarTime(){

        new Thread(new Runnable (){
            public void run() {

                int barStatus = 0;

                while(barStatus < LIMITE_BAR){
                    barStatus += 20;

                    try {

                        Thread.sleep(20);
                        progressBar.setProgress(barStatus);

                    }catch (InterruptedException erro){

                        erro.printStackTrace();

                    }

                }
                
                final Intent startLogin = new Intent(MainActivity.this, LoginActivity.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.anim.fade_in , R.anim.fade_out);
                ActivityCompat.startActivity(MainActivity.this, startLogin,activityOptionsCompat.toBundle());
                finish();

            }
        }).start();

    }
}



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
    private final int LIMITE_BAR = 1500;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        progressBarTime();

    }


    private void progressBarTime(){

        new Thread(new Runnable (){
            public void run() {

                int barStatus = 0;

                while(barStatus < LIMITE_BAR){
                    barStatus += 25;

                    try {

                        Thread.sleep(20);
                        progressBar.setProgress(barStatus);

                    }catch (InterruptedException erro){

                        erro.printStackTrace();

                    }

                }

                final Intent startLogin = new Intent(MainActivity.this, SuggestionsActivity.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(MainActivity.this,R.anim.item_animation_slide_from_bottom , R.anim.item_animation_fall_down);
                ActivityCompat.startActivity(MainActivity.this, startLogin,activityOptionsCompat.toBundle());
                finish();

            }
        }).start();

    }
}



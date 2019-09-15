package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import br.com.extensaoufpb.extensaoufpb.R;

public class EditPerfilActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_perfil);

        img = findViewById(R.id.foto_perfil);
        img.setImageResource(R.drawable.perfil);
    }
}

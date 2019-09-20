package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import br.com.extensaoufpb.extensaoufpb.R;

public class SubmitSuggestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_suggestion);

        Button buttonEnviar =(Button) findViewById(R.id.btnEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();

            }
        });


    }

    public void openDialog(){

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        alerta.setTitle(R.string.confirmacao);
        alerta.setMessage(R.string.dialogMenssegeEnviarSugestao);
        alerta.setCancelable(false);
        alerta.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // FIRE ZE MISSILES!

            }
        })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        alerta.create();
        alerta.show();
    }



}

package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import br.com.extensaoufpb.extensaoufpb.R;

import static android.app.PendingIntent.getActivity;

public class RegisterDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_data);


        Spinner spinner = (Spinner) findViewById(R.id.spinner01);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selecione, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner02);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.periodo, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Button buttonCadastrar =(Button) findViewById(R.id.btnCadastrar);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();

            }
        });


    }

    public void openDialog(){

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        alerta.setTitle(R.string.confirmacao);
        alerta.setMessage(R.string.dialogMenssegeDadosAcademicos);
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

package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import br.com.extensaoufpb.extensaoufpb.R;

public class NewProjectSuggestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project_suggestion);


        Spinner spinner = (Spinner) findViewById(R.id.spinner01);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.areaAplicacao, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button buttonCadastrar =(Button) findViewById(R.id.btnEnviar);

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

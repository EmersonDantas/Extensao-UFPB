package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import br.com.extensaoufpb.extensaoufpb.Controller.BottomSheet;
import br.com.extensaoufpb.extensaoufpb.R;

public class NewProjectSuggestionActivity extends AppCompatActivity {

    private Button buttonCadastrar, buttonBack;
    private Spinner spinner;
    private BottomSheet bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project_suggestion);

        init();

        enableClickButtons();
    }

    public void openDialog(){

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        alerta.setTitle(R.string.confirmacao);
        alerta.setMessage(R.string.dialogMenssegeSugestaoProjetos);
        alerta.setCancelable(false);
        alerta.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            // FIRE ZE MISSILES!

            Intent save = new Intent(NewProjectSuggestionActivity.this, BaseActivity.class);
            startActivity(save);

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

    private void init() {
        spinner = findViewById(R.id.spinner01);

        buttonCadastrar = findViewById(R.id.btnEnviar);

        buttonBack = findViewById(R.id.btnBack);

        bottomSheet = BottomSheet.getInstance(null, null);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.areaAplicacao, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void enableClickButtons() {

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        bottomSheet.closeBottomSheeet();
        finish();
    }
}

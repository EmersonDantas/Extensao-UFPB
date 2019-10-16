package br.com.extensaoufpb.extensaoufpb.activity.ui.project;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.base.BaseActivity;

public class EditProjectActivity extends AppCompatActivity {

    private Spinner spinnerStatusProjeto;
    private TextInputEditText txtCoordenador, initialProjectDate, finishProjectDate;
    private TextView txtNomeProjeto;
    private ImageView imgProjetoLogo;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private Button btnSave, btnReturnEditProject;
    private int year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);

        spinnerStatusProjeto = findViewById(R.id.statusProjetoSpinner);
        ArrayAdapter<CharSequence> adapterProjetoStatus = ArrayAdapter.createFromResource(this, R.array.status_project_array, android.R.layout.simple_spinner_item);
        adapterProjetoStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatusProjeto.setAdapter(adapterProjetoStatus);
        spinnerStatusProjeto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(parent.getItemAtPosition(position).equals("Selecione")){
                    //Nada a fazer
                }else{
                    String item = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(), "Selecão: " +item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        txtCoordenador = findViewById(R.id.txtNomeCoordenador);
        txtCoordenador.setText("Ayla Rebouças");

        initialProjectDate = findViewById(R.id.txtDataInicio);
        initialProjectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tratandoData(initialProjectDate);
            }
        });

        finishProjectDate = findViewById(R.id.txtDataFim);
        finishProjectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tratandoData(finishProjectDate);
            }
        });

        txtNomeProjeto = findViewById(R.id.projectName);
        txtNomeProjeto.setText("Apps4Society");

        imgProjetoLogo = findViewById(R.id.imgProjectLogo);
        imgProjetoLogo.setImageResource(R.drawable.projeto_logo);

        btnSave = findViewById(R.id.btnSalvarEditProjeto);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirConfirmacao();
            }
        });

        btnReturnEditProject = findViewById(R.id.btnReturnEditProject);
        btnReturnEditProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(EditProjectActivity.this, BaseActivity.class);
                startActivity(it);
                finish();
            }
        });

    }

    public void tratandoData(final EditText text){
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(EditProjectActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                text.setText(day+"/"+(month+1)+"/"+year);
            }
        },year, month, day);
        datePickerDialog.show();
    }

    public void exibirConfirmacao(){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(this);
        mensagem.setTitle("Confirmação");
        mensagem.setIcon(null);
        mensagem.setMessage("Alterando dados do projeto. Tem certeza disso?");
        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EditProjectActivity.this, "Projeto editado!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EditProjectActivity.this, BaseActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EditProjectActivity.this, "Alteração cancelada!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EditProjectActivity.this, BaseActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mensagem.show();
    }
}

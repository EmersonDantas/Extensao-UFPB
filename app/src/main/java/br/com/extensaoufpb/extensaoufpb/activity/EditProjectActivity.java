package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import br.com.extensaoufpb.extensaoufpb.R;

public class EditProjectActivity extends AppCompatActivity {

    private Spinner spinnerStatusProjeto, spinnerPeriodoInicio, spinnerPeriodoFim;
    private TextInputEditText txtCoordenador, initialProjectDate, finishProjectDate;
    private TextView txtNomeProjeto;
    private ImageView imgProjetoLogo;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
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
}

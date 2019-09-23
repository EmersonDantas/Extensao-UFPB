package br.com.extensaoufpb.extensaoufpb.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import br.com.extensaoufpb.extensaoufpb.Controller.FacadeQuestion;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.adapter.AdapterViewQuestions;
import br.com.extensaoufpb.extensaoufpb.models.bean.Question;

public class OpenSelectionProcessActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner buttonSpinnerProjections;
    private Spinner buttonSpinnerNewFields;
    private ArrayAdapter<String> adapterSpinner;
    private String[] listNewFieldSpinner = new String[]{""};
    private String[] listCRAMinimum = new String[]{""};
    private String[] listProjects = new String[]{""};
    private Button buttonNewFields, buttonAdd;
    private TextInputLayout inputLayoutCRA;
    private static TextView textNewField, textLimit;
    private static RecyclerView myRecyclerView;
    private static AdapterViewQuestions adapterViewQuestions;
    private RecyclerView.LayoutManager layoutManager;
    private static int lenghtListQuestions;
    private String newFieldActual;
    private FacadeQuestion facadeQuestion;
    private TextInputLayout inputOpenDate, inputCloseDate;
    private  Calendar myCalendar;

    //temporario
    private static List<Question> listaTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_open_selection_process);
        listaTemp = new ArrayList<>();

        findComponents();
        init();

    }

    private void findComponents(){

        buttonSpinnerProjections =findViewById(R.id.btnSpinnerProject);
        inputLayoutCRA = findViewById(R.id.inputCRA);
        buttonSpinnerNewFields =  findViewById(R.id.btnSpinnerNewFields);
        buttonNewFields = findViewById(R.id.btnInsertNewField);
        textNewField = findViewById(R.id.textNewfield);
        buttonAdd = findViewById(R.id.btnAdd);
        myRecyclerView = findViewById(R.id.recyclerViewQuestions);
        adapterViewQuestions = new AdapterViewQuestions(listaTemp);
        layoutManager = new LinearLayoutManager(this);
        lenghtListQuestions = listaTemp.size();
        textLimit = findViewById(R.id.textLimit);
        facadeQuestion = FacadeQuestion.getInstance();
        inputOpenDate = findViewById(R.id.inputOpeningDate);
        inputCloseDate = findViewById(R.id.inputCloseningDate);
        myCalendar = Calendar.getInstance();
    }

    private void init(){

        adapterSpinner(buttonSpinnerNewFields,R.array.listNewFields);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setAdapter(adapterViewQuestions);
        textLimit.setText(lenghtListQuestions+"/10");
        inputOpenDate.getEditText().setFocusable(false);
        inputCloseDate.getEditText().setFocusable(false);
        clickButtons();

    }

    private void clickButtons() {

        buttonSpinnerNewFields.setOnItemSelectedListener(this);

        buttonNewFields.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textNewField.setVisibility(View.VISIBLE);
                buttonAdd.setVisibility(View.VISIBLE);
                buttonSpinnerNewFields.setVisibility(View.VISIBLE);
                buttonNewFields.setVisibility(View.GONE);

            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                facadeQuestion.openFragment(newFieldActual, getSupportFragmentManager(),null);

            }
        });

        inputOpenDate.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeDate(inputOpenDate);

            }
        });

        inputCloseDate.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeDate(inputCloseDate);

            }
        });
    }


    private void adapterSpinner(Spinner spinnerSelect, int id){

        adapterSpinner = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,getStringSpinner(id));
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSelect.setAdapter(adapterSpinner);

    }

    private String[] getStringSpinner(int id){

        if(id == R.array.listNewFields){

            listNewFieldSpinner = getResources().getStringArray(id);
            return listNewFieldSpinner;

        }else if(id == R.array.listCRAMinimum){

            listCRAMinimum = getResources().getStringArray(id);
            return listCRAMinimum;

        }

        return new String[]{""};

    }

    //remover e usar padrão de projeto obsevable////////////////////////////////////////////////////

    public void updateLimitQuestionAdapter(){

        myRecyclerView.setAdapter(adapterViewQuestions);
        lenghtListQuestions = adapterViewQuestions.getItemCount();
        textLimit.setText(lenghtListQuestions+"/10");
    }

    public void addQuestion(Question question){

        listaTemp.add(question);
        myRecyclerView.setAdapter(adapterViewQuestions);
        updateLimitQuestionAdapter();

    }

    public void setQuestions(List<Question> questions){

        listaTemp = questions;
        myRecyclerView.setAdapter(adapterViewQuestions);
        updateLimitQuestionAdapter();

    }

    public List<Question> getList(){
        return listaTemp;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        newFieldActual = listNewFieldSpinner[pos];
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private void updateLabel(TextInputLayout textInputLayout, Calendar myCalendar) {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt", "BR"));
        textInputLayout.getEditText().setText(sdf.format(myCalendar.getTime()));
        textInputLayout.getEditText().setFocusable(true);
    }

    private void changeDate(final TextInputLayout textInputLayoutDate){


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(textInputLayoutDate, myCalendar);


            }
        };

        new DatePickerDialog(OpenSelectionProcessActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();


    }

}

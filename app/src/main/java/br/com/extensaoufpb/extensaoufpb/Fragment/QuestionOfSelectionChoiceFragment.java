package br.com.extensaoufpb.extensaoufpb.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.OpenSelectionProcessActivity;
import br.com.extensaoufpb.extensaoufpb.models.bean.Questions;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionOfSelectionChoiceFragment extends Fragment {

    private View view;
    private TextInputLayout inputNameField, inputQuestion01, inputQuestion02,inputQuestion03, inputQuestion04, inputQuestion05;
    private Button buttonAdd,buttonCancel;
    private Questions questions;
    private final String TYPE = "Seleção";

    public QuestionOfSelectionChoiceFragment() {
        // Required empty public constructor
        questions = new Questions();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_question_of_selection_choice, container, false);
        findComponents();
        clickButtons();
        return view;
    }

    private void findComponents(){

        inputNameField = view.findViewById(R.id.textInputNameFieldSelection);
        inputQuestion01 = view.findViewById(R.id.textInputQuestion01);
        inputQuestion02 = view.findViewById(R.id.textInputQuestion02);
        inputQuestion03 = view.findViewById(R.id.textInputQuestion03);
        inputQuestion04 = view.findViewById(R.id.textInputQuestion04);
        inputQuestion05 = view.findViewById(R.id.textInputQuestion05);
        buttonAdd = view.findViewById(R.id.btnAddFieldSelection);
        buttonCancel = view.findViewById(R.id.btnCancelFieldSelection);

    }
    private void clickButtons(){

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkValues()) {
                    questions.setQuestion(inputNameField.getEditText().getText().toString());
                    questions.setType(TYPE);
                    OpenSelectionProcessActivity openSelectionProcessActivity = new OpenSelectionProcessActivity();
                    openSelectionProcessActivity.addQuestion(questions);
                    assert getFragmentManager() != null;
                    getFragmentManager().popBackStack();
                }else{
                    Toast.makeText(getContext(),"preencha no minimo os 3 primeiros campos para adicionar ",Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                assert getFragmentManager() != null;
                getFragmentManager().popBackStack();

            }
        });

    }

    public boolean checkValues(){

        return (!inputNameField.getEditText().getText().toString().isEmpty() && !inputQuestion01.getEditText().getText().toString().isEmpty() && !inputQuestion02.getEditText().getText().toString().isEmpty() && !inputQuestion03.getEditText().getText().toString().isEmpty());
    }
}

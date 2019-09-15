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
public class QuestionOfTextFragment extends Fragment {

    private Button buttonAdd,buttonCancel;
    private View view;
    private TextInputLayout inputNameField, inputCharacterAmount;
    private Questions questions;
    private final String TYPE = "Texto";

    public QuestionOfTextFragment() {
        // Required empty public constructor
        questions = new Questions();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_question_of_text, container, false);
        findComponets();
        clickButtons();
        return view;
    }

    private void clickButtons(){

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { ;

                if(!inputNameField.getEditText().getText().toString().isEmpty() && !inputCharacterAmount.getEditText().getText().toString().isEmpty()) {
                    questions.setQuestion(inputNameField.getEditText().getText().toString());
                    questions.setType(TYPE);
                    OpenSelectionProcessActivity openSelectionProcessActivity = new OpenSelectionProcessActivity();
                    openSelectionProcessActivity.addQuestion(questions);
                    assert getFragmentManager() != null;
                    getFragmentManager().popBackStack();
                }else{
                    Toast.makeText(getContext(),"preencha os campos para adicionar ",Toast.LENGTH_LONG).show();
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

    private void findComponets(){

        buttonAdd = view.findViewById(R.id.btnAddField);
        buttonCancel = view.findViewById(R.id.btnCancelField);
        inputNameField = view.findViewById(R.id.textInputNameFieldText);
        inputCharacterAmount = view.findViewById(R.id.textInputCharacterAmount);

    }

}

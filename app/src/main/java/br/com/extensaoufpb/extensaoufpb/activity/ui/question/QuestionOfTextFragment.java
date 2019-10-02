package br.com.extensaoufpb.extensaoufpb.activity.ui.question;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.Controller.FacadeQuestion;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.process_selection.OpenSelectionProcessActivity;
import br.com.extensaoufpb.extensaoufpb.models.bean.Answer;
import br.com.extensaoufpb.extensaoufpb.models.bean.Question;
import br.com.extensaoufpb.extensaoufpb.models.bean.interfaces.MountAnswer;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionOfTextFragment extends Fragment implements MountAnswer {

    private Button buttonAdd,buttonCancel;
    private View view;
    private TextInputLayout inputNameField, inputCharacterAmount;
    private Question question;
    private final String TYPE = "Texto";
    private FacadeQuestion facadeQuestion;
    private boolean recovered;

    public QuestionOfTextFragment(Question question) {
        // Required empty public constructor
        facadeQuestion = FacadeQuestion.getInstance();
        if(question == null){
            this.question = new Question();
            recovered = false;
        }else{
            this.question = question;
            recovered = true;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_question_of_text, container, false);
        findComponets();
        clickButtons();
        mountAnswerQuestion(recovered);
        return view;
    }

    private void clickButtons(){

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { ;

                if(!inputNameField.getEditText().getText().toString().isEmpty() && !inputCharacterAmount.getEditText().getText().toString().isEmpty()) {

                    OpenSelectionProcessActivity openSelectionProcessActivity = new OpenSelectionProcessActivity();
                    List<Answer> list = new ArrayList<>();

                    String nameQuestion = inputNameField.getEditText().getText().toString();
                    String amount = inputCharacterAmount.getEditText().getText().toString();

                    question.setQuestion(nameQuestion);
                    question.setType(TYPE);

                    Answer answer = new Answer();
                    answer.setAnswerQuestion("");
                    answer.setAmountCharacter(amount);
                    list.add(answer);
                    question.setAnswer(list);

                    if(recovered){

                        final int index = openSelectionProcessActivity.getList().indexOf(question);
                        List<Question> newList = openSelectionProcessActivity.getList();
                        newList.get(index).setQuestion(nameQuestion);
                        openSelectionProcessActivity.setQuestions(newList);

                    }else{

                        openSelectionProcessActivity.addQuestion(question);

                    }

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

    @Override
    public void mountAnswerQuestion(boolean recovered) {

        if(recovered){
            inputNameField.getEditText().setText(this.question.getQuestion());
            inputCharacterAmount.getEditText().setText(this.question.getAnswer().get(0).getAmountCharacter());
        }

    }

}

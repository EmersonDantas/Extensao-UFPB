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

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.process_selection.OpenSelectionProcessActivity;
import br.com.extensaoufpb.extensaoufpb.models.bean.Answer;
import br.com.extensaoufpb.extensaoufpb.models.bean.Question;
import br.com.extensaoufpb.extensaoufpb.models.bean.interfaces.MountAnswer;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionOfNumberFragment extends Fragment implements MountAnswer {

    private Button buttonAdd,buttonCancel;
    private View view;
    private TextInputLayout inputNameField, inputLayout;
    private Question question;
    private final String TYPE = "numérico";
    private boolean recovered;

    public QuestionOfNumberFragment(Question question) {
        // Required empty public constructor

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
        // Inflate the layout for this fragmentreturn
        view =  inflater.inflate(R.layout.fragment_question_of_number, container, false);
        findComponets();
        clickButtons();
        mountAnswerQuestion(recovered);
        return view;
    }

    private void findComponets(){

        buttonAdd = view.findViewById(R.id.btnAddFieldNumber);
        buttonCancel = view.findViewById(R.id.btnCancelFieldNumber);
        inputNameField = view.findViewById(R.id.textInputNameFieldNumber);
        inputLayout = view.findViewById(R.id.textInput);

    }

    private void clickButtons(){

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { ;

                if(!inputNameField.getEditText().getText().toString().isEmpty() ) {//&& !inputLayout.getEditText().getText().toString().isEmpty()


                    OpenSelectionProcessActivity openSelectionProcessActivity = new OpenSelectionProcessActivity();
                    List<Answer> list = new ArrayList<>();

                    String nameQuestion = inputNameField.getEditText().getText().toString();
                    String number = inputLayout.getEditText().getText().toString();

                    question.setQuestion(nameQuestion);
                    question.setType(TYPE);

                    Answer answer = new Answer();
                    answer.setAnswerQuestion("");
                    answer.setNumber(number);
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

    @Override
    public void mountAnswerQuestion(boolean recovered) {

        if(recovered){

            inputNameField.getEditText().setText(this.question.getQuestion());
            inputLayout.getEditText().setText(this.question.getAnswer().get(0).getNumber());
        }

    }
}

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
public class QuestionOfMultipleChoiceFragment extends Fragment implements MountAnswer {

    private View view;
    private TextInputLayout inputNameField, inputQuestion01, inputQuestion02,inputQuestion03, inputQuestion04, inputQuestion05;
    private Button buttonAdd,buttonCancel;
    private Question question;
    private final String TYPE = "Múltipla Escolha";
    private boolean recovered;

    public QuestionOfMultipleChoiceFragment(Question question) {
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_question_of_multiple_choice, container, false);
        findComponents();
        clickButtons();
        mountAnswerQuestion(recovered);
        return view;
    }

    private void findComponents(){

        inputNameField = view.findViewById(R.id.textInputNameFieldMulti);
        inputQuestion01 = view.findViewById(R.id.textInputQuestion01);
        inputQuestion02 = view.findViewById(R.id.textInputQuestion02);
        inputQuestion03 = view.findViewById(R.id.textInputQuestion03);
        inputQuestion04 = view.findViewById(R.id.textInputQuestion04);
        inputQuestion05 = view.findViewById(R.id.textInputQuestion05);
        buttonAdd = view.findViewById(R.id.btnAddFieldMult);
        buttonCancel = view.findViewById(R.id.btnCancelFieldMult);

    }
    private void clickButtons(){

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkValues()) {

                    OpenSelectionProcessActivity openSelectionProcessActivity = new OpenSelectionProcessActivity();

                    String nameFiled = inputNameField.getEditText().getText().toString();
                    String question01 = inputQuestion01.getEditText().getText().toString();
                    String question02 = inputQuestion02.getEditText().getText().toString();
                    String question03 = inputQuestion03.getEditText().getText().toString();
                    String question04  = inputQuestion04.getEditText().getText().toString();
                    String question05 = inputQuestion05.getEditText().getText().toString();
                    String[] listQuestion = new String[]{question01,question02,question03,question04,question05};

                    question.setQuestion(nameFiled);
                    question.setType(TYPE);

                    List<Answer> answers = new ArrayList<>();

                    for(int i = 0; i < 5; i++){

                        Answer newAnswer = new Answer(listQuestion[i]);
                        answers.add(newAnswer);

                    }

                    question.setAnswer(answers);

                    if(recovered){

                        final int index = openSelectionProcessActivity.getList().indexOf(question);
                        List<Question> newList = openSelectionProcessActivity.getList();

                        newList.get(index).setQuestion(nameFiled);
                        openSelectionProcessActivity.setQuestions(newList);

                    }else{

                        openSelectionProcessActivity.addQuestion(question);

                    }

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

    @Override
    public void mountAnswerQuestion(boolean recovered) {

        if(recovered){

            inputNameField.getEditText().setText(question.getQuestion());
            inputQuestion01.getEditText().setText(question.getAnswer().get(0).getAnswerQuestion());
            inputQuestion02.getEditText().setText(question.getAnswer().get(1).getAnswerQuestion());
            inputQuestion03.getEditText().setText(question.getAnswer().get(2).getAnswerQuestion());
            inputQuestion04.getEditText().setText(question.getAnswer().get(3).getAnswerQuestion());
            inputQuestion05.getEditText().setText(question.getAnswer().get(4).getAnswerQuestion());

        }

    }
}

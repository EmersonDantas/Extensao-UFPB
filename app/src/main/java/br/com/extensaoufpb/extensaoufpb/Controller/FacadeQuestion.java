package br.com.extensaoufpb.extensaoufpb.Controller;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import br.com.extensaoufpb.extensaoufpb.Fragment.QuestionOfMultipleChoiceFragment;
import br.com.extensaoufpb.extensaoufpb.Fragment.QuestionOfNumberFragment;
import br.com.extensaoufpb.extensaoufpb.Fragment.QuestionOfSelectionChoiceFragment;
import br.com.extensaoufpb.extensaoufpb.Fragment.QuestionOfTextFragment;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Question;

public class FacadeQuestion {

    private final String SELECT = "selecione", TEXT = "texto", MULTIPLE_CHOICE = "múltipla escolha", SELECION = "seleção", NUMBER = "numérico";
    private Fragment fragment;
    private int position;
    public static FacadeQuestion instance = null;

    public static FacadeQuestion getInstance(){
        if(instance == null){

            instance = new FacadeQuestion();;

        }

        return instance;
    }

    private  FacadeQuestion(){

        position = 0;

    }

     public void setFragmentQuestionText(Question question){
          fragment = new QuestionOfTextFragment(question);
      }

     public void setFragmentQuestionMultple(Question questionMultple){
          fragment = new QuestionOfMultipleChoiceFragment(questionMultple);
      }

     public void setFragmentQuestionSelection(Question questionSelection){
          fragment = new QuestionOfSelectionChoiceFragment(questionSelection);
      }

     public void setFragmentQuestionNumber(Question questionNumber){
          fragment = new QuestionOfNumberFragment(questionNumber);
      }

      public void openFragment(String type, FragmentManager fragmentManager, Question question){

          if(type.equalsIgnoreCase(TEXT)){

             setFragmentQuestionText(question);

          }else if(type.equalsIgnoreCase(MULTIPLE_CHOICE)){

              setFragmentQuestionMultple(question);

          }else if(type.equalsIgnoreCase(SELECION)){

              setFragmentQuestionSelection(question);

          }else if(type.equalsIgnoreCase(NUMBER)){

              setFragmentQuestionNumber(question);

          }
          if(fragment != null && !type.equalsIgnoreCase(SELECT)) {
              final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
              fragmentTransaction.addToBackStack(null);
              fragmentTransaction.replace(R.id.constraintOpenSelection, fragment).commit();
          }
      }

}

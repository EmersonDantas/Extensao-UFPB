package br.com.extensaoufpb.extensaoufpb.Controller;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.question.QuestionOfMultipleChoiceFragment;
import br.com.extensaoufpb.extensaoufpb.activity.ui.question.QuestionOfNumberFragment;
import br.com.extensaoufpb.extensaoufpb.activity.ui.question.QuestionOfSelectionChoiceFragment;
import br.com.extensaoufpb.extensaoufpb.activity.ui.question.QuestionOfTextFragment;
import br.com.extensaoufpb.extensaoufpb.models.bean.Coordinator;
import br.com.extensaoufpb.extensaoufpb.models.bean.ExternalPublic;
import br.com.extensaoufpb.extensaoufpb.models.bean.Question;
import br.com.extensaoufpb.extensaoufpb.models.bean.User;

public class FacadeQuestion {

    private final String SELECT = "selecione", TEXT = "texto", MULTIPLE_CHOICE = "múltipla escolha", SELECION = "seleção", NUMBER = "numérico";
    private Fragment fragment;
    private int position;
    private static User user;
    private static final String emailCoordinator = "c1@gmail.com";
    private static final String emailExtern = "e1@gmail.com";
    public static FacadeQuestion instance = null;

    public static FacadeQuestion getInstance(){

        if(instance == null){

            instance = new FacadeQuestion();

        }

        return instance;
    }

    public void login(String login){

        if(user == null){

            if(login == null || !login.equals(emailCoordinator)){

                user = new ExternalPublic(R.drawable.ic_default,"emanoel","senha123",emailExtern);

            }else {

                user = new Coordinator(R.drawable.ic_default,"emanoel","senha123",emailCoordinator);

            }
        }

    }

    private  FacadeQuestion(){

        position = 0;

    }

    public void logout(){
        user = null;
    }


    public boolean checkUserCoordinator(){
        return emailCoordinator.equalsIgnoreCase(user.getEmail());
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

      public User getUser(){

        return user;

      }

}

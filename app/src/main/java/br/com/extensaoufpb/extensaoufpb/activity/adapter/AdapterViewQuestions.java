package br.com.extensaoufpb.extensaoufpb.activity.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.Controller.FacadeQuestion;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.OpenSelectionProcessActivity;
import br.com.extensaoufpb.extensaoufpb.models.bean.Question;

public class AdapterViewQuestions extends RecyclerView.Adapter<AdapterViewQuestions.MyViewHolder> {

    private Context myContext;
    private List<Question> questionList;
    private FacadeQuestion facadeQuestion;

    public AdapterViewQuestions(List<Question> list) {

        facadeQuestion = FacadeQuestion.getInstance();
        questionList = list;

    }

    @NonNull
    @Override
    public AdapterViewQuestions.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapterquestion, parent, false);
        myContext = view.getContext();
        return new AdapterViewQuestions.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewQuestions.MyViewHolder holder, int position) {

        Question question = questionList.get(position);
        holder.textQuestion.setText(question.getQuestion());
        holder.textType.setText(question.getType());
        clickButtons(holder);
    }

    private void clickButtons(final MyViewHolder myViewHolder){

        myViewHolder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Question question = questionList.get(getItem(myViewHolder.textQuestion.getText().toString()));
                FragmentManager manager = ((AppCompatActivity)myContext).getSupportFragmentManager();
                facadeQuestion.openFragment(myViewHolder.textType.getText().toString(),manager,question);

            }
        });

        myViewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(myContext);

                builder.setTitle("Confirmar");
//              definir mensagem
                builder.setMessage("Deseja deletar a pergunta - "+myViewHolder.textQuestion.getText());
//                configura cancelamento
                builder.setCancelable(false);

//                Configura icone
                builder.setIcon(android.R.drawable.ic_delete);

//                Configurar opções de butoes sim ou nao
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        questionList.remove(getItem(myViewHolder.textQuestion.getText().toString()));
                        OpenSelectionProcessActivity openSelectionProcessActivity = new OpenSelectionProcessActivity();
                        openSelectionProcessActivity.updateLimitQuestionAdapter();
                    }
                });

                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                                       nao faz nada
                    }
                });

//              Criar e exibir dialog
                builder.create();
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    private int getItem(String question){
        for(int i = 0; i < questionList.size(); i++){
            if(questionList.get(i).getQuestion().equals(question)){
                return i;
            }
        }
        return -1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textQuestion, textType;
        Button btnEdit, btnDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textQuestion = itemView.findViewById(R.id.textQuestion);
            textType = itemView.findViewById(R.id.textType);
            btnEdit = itemView.findViewById(R.id.btnEditQuestion);
            btnDelete = itemView.findViewById(R.id.btnDeleteQuestion);
        }
    }
}

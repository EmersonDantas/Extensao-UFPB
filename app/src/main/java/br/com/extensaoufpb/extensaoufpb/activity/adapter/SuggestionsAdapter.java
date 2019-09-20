package br.com.extensaoufpb.extensaoufpb.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ViewSuggestionFragment;
import br.com.extensaoufpb.extensaoufpb.models.bean.Suggestion;
import de.hdodenhof.circleimageview.CircleImageView;


public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.MyViewHolder> {

    private List<Suggestion> suggestionList;
    private Fragment actualFragment;
    private FragmentManager fragmentManager;


    public SuggestionsAdapter(List<Suggestion> lista, FragmentManager fragmentManager) {
        this.suggestionList = lista;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    //Criar a visualização
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_suggestions, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    //Exibir os itens
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Suggestion suggestion = suggestionList.get(i);
        myViewHolder.userPhoto.setImageResource(suggestion.getUserPhoto());
        myViewHolder.suggestionTitle.setText(suggestion.getSuggestionTitle());
        myViewHolder.suggestionDate.setText(suggestion.getDate());
        myViewHolder.userName.setText(suggestion.getUserName());
        myViewHolder.suggestionResume.setText(suggestion.getSuggestionResume());

        myViewHolder.btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repliceFragment(suggestion);
            }
        });


    }

    private void repliceFragment(Suggestion suggestion){

        actualFragment = new ViewSuggestionFragment(suggestion);
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.activitySuggestions, actualFragment).commit();
    }


    @Override
    //Quantidade de itens que serão exibidos
    public int getItemCount() {
        return suggestionList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView userPhoto;
        TextView suggestionTitle, suggestionDate, userName, suggestionResume;
        Button btnVisualizar;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userPhoto = itemView.findViewById(R.id.userPhoto);
            suggestionTitle = itemView.findViewById(R.id.suggestionTitle);
            suggestionDate = itemView.findViewById(R.id.suggestionDate);
            userName = itemView.findViewById(R.id.userName);
            suggestionResume = itemView.findViewById(R.id.suggestionResume);
            btnVisualizar = itemView.findViewById(R.id.btnVisualizar);
        }
    }
}

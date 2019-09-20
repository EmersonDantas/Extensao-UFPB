package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.adapter.SuggestionsAdapter;
import br.com.extensaoufpb.extensaoufpb.models.bean.Suggestion;

public class SuggestionsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Suggestion> suggestionList = new ArrayList<>();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        recyclerView = findViewById(R.id.recyclerView);

        fragmentManager = getSupportFragmentManager();

        //Listagem de candidatos
        this.addAllSuggestions();

        //Configurar adapter
        //Pegar os dados, montar a visualização e retornar para cada item do recycler view
        final SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(suggestionList, fragmentManager);

        //Configurar RecyclerView
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(suggestionsAdapter);

    }

    private void addAllSuggestions(){
        suggestionList.add(new Suggestion(R.drawable.perfil, "Oficinas de Programação", "18/09/2019",
                "Francivaldo Napoleão", "Seria legal ter oficinas de jogos para o público geral...",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                        " industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and " +
                        "scrambled it to make a type specimen book. It has survived not only five century. 300 caracteres."));

        suggestionList.add(new Suggestion(R.drawable.perfil, "Oficinas de Python", "18/09/2019",
                "Francivaldo Napoleão", "Python parece ser uma linguagem venenosa. Queria saber...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                " industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and " +
                "scrambled it to make a type specimen book. It has survived not only five century. 300 caracteres."));

        suggestionList.add(new Suggestion(R.drawable.perfil, "Oficinas de montagem", "18/09/2019",
                "Francivaldo Napoleão", "Como se monta um PC? Vocês bem que poderiam ensinar...",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                        " industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and " +
                        "scrambled it to make a type specimen book. It has survived not only five century. 300 caracteres."));
    }



}

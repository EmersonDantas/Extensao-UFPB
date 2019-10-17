package br.com.extensaoufpb.extensaoufpb.activity.ui.suggestions;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.Controller.BottomSheet;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Suggestion;

public class SuggestionsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Suggestion> suggestionList = new ArrayList<>();
    private FragmentManager fragmentManager;

    private Button btnBack;
    private BottomSheet bottomSheet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        init();

        enableClickButtons();

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

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        fragmentManager = getSupportFragmentManager();
        btnBack = findViewById(R.id.btnVoltarSugestoes);
        bottomSheet = BottomSheet.getInstance(null, null);
    }

    private void enableClickButtons() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheet.closeBottomSheeet();
                finish();
            }
        });
    }

    private void addAllSuggestions(){
        suggestionList.add(new Suggestion(R.drawable.ic_default, "Oficinas de Programação", "18/09/2019",
                "Francivaldo Napoleão", "Seria legal ter oficinas de jogos para o público geral...",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                        " industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and " +
                        "scrambled it to make a type specimen book. It has survived not only five century. 300 caracteres."));

        suggestionList.add(new Suggestion(R.drawable.ic_default, "Oficinas de Python", "18/09/2019",
                "Francivaldo Napoleão", "Python parece ser uma linguagem venenosa. Queria saber...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                " industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and " +
                "scrambled it to make a type specimen book. It has survived not only five century. 300 caracteres."));

        suggestionList.add(new Suggestion(R.drawable.ic_default, "Oficinas de montagem", "18/09/2019",
                "Francivaldo Napoleão", "Como se monta um PC? Vocês bem que poderiam ensinar...",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                        " industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and " +
                        "scrambled it to make a type specimen book. It has survived not only five century. 300 caracteres."));
    }


    @Override
    public void onBackPressed() {
        bottomSheet.closeBottomSheeet();
        finish();
    }
}

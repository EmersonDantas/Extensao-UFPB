package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.adapter.CandidatesAdapter;
import br.com.extensaoufpb.extensaoufpb.models.bean.Applicant;

public class CandidatesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Applicant> candidateProcessList = new ArrayList<>();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates);

        recyclerView = findViewById(R.id.recyclerView);
        fragmentManager = getSupportFragmentManager();

        //Listagem de candidatos
        this.addAllCandidates();

        //Configurar adapter
        //Pegar os dados, montar a visualização e retornar para cada item do recycler view
        CandidatesAdapter candidatesAdapter = new CandidatesAdapter(candidateProcessList, fragmentManager);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(candidatesAdapter);
    }

    private void addAllCandidates(){
        candidateProcessList.add(new Applicant(R.drawable.perfil, "Francivaldo", "Napoleão", "Sistemas de Informação",
                "8.27", "IA - Mobile - Redes", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                "industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and" +
                "scrambled it to make a type specimen book. It has survived not only five century. 300 caracteres."));

        candidateProcessList.add(new Applicant(R.drawable.perfil, "Francivaldo", "Napoleão", "Sistemas de Informação",
                "8.27", "IA - Redes", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                "industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and" +
                "scrambled it to make a type specimen book. It has survived not only five century. 300 caracteres."));

        candidateProcessList.add(new Applicant(R.drawable.perfil, "Francivaldo", "Napoleão", "Sistemas de Informação",
                "8.27", "Mobile - Python - Redes", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                "industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and" +
                "scrambled it to make a type specimen book. It has survived not only five century. 300 caracteres."));
    }
}

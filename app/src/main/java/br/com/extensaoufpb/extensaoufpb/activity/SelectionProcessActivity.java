package br.com.extensaoufpb.extensaoufpb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.adapter.ProcessSelectionAdapter;
import br.com.extensaoufpb.extensaoufpb.models.bean.ProcessSelection;

public class SelectionProcessActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ProcessSelection> processSelectionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_process);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de processos seletivos
        this.addAllProcessSelection();

        //Configurar adapter
        //Pegar os dados, montar a visualização e retornar para cada item do recycler view
        ProcessSelectionAdapter suggestionsAdapter = new ProcessSelectionAdapter(processSelectionList);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(suggestionsAdapter);
    }

    private void addAllProcessSelection(){

        processSelectionList.add(new ProcessSelection(R.drawable.projeto_logo, "Apps4Society", "Computação",
                "4 vagas, 1 com bolsas" ));

        processSelectionList.add(new ProcessSelection(R.drawable.projeto_logo, "Apps4Society", "Computação",
                "4 vagas, 1 com bolsas" ));

        processSelectionList.add(new ProcessSelection(R.drawable.projeto_logo, "Apps4Society", "Computação",
                "4 vagas, 1 com bolsas" ));
    }
}

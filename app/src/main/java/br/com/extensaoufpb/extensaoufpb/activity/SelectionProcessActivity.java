package br.com.extensaoufpb.extensaoufpb.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.Controller.BottomSheet;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.adapter.ProcessSelectionAdapter;
import br.com.extensaoufpb.extensaoufpb.models.bean.ProcessSelection;

public class SelectionProcessActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ProcessSelection> processSelectionList = new ArrayList<>();
    private Button btnBack;

    private BottomSheet bottomSheet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_process);

        init();

        enableClickButtons();

        //Listagem de processos seletivos
        this.addAllProcessSelection();

        //Configurar adapter
        //Pegar os dados, montar a visualização e retornar para cada item do recycler view
        ProcessSelectionAdapter suggestionsAdapter = new ProcessSelectionAdapter(processSelectionList,this);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(suggestionsAdapter);
    }

    private void init() {
        this.recyclerView = findViewById(R.id.recyclerView);
        this.bottomSheet = BottomSheet.getInstance(null, null);
        this.btnBack = findViewById(R.id.btnVoltarProcessosSeletivos);
    }

    private void enableClickButtons() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addAllProcessSelection(){

        processSelectionList.add(new ProcessSelection(R.drawable.projeto_logo, "Apps4Society", "Computação",
                "4 vagas, 1 com bolsas" ));

        processSelectionList.add(new ProcessSelection(R.drawable.projeto_logo, "Apps4Society", "Computação",
                "4 vagas, 1 com bolsas" ));

        processSelectionList.add(new ProcessSelection(R.drawable.projeto_logo, "Apps4Society", "Computação",
                "4 vagas, 1 com bolsas" ));
    }

    @Override
    public void onBackPressed() {
        bottomSheet.closeBottomSheeet();
        finish();
    }
}

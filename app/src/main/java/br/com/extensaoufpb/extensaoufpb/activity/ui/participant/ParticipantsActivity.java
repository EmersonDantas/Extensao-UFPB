package br.com.extensaoufpb.extensaoufpb.activity.ui.participant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Extensionist;

public class ParticipantsActivity extends AppCompatActivity {

    private List<Extensionist> participants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);
        createAllParticipantes();
        ParticipantsAdapter adapter = new ParticipantsAdapter(participants);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        RecyclerView rv = findViewById(R.id.rvParticipants);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }

    private void createAllParticipantes(){
        participants.add(new Extensionist(R.drawable.emerson,"Emerson Dantas", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        participants.add(new Extensionist(R.drawable.francivaldo,"Francivaldo Napoleão", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
        participants.add(new Extensionist(R.drawable.waldir,"Waldir Marques", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
    }
}

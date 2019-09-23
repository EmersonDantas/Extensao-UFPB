package br.com.extensaoufpb.extensaoufpb.activity.ui.participant;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Extensionist;

public class ParticipantsActivity extends AppCompatActivity {

    private List<Extensionist> participants = new ArrayList<>();
    private Button buttonBackParticipant;

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

        buttonBackParticipant = findViewById(R.id.btnParticipantsBack);
        buttonBackParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }

    private void createAllParticipantes(){
        participants.add(new Extensionist(R.drawable.emanoel,"Emerson Dantas", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        participants.add(new Extensionist(R.drawable.emanoel,"Francivaldo Napoleão", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
        participants.add(new Extensionist(R.drawable.emanoel,"Waldir Marques", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
    }
}

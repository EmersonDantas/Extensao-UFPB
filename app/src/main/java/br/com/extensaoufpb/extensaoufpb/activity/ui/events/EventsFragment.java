package br.com.extensaoufpb.extensaoufpb.activity.ui.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Event;

public class EventsFragment extends Fragment {
    private List<Event> events = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        createAllEvents();
        EventsAdapter adapter = new EventsAdapter(events);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        RecyclerView rv = view.findViewById(R.id.rvEvents);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        return view;
    }

    private void createAllEvents(){
        events.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        events.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        events.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        events.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
    }

}
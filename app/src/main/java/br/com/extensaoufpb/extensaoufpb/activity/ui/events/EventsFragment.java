package br.com.extensaoufpb.extensaoufpb.activity.ui.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.Controller.LoadingItem;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.project_feed.ProjectFeedFragment;
import br.com.extensaoufpb.extensaoufpb.models.bean.Event;

public class EventsFragment extends Fragment {

    private List<Event> events = new ArrayList<>();
    private List<Event> dateEvent;
    private EventsAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView rv;
    private int offSetEvent = 0;
    private final int SUM = 5;
    private int totalEvent;
    private LoadingItem<Event> loadingEvent;
    private ProjectFeedFragment projectFeedFragment =  new ProjectFeedFragment();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        findViewAll(view);

        init();

        onClickAll();

        return view;
    }

    private void findViewAll(View view){

        adapter  = new EventsAdapter(events);
        linearLayoutManager = new LinearLayoutManager(getContext());
        rv = view.findViewById(R.id.rvEvents);
        createAllEvents();
        loadingEvent = new LoadingItem<>(events,dateEvent);
    }

    private void init(){

        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

        adapter.addList(loadingEvent.loading(SUM));
    }

    private void onClickAll(){

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(getActivity(), "Last", Toast.LENGTH_LONG).show();
                    offSetEvent += SUM;
                    adapter.addList(loadingEvent.loading(offSetEvent));
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                projectFeedFragment.fab(dy);

            }

        });

    }

    private void createAllEvents(){
        dateEvent = new ArrayList<>();
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));
        dateEvent.add(new Event(R.drawable.peoples_xxxhdpi, "Palestra - Usando Objetos de Aprendizagem em sala de aula", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o", "13 de Setembro de 2019", "13h às 14h", "UFPB Campus IV - Mamanguape", "Auditório", "1h", true));

        totalEvent = dateEvent.size();
    }

}
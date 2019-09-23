package br.com.extensaoufpb.extensaoufpb.activity.ui.news;

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
import br.com.extensaoufpb.extensaoufpb.activity.ui.project_feed.ParticipantsPhotosAdapter;
import br.com.extensaoufpb.extensaoufpb.models.bean.News;

public class NewsFragment extends Fragment {
    private List<News> news = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        createAllNews();
        NewsAdapter adapter = new NewsAdapter(news);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        RecyclerView rv = view.findViewById(R.id.rvNews);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        return view;
    }

    public void createAllNews(){
        news.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        news.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        news.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        news.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
    }

}
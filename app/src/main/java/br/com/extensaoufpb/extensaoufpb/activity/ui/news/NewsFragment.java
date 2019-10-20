package br.com.extensaoufpb.extensaoufpb.activity.ui.news;

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
import br.com.extensaoufpb.extensaoufpb.models.bean.News;

public class NewsFragment extends Fragment {

    private List<News> news = new ArrayList<>();
    private List<News> dateNew;
    private NewsAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView rv;
    private int offSetNew = 0;
    private final int SUM = 5;
    private int totalNews;
    private LoadingItem<News> loadingNews;
    private ProjectFeedFragment projectFeedFragment =  new ProjectFeedFragment();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        findViewAll(view);

        init();

        onClickAll();

        return view;
    }

    private void findViewAll(View view){

        adapter = new NewsAdapter(news);
        linearLayoutManager = new LinearLayoutManager(getContext());
        rv = view.findViewById(R.id.rvNews);

        createAllNews();

        loadingNews  = new LoadingItem<>(news,dateNew);

    }

    private void init(){

        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

        adapter.addList(loadingNews.loading(SUM));

    }

    private void onClickAll(){

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {

                    Toast.makeText(getActivity(), "Last", Toast.LENGTH_LONG).show();
                    offSetNew += SUM;
                    adapter.addList(loadingNews.loading(offSetNew));
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                    projectFeedFragment.fab(dy);

            }
        });

    }

    public void createAllNews(){
        dateNew = new ArrayList<>();
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Nova versão do AppAlpha já disponível na PlayStore", "12 de Janeiro de 2019 às 09:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Novo aplicativo procura ajudar crianças com dislexia", "10 de Junho de 2019 às 16:29", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));
        dateNew.add(new News("Uso de Objetos de Aprendizagem em escolas de nível fundamental geraram resultados positivos", "28 de Agosto de 2019 às 13:25", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer"));

        totalNews = dateNew.size();
    }

}
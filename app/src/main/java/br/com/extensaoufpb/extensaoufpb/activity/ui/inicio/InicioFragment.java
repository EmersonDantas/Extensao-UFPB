package br.com.extensaoufpb.extensaoufpb.activity.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.AdapterFeedGeneral;
import br.com.extensaoufpb.extensaoufpb.models.bean.Project;

public class InicioFragment extends Fragment  {

    private View view;

    private InicioViewModel inicioViewModel;

    private RecyclerView recyclerView;

    private List<Project> projects = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        inicioViewModel = ViewModelProviders.of(this).get(InicioViewModel.class);
        view = inflater.inflate(R.layout.fragment_inicio, container, false);


        init();

        this.addAllProjects();

        // Configurar adapter
        AdapterFeedGeneral adapter = new AdapterFeedGeneral(getContext(), projects,getFragmentManager());

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);

        // Melhora a perfomance, pois ele terá um tamanho fixo
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);


        return view;
    }


    private void init() {
        this.recyclerView = view.findViewById(R.id.recyclerView);
    }

    private void addAllProjects() {

        projects.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        projects.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        projects.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        projects.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        projects.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        projects.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));


        projects.add(new Project(R.drawable.logo_labdados, "FLUEX - Cursos UFPB", "12 de Setembro de 2019",
                "O projeto de extensão proposto consiste em uma evolução do atual sistema do Cursos UFPB, de forma a atualizar e desenvolver novas interfaces de apresentação das informações, web e Android, e evoluir as tecnologias utilizadas no desenvolvimento do sistema.",
                R.drawable.ufpb_campus_iv));
    }



    public void onBackPressed() {
        init();
    }



}
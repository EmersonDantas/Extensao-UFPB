package br.com.extensaoufpb.extensaoufpb.activity.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.Controller.LoadingItem;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.AdapterFeedGeneral;
import br.com.extensaoufpb.extensaoufpb.models.bean.Project;

public class InicioFragment extends Fragment  {

    private View view;

    private InicioViewModel inicioViewModel;

    private RecyclerView recyclerView;

    private List<Project> projects = new ArrayList<>();
    private List<Project> dateProject;
    private AdapterFeedGeneral adapter;
    private LinearLayoutManager linearLayoutManager;
    private int offSetProject = 0;
    private final int SUM = 5;
    private LoadingItem<Project> loadingProject;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        inicioViewModel = ViewModelProviders.of(this).get(InicioViewModel.class);
        view = inflater.inflate(R.layout.fragment_inicio, container, false);

        findViewAll();

        init();

        onClickAll();

        return view;
    }

    private void findViewAll(){

        this.recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new AdapterFeedGeneral(getContext(), projects,getFragmentManager());
        linearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());

        this.addAllProjects();

        loadingProject  = new LoadingItem<>(projects,dateProject);
    }

    private void init() {

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

        adapter.addList(loadingProject.loading(SUM));

    }

    private void onClickAll(){

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {

                    Toast.makeText(getActivity(), "Last", Toast.LENGTH_LONG).show();
                    offSetProject += SUM;
                    adapter.addList(loadingProject.loading(offSetProject));
                }

            }
        });
    }
    private void addAllProjects() {

        dateProject = new ArrayList<>();

        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
        dateProject.add(new Project(R.drawable.logo_appps4, "Apps4Society", "15 de Junho de 2019",
                "Este projeto tem como objetivo principal estimular o desenvolvimento de aplicativos que possam impactar positivamente a sociedade. Alguns destes aplicativos podem ter fins educacionais, como apoiar na alfabetização de crianças, jovens e adultos.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_edu_emp, "Educação Empreendedora", "25 de Junho de 2019",
                "Educação Empreendedora é um projeto de extensão DCX/CCAE/UFPB que tem como objetivo aplicar conhecimento, processos, técnicas e ferramentas para alunos da rede de ensino médio sobre empreendedorismo.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_labdados, "PROBEX - Tecnologia Cidadã", "01 de Agosto de 2019",
                "Este projeto busca desenvolver tecnologias para que a sociedade possa fiscalizar os gastos dos órgãos públicos e municípios da Paraíba, indicando de forma mais clara gastos incomuns e relações suspeitas entre empresas em licitações.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_cursinho, "Cursinho Pré-ENEM", "05 de Agosto de 2019",
                "Considerando o impacto positivo do cursinho, este projeto será desenvolvido objetivando alcançar 400 adolescentes e aumentar suas chances de aprovação no ENEM, contribuindo para a redução das desigualdades sociais. Este projeto também apresenta uma relevância acadêmica para o Campus IV da UFPB.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_pensamento_comp, "Pensamento Computacional", "23 de Agosto de 2019",
                "Projeto de extensão criado na UFPB - Campus IV (Rio Tinto), com o propósito de estimular o pensamento computacional em meninas do ensino fundamental.",
                R.drawable.ufpb_campus_iv));


        dateProject.add(new Project(R.drawable.logo_it_girls, "ItGirls", "8 de Setembro de 2019",
                "Projeto, parceiro do Meninas Digitais - SBC, criado na UFPB - Campus IV (Rio Tinto) para unir e estimular garotas na área de Tecnologia da Informação.",
                R.drawable.ufpb_campus_iv));
    }



    public void onBackPressed() {
        init();
    }



}
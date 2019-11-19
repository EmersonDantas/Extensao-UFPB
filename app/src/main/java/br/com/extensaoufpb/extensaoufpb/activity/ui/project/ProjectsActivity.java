package br.com.extensaoufpb.extensaoufpb.activity.ui.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Project;

public class ProjectsActivity extends AppCompatActivity  implements View.OnClickListener{

    private RecyclerView myRecyclerViewProject;
    private Button btnBack;
    private List<Project> projectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        findView();
        setOnClick();
    }

    private void findView(){

        projectList.add(new Project(R.drawable.ic_default, "app 4 society", "22/10/19", "App feito pelo curso de Sistemas de Informação ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffsddddddddddddddddddddddddddddddddddddddddddddddddd", 0));
        projectList.add(new Project(R.drawable.ic_default, "app 4 society", "22/10/19", "App feito pelo curso de Sistemas de Informação", 0));
        projectList.add(new Project(R.drawable.ic_default, "app 4 society", "22/10/19", "App feito pelo curso de Sistemas de Informação ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffsddddddddddddddddddddddddddddddddddddddddddddddddd", 0));

        btnBack = findViewById(R.id.btnReturn);
        myRecyclerViewProject = findViewById(R.id.recyclerView_project);

        FeedProjectAdapter feedProjectAdapter = new FeedProjectAdapter(projectList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        myRecyclerViewProject.setLayoutManager(layoutManager);
        myRecyclerViewProject.setHasFixedSize(true);
        myRecyclerViewProject.setAdapter(feedProjectAdapter);

    }

    private void setOnClick(){

        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnReturn:
                finish();
                break;
        }
    }
}

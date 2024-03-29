package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.Controller.BottomSheet;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.project_feed.ProjectFeedFragment;
import br.com.extensaoufpb.extensaoufpb.models.bean.Project;


public class AdapterFeedGeneral extends RecyclerView.Adapter<AdapterFeedGeneral.MyViewHolder> implements View.OnClickListener {

    private List<Project> projects;
    private Context context;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment projectFeedFragment;

    public AdapterFeedGeneral(Context context, List<Project> allProjects, FragmentManager fragmentManager) {
        this.projects = allProjects;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.fragmentTransaction = fragmentManager.beginTransaction();
        this.projectFeedFragment = new ProjectFeedFragment();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Convertendo um XML em um View Object
        View projectPost = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_project_post, parent, false);


        return new MyViewHolder(projectPost);
    }

    // Exibição dos componentes
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Project project = projects.get(position);

        holder.logo.setImageResource(project.getLogo());
        holder.title.setText(project.getTitle());
        holder.date.setText(project.getDate());
        holder.description.setText(project.getDescription());
        holder.postImage.setImageResource(project.getPostImage());

        onAllClicks(holder);
    }

    public void addList(List<Project> projectList){

        projects = projectList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    private void onAllClicks(MyViewHolder myViewHolder) {

        myViewHolder.logo.setOnClickListener(this);

        myViewHolder.title.setOnClickListener(this);

        myViewHolder.postImage.setOnClickListener(this);

        myViewHolder.btn_more.setOnClickListener(this);

        myViewHolder.btn_more_text.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.logo:
            case R.id.title:

                BottomSheet.getInstance(view,null).closeBottomSheeet();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.nav_host_fragment, projectFeedFragment);
                fragmentTransaction.commit();

                break;
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView logo;
        TextView title, date, description;
        ImageView postImage;
        Button btn_more, btn_more_text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            logo = itemView.findViewById(R.id.logo);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            btn_more = itemView.findViewById(R.id.btn_more);
            btn_more_text = itemView.findViewById(R.id.btn_more_text);
            description = itemView.findViewById(R.id.description);
            postImage = itemView.findViewById(R.id.image_post);
        }

    }


}
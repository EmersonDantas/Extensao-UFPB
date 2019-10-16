package br.com.extensaoufpb.extensaoufpb.activity.ui.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.Controller.FacadeQuestion;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Project;
import de.hdodenhof.circleimageview.CircleImageView;

public class FeedProjectAdapter extends RecyclerView.Adapter<FeedProjectAdapter.MyViewHolder> implements View.OnClickListener{

    private List<Project> projectList;

    public FeedProjectAdapter(List<Project> projectList) {
        this.projectList = projectList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_feed_project, parent, false);

        return new FeedProjectAdapter.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Project myProject = projectList.get(position);

        holder.picture.setImageResource(myProject.getLogo());
        holder.nameProject.setText(myProject.getTitle());
        holder.dateProject.setText(myProject.getDate());
        holder.textDescription.setText(myProject.getDescription());
        holder.textProponentUnit.setText("falta adicionar a unidade proponente na classe project ");

        if(!FacadeQuestion.getInstance().checkUserCoordinator()){

            holder.buttonMenu.setVisibility(View.INVISIBLE);

        }

        holder.buttonMenu.setOnClickListener(this);
        holder.buttonMore.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameProject, dateProject, textDescription, textProponentUnit;
        Button buttonMenu, buttonMore;
        CircleImageView picture;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameProject = itemView.findViewById(R.id.nameProject);
            dateProject = itemView.findViewById(R.id.dateProject);
            textDescription = itemView.findViewById(R.id.textDescription);
            textProponentUnit = itemView.findViewById(R.id.textProponentUnit);
            buttonMenu = itemView.findViewById(R.id.menuProject);
            buttonMore = itemView.findViewById(R.id.buttonMore);
            picture = itemView.findViewById(R.id.projectPhoto);
        }
    }
}

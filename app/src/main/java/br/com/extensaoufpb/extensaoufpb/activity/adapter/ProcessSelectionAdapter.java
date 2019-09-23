package br.com.extensaoufpb.extensaoufpb.activity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.CandidatesActivity;
import br.com.extensaoufpb.extensaoufpb.activity.SelectionProcessActivity;
import br.com.extensaoufpb.extensaoufpb.models.bean.ProcessSelection;
import de.hdodenhof.circleimageview.CircleImageView;


public class ProcessSelectionAdapter extends RecyclerView.Adapter<ProcessSelectionAdapter.ProcessViewHolder> {

    private List<ProcessSelection> processSelectionList;
    private Activity activity;

    public ProcessSelectionAdapter(List<ProcessSelection> lista,Activity activity) {
        this.processSelectionList = lista;
        this.activity = activity;
    }

    @NonNull
    @Override
    //Criar a visualização
    public ProcessViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_process_selection, parent, false);

        return new ProcessViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ProcessViewHolder myViewHolder, int i) {
        ProcessSelection processSelection = processSelectionList.get(i);
        myViewHolder.projectLogo.setImageResource(processSelection.getProjectLogo());
        myViewHolder.projectName.setText(processSelection.getProjectName());
        myViewHolder.projectArea.setText(processSelection.getProjectArea());
        myViewHolder.opportunitys.setText(processSelection.getOpportunitys());

        myViewHolder.buttonSeeCandidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCandidates = new Intent(activity, CandidatesActivity.class);
                activity.startActivity(intentCandidates);
            }
        });
    }

    @Override
    //Quantidade de itens que serão exibidos
    public int getItemCount() {
        return processSelectionList.size();
    }

    public class ProcessViewHolder extends RecyclerView.ViewHolder{

        CircleImageView projectLogo;
        TextView projectName, projectArea, opportunitys;
        Button buttonSeeCandidate;

        public ProcessViewHolder(@NonNull View itemView) {
            super(itemView);

            projectLogo = itemView.findViewById(R.id.projectLogoProcess);
            projectName = itemView.findViewById(R.id.projectNameProcess);
            projectArea = itemView.findViewById(R.id.projectAreaProcess);
            opportunitys = itemView.findViewById(R.id.projectOportunitys);
            buttonSeeCandidate = itemView.findViewById(R.id.btnVisualizar);
        }
    }

}

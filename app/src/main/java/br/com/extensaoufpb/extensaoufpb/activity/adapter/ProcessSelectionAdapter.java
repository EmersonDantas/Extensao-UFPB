package br.com.extensaoufpb.extensaoufpb.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.ProcessSelection;
import de.hdodenhof.circleimageview.CircleImageView;


public class ProcessSelectionAdapter extends RecyclerView.Adapter<ProcessSelectionAdapter.ProcessViewHolder> {

    private List<ProcessSelection> processSelectionList;


    public ProcessSelectionAdapter(List<ProcessSelection> lista) {
        this.processSelectionList = lista;
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
    }

    @Override
    //Quantidade de itens que serão exibidos
    public int getItemCount() {
        return processSelectionList.size();
    }

    public class ProcessViewHolder extends RecyclerView.ViewHolder{

        CircleImageView projectLogo;
        TextView projectName, projectArea, opportunitys;


        public ProcessViewHolder(@NonNull View itemView) {
            super(itemView);

            projectLogo = itemView.findViewById(R.id.projectLogoProcess);
            projectName = itemView.findViewById(R.id.projectNameProcess);
            projectArea = itemView.findViewById(R.id.projectAreaProcess);
            opportunitys = itemView.findViewById(R.id.projectOportunitys);
        }
    }

}

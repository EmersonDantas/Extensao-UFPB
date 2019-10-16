package br.com.extensaoufpb.extensaoufpb.activity.ui.candidate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Applicant;
import de.hdodenhof.circleimageview.CircleImageView;

public class CandidatesAdapter extends RecyclerView.Adapter<CandidatesAdapter.MyViewHolder> {

    private List<Applicant> candidateProcessList;
    private Fragment actualFragment;
    private FragmentManager fragmentManager;

    public CandidatesAdapter(List<Applicant> lista, FragmentManager fragmentManager) {
        this.candidateProcessList = lista;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    //Criar a visualização
    public CandidatesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_candidate, parent, false);

        return new CandidatesAdapter.MyViewHolder(itemLista);
    }

    @Override
    //Exibir os itens
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Applicant candidateProcess = candidateProcessList.get(i);
        myViewHolder.userPhoto.setImageResource(candidateProcess.getUserPhoto());
        myViewHolder.firstName.setText(candidateProcess.getFirstName());
        myViewHolder.secondName.setText(candidateProcess.getSecondName());
        myViewHolder.userCourse.setText(candidateProcess.getUserCurse());
        myViewHolder.cra.setText(candidateProcess.getCra());

        myViewHolder.btnApplicantDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repliceFragment(candidateProcess);
            }
        });
    }

    private void repliceFragment(Applicant applicant){

        actualFragment = new ApplicantDetailsFragment(applicant);
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.candidatesActivity, actualFragment).commit();
    }

    @Override
    //Quantidade de itens que serão exibidos
    public int getItemCount() {
        return candidateProcessList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView userPhoto;
        TextView firstName, secondName, userCourse, cra;
        Button btnApplicantDetails;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userPhoto = itemView.findViewById(R.id.candidatePhoto);
            firstName = itemView.findViewById(R.id.txtCandidateFirstName);
            secondName = itemView.findViewById(R.id.txtCandidateSecondName);
            userCourse = itemView.findViewById(R.id.txtCandidateCourse);
            cra = itemView.findViewById(R.id.txtCandidateCra);
            btnApplicantDetails = itemView.findViewById(R.id.btnVisualizarCandidato);
        }
    }
}

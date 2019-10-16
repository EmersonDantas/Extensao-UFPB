package br.com.extensaoufpb.extensaoufpb.activity.ui.candidate;


import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Applicant;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ApplicantDetailsFragment extends Fragment {

    private CircleImageView applicantPhoto;
    private EditText txtFirstName, txtSecondName, txtCourse, txtCra, txtInterestArea;
    private TextView txtQualifications;
    private Button btnReturnApplicant, btnInWaiting, btnSelectApplicant;
    private Applicant applicant;



    public ApplicantDetailsFragment(Applicant applicant) {
        this.applicant = applicant;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_applicant_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        applicantPhoto = view.findViewById(R.id.applicantPhoto);
        applicantPhoto.setImageResource(applicant.getUserPhoto());

        txtFirstName = view.findViewById(R.id.txtFirstNameApplicant);
        txtFirstName.setText(applicant.getFirstName());

        txtSecondName = view.findViewById(R.id.txtSecondNameApplicant);
        txtSecondName.setText(applicant.getSecondName());

        txtCourse = view.findViewById(R.id.txtApplicanteCourse);
        txtCourse.setText(applicant.getUserCurse());

        txtCra = view.findViewById(R.id.txtCraApplicant);
        txtCra.setText(applicant.getCra());

        txtInterestArea = view.findViewById(R.id.txtInterestingAreaApplicant);
        txtInterestArea.setText(applicant.getInterestArea());

        txtQualifications = view.findViewById(R.id.txtQualificationsApplicant);
        txtQualifications.setText(applicant.getQualifications());
        txtQualifications.setMovementMethod(new ScrollingMovementMethod());

        btnReturnApplicant = view.findViewById(R.id.btnApplicantReturn);
        btnReturnApplicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        btnInWaiting = view.findViewById(R.id.btnInWaiting);
        btnInWaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder mensagem = new AlertDialog.Builder(v.getContext());
                mensagem.setTitle("Confirmação");
                mensagem.setIcon(null);
                mensagem.setMessage("Deseja colocar esse candidato em espera?");
                mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "Candidato em espera!", Toast.LENGTH_LONG).show();
                        getFragmentManager().popBackStack();
                    }
                });
                mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "Cancelado!", Toast.LENGTH_LONG).show();
                    }
                });
                mensagem.show();
            }
        });

        btnSelectApplicant = view.findViewById(R.id.btnApplicantSelected);
        btnSelectApplicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder mensagem = new AlertDialog.Builder(v.getContext());
                mensagem.setTitle("Confirmação");
                mensagem.setIcon(null);
                mensagem.setMessage("Deseja selecionar esse candidato?");
                mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "Candidato selecionado!", Toast.LENGTH_LONG).show();
                        getFragmentManager().popBackStack();
                    }
                });
                mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "Cancelado!", Toast.LENGTH_LONG).show();
                    }
                });
                mensagem.show();
            }
        });

    }

}

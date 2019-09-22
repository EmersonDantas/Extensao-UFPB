package br.com.extensaoufpb.extensaoufpb.activity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.LoginActivity;
import br.com.extensaoufpb.extensaoufpb.activity.PerfilActivity;
import br.com.extensaoufpb.extensaoufpb.models.bean.Suggestion;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewSuggestionFragment extends Fragment {

    private CircleImageView imgUserPhoto;
    private TextView userName, suggestionDate, suggestionTitle, suggestionText;
    private Suggestion suggestion;
    private Button btnReturn, btnSendAnswer;
    private EditText editAnswer;


    public ViewSuggestionFragment(Suggestion suggestion) {
        this.suggestion = suggestion;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_suggestion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imgUserPhoto = view.findViewById(R.id.userPhotoFeedback);
        imgUserPhoto.setImageResource(suggestion.getUserPhoto());

        userName = view.findViewById(R.id.txtUserNameFeedback);
        userName.setText(suggestion.getUserName());

        suggestionDate = view.findViewById(R.id.txtDateFeedback);
        suggestionDate.setText(suggestion.getDate());

        suggestionTitle = view.findViewById(R.id.txtSuggestionFeedback);
        suggestionTitle.setText(suggestion.getSuggestionTitle());

        suggestionText = view.findViewById(R.id.txtSuggestionText);
        suggestionText.setText(suggestion.getSuggestionText());
        suggestionText.setMovementMethod(new ScrollingMovementMethod());

        editAnswer = view.findViewById(R.id.editAnswerFeedback);

        btnReturn = view.findViewById(R.id.btnReturnFeedback);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        btnSendAnswer = view.findViewById(R.id.btnSendAnswer);
        btnSendAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                editAnswer.onEditorAction(EditorInfo.IME_ACTION_DONE);
                AlertDialog.Builder mensagem = new AlertDialog.Builder(v.getContext());
                mensagem.setTitle("Confirmação");
                mensagem.setIcon(null);
                mensagem.setMessage("Deseja enviar a resposta?");
                mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "Resposta enviada!", Toast.LENGTH_LONG).show();
                        getFragmentManager().popBackStack();
                    }
                });
                mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "Envio cancelado", Toast.LENGTH_LONG).show();
                    }
                });
                mensagem.show();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

}

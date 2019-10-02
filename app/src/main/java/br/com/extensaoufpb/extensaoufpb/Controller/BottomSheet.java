package br.com.extensaoufpb.extensaoufpb.Controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.suggestions.NewProjectSuggestionActivity;
import br.com.extensaoufpb.extensaoufpb.activity.ui.process_selection.OpenSelectionProcessActivity;
import br.com.extensaoufpb.extensaoufpb.activity.ui.process_selection.SelectionProcessActivity;
import br.com.extensaoufpb.extensaoufpb.activity.ui.project.SignProjectActivity;
import br.com.extensaoufpb.extensaoufpb.activity.ui.suggestions.SuggestionsActivity;

public class BottomSheet {

    private static BottomSheet instance = null;
    private static BottomSheetBehavior myBottomSheetBehavior;
    private static View myView = null;
    private static String emailCoordinator = "c1@gmail.com";

    private BottomSheet(){

    }

    public static BottomSheet getInstance(View view, String email) {

        if (instance == null) {
            instance = new BottomSheet();

            initiBottomSheet(view, email);
        }
        return instance;
    }

    public void openBottonSheet(){

        myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }

    public void closeBottomSheeet() {

        if (myBottomSheetBehavior.getState()  != BottomSheetBehavior.STATE_HIDDEN){

            myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        }

    }

    private static void initiBottomSheet(View view, String email) {

        int id = R.id.closebottom;

        if (email.equalsIgnoreCase(emailCoordinator)) {
            id = R.id.coordinatorbottom;
            view.findViewById(R.id.coordinator).setVisibility(View.VISIBLE);
            view.findViewById(R.id.external).setVisibility(View.GONE);

        }
        myView = view.findViewById(id);
        myBottomSheetBehavior = BottomSheetBehavior.from(myView);
        myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    public void changeStateBottom() {

        if(myBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        } else {
            myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    public void clickButtons(int id, Activity activity) {

        Intent intent = null;

        switch (id) {

            case R.id.btn_processo_seletivo_coord:

                intent = new Intent(activity, SelectionProcessActivity.class);

                break;

            case R.id.btn_sugestoes_novos_projetos_coord:

                intent = new Intent(activity, SuggestionsActivity.class);

                break;

            case R.id.btn_abrir_processo_coord:

                intent = new Intent(activity, OpenSelectionProcessActivity.class);

                break;

            case R.id.btn_cadastrar_projeto_coord:

                intent = new Intent(activity, SignProjectActivity.class);

                break;

            case R.id.btn_ver_projetos_coord:
                //

                break;

            case R.id.btn_ver_processos_ext:

               //class faltando

                break;

            case R.id.btn_enviar_sugestoes_ext:

                intent = new Intent(activity, NewProjectSuggestionActivity.class);

                break;

            case R.id.btn_ver_projetos_ext:
                break;


        }


        activity.startActivity(intent);

        closeBottomSheeet();

    }

}

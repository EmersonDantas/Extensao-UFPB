package br.com.extensaoufpb.extensaoufpb.Controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.NewProjectSuggestionActivity;
import br.com.extensaoufpb.extensaoufpb.activity.OpenSelectionProcessActivity;
import br.com.extensaoufpb.extensaoufpb.activity.SelectionProcessActivity;
import br.com.extensaoufpb.extensaoufpb.activity.SignProjectActivity;
import br.com.extensaoufpb.extensaoufpb.activity.SuggestionsActivity;

public class BottomSheet {

    private static BottomSheet instance = null;
    private static BottomSheetBehavior myBottomSheetBehavior;
    private static View myView = null;
    private static String emailCoordinator = "c1@gmail.com";

    private BottomSheet(){

    }

    public static BottomSheet getInstance(View view, String email) {

        Log.i("entrou", "bottom "+instance);
        if (instance == null) {
            Log.i("entrou", "bottom  if");
            instance = new BottomSheet();

            initiBottomSheet(view, email);
        }
        Log.i("entrou", "bottom saiu do if "+email);
        return instance;
    }

    public void openBottonSheet(){

        myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }

    public void closeBottomSheeet() {

        Log.i("entrou","if do fechar bottom "+(myBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN));
        if (myBottomSheetBehavior.getState()  != BottomSheetBehavior.STATE_HIDDEN){

            Log.i("entrou","fechando bottom");
            myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        }

    }

    private static void initiBottomSheet(View view, String email) {

        int id = R.id.closebottom;

        Log.i("entrou", "bottom init2");

        if (email.equalsIgnoreCase(emailCoordinator)) {
            Log.i("entrou", "bottominit method");
            id = R.id.coordinatorbottom;
            view.findViewById(R.id.coordinator).setVisibility(View.VISIBLE);
            view.findViewById(R.id.external).setVisibility(View.GONE);

        }
        Log.i("entrou", "bottom fora do if2");
        myView = view.findViewById(id);
        myBottomSheetBehavior = BottomSheetBehavior.from(myView);
        myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    public void changeStateBottom() {

        Log.i("entrou", "state "+myBottomSheetBehavior.getState());
        Log.i("entrou", "state2 "+BottomSheetBehavior.STATE_COLLAPSED);
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

        Log.i("entrou","xxxxxxxxxxxxxxxx" +intent);

        activity.startActivity(intent);

        closeBottomSheeet();

    }

}

package br.com.extensaoufpb.extensaoufpb.Controller;

import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import br.com.extensaoufpb.extensaoufpb.R;

public class BottomSheet {

    private static BottomSheet instance = null;
    private static BottomSheetBehavior myBottomSheetBehavior;
    private static View myView = null;
    private int id;

    private BottomSheet(){

    }

    public static BottomSheet getInstance(View view, String email){

        if(instance == null){

            instance = new BottomSheet();

            initiBottomSheet(view, email);
        }

        return instance;
    }

    public void openBottonSheet(){

        myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }

    public void closeBottomSheeet(){

        if(myBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){

            myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        }

    }

    private static void initiBottomSheet(View view, String email){

        int id = R.id.closebottom;

        if(email.equalsIgnoreCase("coordenador")){
            id = R.id.coordinatorbottom;
            view.findViewById(R.id.coordinator).setVisibility(View.VISIBLE);
            view.findViewById(R.id.external).setVisibility(View.GONE);

        }

        myView = view.findViewById(id);
        myBottomSheetBehavior = BottomSheetBehavior.from(myView);
        myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    public void changeStateBottom(){

        if(myBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
            myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }else{
            myBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }
}

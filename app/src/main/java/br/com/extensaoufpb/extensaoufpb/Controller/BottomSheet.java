package br.com.extensaoufpb.extensaoufpb.Controller;

import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import br.com.extensaoufpb.extensaoufpb.R;

public class BottomSheet {

    private static BottomSheet instance = null;
    private static BottomSheetBehavior myBottomSheetBehavior;
    private static View myView = null;

    private BottomSheet(){

    }

    public static BottomSheet getInstance(View view){

        if(instance == null){

            instance = new BottomSheet();

            initiBottomSheet(view);
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

    private static void initiBottomSheet(View view){

        myView = view.findViewById(R.id.closebottom);
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

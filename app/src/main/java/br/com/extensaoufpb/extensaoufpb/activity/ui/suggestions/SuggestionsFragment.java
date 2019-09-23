package br.com.extensaoufpb.extensaoufpb.activity.ui.suggestions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import br.com.extensaoufpb.extensaoufpb.R;

public class SuggestionsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suggestions, container, false);
        return view;
    }

}
package br.com.extensaoufpb.extensaoufpb.activity.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import br.com.extensaoufpb.extensaoufpb.R;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel = ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
//        final TextView textView = root.findViewById(R.id.text_perfil);
//        perfilViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                Log.i("log","textView = "+textView.getText()+" s  = "+s);
//                textView.setText(s);
//            }
//        });
        return root;
    }
}
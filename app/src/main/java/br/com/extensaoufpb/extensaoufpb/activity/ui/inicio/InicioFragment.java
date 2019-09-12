package br.com.extensaoufpb.extensaoufpb.activity.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import br.com.extensaoufpb.extensaoufpb.R;

public class InicioFragment extends Fragment {

    private InicioViewModel inicioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inicioViewModel =
                ViewModelProviders.of(this).get(InicioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inicio, container, false);
//        final TextView textView = root.findViewById(R.id.text_inicio);
//        inicioViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                Log.i("log","textView = "+textView.getText()+" s  = "+s);
//                textView.setText(s);
//            }
//        });
        return root;
    }
}
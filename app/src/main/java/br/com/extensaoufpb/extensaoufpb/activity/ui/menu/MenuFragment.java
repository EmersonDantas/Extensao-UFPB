package br.com.extensaoufpb.extensaoufpb.activity.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import br.com.extensaoufpb.extensaoufpb.R;

public class MenuFragment extends Fragment {

    private MenuViewModel menuViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        menuViewModel = ViewModelProviders.of(this).get(MenuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
//        final TextView textView = root.findViewById(R.id.text_menu);
//        menuViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//
//                Log.i("log","textView = "+textView.getText()+" s  = "+s);
//                textView.setText(s);
//            }
//        });
        return root;
    }
}
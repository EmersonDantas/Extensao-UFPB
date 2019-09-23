package br.com.extensaoufpb.extensaoufpb.activity.ui.project_feed;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Extensionist;

public class ProjectFeedFragment extends Fragment implements View.OnClickListener {
    private Button btnOpenBottomSheet;
    private TabMenuAdapter menuAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayoutTabMenu;
    private ConstraintLayout layoutBottonSheetRoot;
    private List<Extensionist> participants = new ArrayList<>();
    private String TAG = "ProjectFeedFragment";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_project_feed, container, false);
        btnOpenBottomSheet = root.findViewById(R.id.btnHideShow);
        btnOpenBottomSheet.setOnClickListener(this);
        layoutBottonSheetRoot = root.findViewById(R.id.bottomSheetRootLayout);
        menuAdapter = new TabMenuAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fillTabMenu(root);

        createAllParticipantes();
        ParticipantsPhotosAdapter adapter = new ParticipantsPhotosAdapter(participants);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView rv = root.findViewById(R.id.rvParticipatsPhotos);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        return root;
    }

    public void fillTabMenu(View view){
        viewPager = view.findViewById(R.id.vpTabMenu);
        viewPager.setAdapter(menuAdapter);
        tabLayoutTabMenu = view.findViewById(R.id.tlTabMenu);
        tabLayoutTabMenu.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutTabMenu));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i(TAG,"ScrollState");
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG,"Scrolled");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i(TAG,"Page Changed");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.btnHideShow):
                if(layoutBottonSheetRoot.getVisibility() == layoutBottonSheetRoot.VISIBLE){
                    layoutBottonSheetRoot.setVisibility(layoutBottonSheetRoot.GONE);
                    btnOpenBottomSheet.setCompoundDrawablesWithIntrinsicBounds(null, null, getContext().getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_black_24dp),null);
                }else{
                    layoutBottonSheetRoot.setVisibility(layoutBottonSheetRoot.VISIBLE);
                    btnOpenBottomSheet.setCompoundDrawablesWithIntrinsicBounds(null, null, getContext().getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_black_24dp),null);
                }
                break;
        }
    }

    private void createAllParticipantes(){
        participants.add(new Extensionist(R.drawable.emerson,"Emerson Dantas", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        participants.add(new Extensionist(R.drawable.francivaldo,"Francivaldo Napoleão", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
        participants.add(new Extensionist(R.drawable.waldir,"Waldir Marques", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
        participants.add(new Extensionist(R.drawable.emanoel,"Emanoel Medeiros", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
        participants.add(new Extensionist(R.drawable.emerson,"Emanoel Medeiros", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
        participants.add(new Extensionist(R.drawable.francivaldo,"Francivaldo Napoleão", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
        participants.add(new Extensionist(R.drawable.waldir,"Waldir Marques", null, null, "Bacharelado em Sistemas de Informação", "Voluntário"));
    }
}
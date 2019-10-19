package br.com.extensaoufpb.extensaoufpb.activity.ui.project_feed;

import android.content.Intent;
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

import br.com.extensaoufpb.extensaoufpb.Controller.BottomSheet;
import br.com.extensaoufpb.extensaoufpb.Controller.LoadingItem;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.participant.ParticipantsActivity;
import br.com.extensaoufpb.extensaoufpb.models.bean.Extensionist;

public class ProjectFeedFragment extends Fragment implements View.OnClickListener {

    private Button btnOpenBottomSheet, buttonSeeAll, buttonBack;
    private TabMenuAdapter menuAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayoutTabMenu;
    private ConstraintLayout layoutBottonSheetRoot;
    private List<Extensionist> participants = new ArrayList<>();
    private String TAG = "ProjectFeedFragment";
    private int offSetParticipant = 0;
    private final int SUM = 5;
    private ParticipantsPhotosAdapter adapter;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private LoadingItem<Extensionist> loadingExtensionist;

    List<Extensionist> teste;
    private int totalExtensionist;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_project_feed, container, false);

        findViewAll(root);

        init();

        return root;
    }

    private void init(){

        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        rv.hasFixedSize();


        viewPager.setAdapter(menuAdapter);

        tabLayoutTabMenu.setupWithViewPager(viewPager);

        adapter.addList(loadingExtensionist.loadingParticipant(SUM));

        onClickAll();

    }

    private void findViewAll(View view){

        teste();

        btnOpenBottomSheet = view.findViewById(R.id.btnHideShow);
        layoutBottonSheetRoot = view.findViewById(R.id.bottomSheetRootLayout);
        menuAdapter = new TabMenuAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        adapter = new ParticipantsPhotosAdapter(participants);

        loadingExtensionist  = new LoadingItem<>(participants,teste);

        lm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        rv = view.findViewById(R.id.rvParticipatsPhotos);

        buttonBack = view.findViewById(R.id.btnProjectFeedBack);
        buttonSeeAll = view.findViewById(R.id.btnSeeAll);
        viewPager = view.findViewById(R.id.vpTabMenu);
        tabLayoutTabMenu = view.findViewById(R.id.tlTabMenu);
    }

    private void onClickAll(){

        buttonSeeAll.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        btnOpenBottomSheet.setOnClickListener(this);

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

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dx > 0){

                    final int visibleItemCount = lm.getChildCount();
                    final int pastItemCount = lm.findFirstCompletelyVisibleItemPosition();
                    final int comparator =(visibleItemCount + pastItemCount);

                    if(comparator <= totalExtensionist){
                        offSetParticipant += SUM;
//                        loadingParticipant(offSetParticipant);
                        adapter.addList(loadingExtensionist.loadingParticipant(offSetParticipant));
                    }

                }
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
            case R.id.btnSeeAll:

                BottomSheet.getInstance(v,null).closeBottomSheeet();
                Intent intent = new Intent(getActivity(), ParticipantsActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.btnProjectFeedBack:
                getFragmentManager().popBackStack();
                break;
        }
    }

    private void teste(){
        teste = new ArrayList<>();;
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));
        teste.add(new Extensionist(R.drawable.ic_default,"Fist Last Name", null, null, "Bacharelado em Sistemas de Informação", "Bolsista"));

        totalExtensionist = teste.size();
    }
}
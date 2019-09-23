package br.com.extensaoufpb.extensaoufpb.activity.ui.project_feed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import br.com.extensaoufpb.extensaoufpb.activity.ui.events.EventsFragment;
import br.com.extensaoufpb.extensaoufpb.activity.ui.news.NewsFragment;
import br.com.extensaoufpb.extensaoufpb.activity.ui.suggestions.SuggestionsFragment;


public class TabMenuAdapter extends FragmentPagerAdapter {

    private Integer size = 3;
    private Fragment currentFragemnt;

    public TabMenuAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                currentFragemnt = new NewsFragment();
                break;
            case 1:
                currentFragemnt = new EventsFragment();
                break;
            default:
                currentFragemnt = new SuggestionsFragment();
                break;
        }

        return currentFragemnt;
    }

    @Override
    public int getCount() {
        return this.size;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Notícias";
            case 1:
                return "Eventos";
            default:
                return "Sugestões";
        }
    }

    public Fragment getCurrentFragment(){
        return currentFragemnt;
    }
}

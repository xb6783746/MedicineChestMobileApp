package vsu.ru.medicamentmobileapp.MainScreen.Adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import vsu.ru.medicamentmobileapp.ItemsView.Views.ItemsView;
import vsu.ru.medicamentmobileapp.ItemsView.Views.MedicamentsView;
import vsu.ru.medicamentmobileapp.ItemsView.Views.PrescriptionsView;

/**
 * Created by Влад on 20.05.2017.
 */

public class ItemsScreenAdapter extends FragmentPagerAdapter {

    public static class FragmentWithTitle{

        public FragmentWithTitle(Fragment fragment, String title) {
            this.fragment = fragment;
            this.title = title;
        }

        Fragment fragment;
        String title;
    }
    public ItemsScreenAdapter(FragmentManager fm, List<FragmentWithTitle> screens) {
        super(fm);

        this.screens = screens;
    }


    private List<FragmentWithTitle> screens;

    @Override
    public Fragment getItem(int position) {
        return screens.get(position).fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return screens.get(position).title;
    }

    @Override
    public int getCount() {
        return screens.size();
    }
}

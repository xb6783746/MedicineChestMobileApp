package vsu.ru.medicamentmobileapp;

import android.app.Fragment;

import vsu.ru.medicamentmobileapp.ItemsView.Views.ItemsViewComponents;

/**
 * Created by Влад on 27.05.2017.
 */

public class BaseFragment extends Fragment{


    public ItemsViewComponents getComponent(){

        MainActivity mainActivity = (MainActivity)getActivity();

        return mainActivity.getItemsViewComponents();
    }
}

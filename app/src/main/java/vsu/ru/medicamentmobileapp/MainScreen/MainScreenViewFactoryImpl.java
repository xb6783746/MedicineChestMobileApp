package vsu.ru.medicamentmobileapp.MainScreen;

import android.app.Fragment;

import vsu.ru.medicamentmobileapp.ItemsView.Views.ItemsView;
import vsu.ru.medicamentmobileapp.ItemsView.Views.MedicamentsView;
import vsu.ru.medicamentmobileapp.ItemsView.Views.PrescriptionsView;
import vsu.ru.medicamentmobileapp.MainScreen.Interfaces.MainScreenViewFactory;

/**
 * Created by Влад on 20.05.2017.
 */

public class MainScreenViewFactoryImpl implements MainScreenViewFactory{
    @Override
    public Fragment getMedicamentsScreen() {
        return MedicamentsView.newInstance();
    }

    @Override
    public Fragment getItemsScreen() {
        return ItemsView.newInstance();
    }

    @Override
    public Fragment getPrescriptionsScreen() {
        return PrescriptionsView.newInstance();
    }
}

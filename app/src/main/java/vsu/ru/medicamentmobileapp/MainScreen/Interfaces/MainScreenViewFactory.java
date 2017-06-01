package vsu.ru.medicamentmobileapp.MainScreen.Interfaces;

import android.app.Fragment;

/**
 * Created by Влад on 19.05.2017.
 */

public interface MainScreenViewFactory {

    Fragment getMedicamentsScreen();
    Fragment getItemsScreen();
    Fragment getPrescriptionsScreen();
}

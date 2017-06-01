package vsu.ru.medicamentmobileapp.MainScreen;

import javax.inject.Singleton;

import vsu.ru.medicamentmobileapp.ItemsView.Views.ItemsView;
import vsu.ru.medicamentmobileapp.ItemsView.Views.MedicamentsView;
import vsu.ru.medicamentmobileapp.ItemsView.Views.PrescriptionsView;
import vsu.ru.medicamentmobileapp.Modules.MainViewModule;
import vsu.ru.medicamentmobileapp.Modules.PresentersModule;
import vsu.ru.medicamentmobileapp.Modules.RoutersModule;
import vsu.ru.medicamentmobileapp.Modules.Utils;
import vsu.ru.medicamentmobileapp.Modules.ViewsModule;

/**
 * Created by Влад on 27.05.2017.
 */

@dagger.Component(modules = {MainViewModule.class})
public interface MainViewComponents {

    void inject(MainFragment view);
}

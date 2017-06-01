package vsu.ru.medicamentmobileapp.ItemsView.Views;

import javax.inject.Singleton;

import vsu.ru.medicamentmobileapp.ItemsView.Views.ItemsView;
import vsu.ru.medicamentmobileapp.ItemsView.Views.MedicamentsView;
import vsu.ru.medicamentmobileapp.ItemsView.Views.PrescriptionsView;
import vsu.ru.medicamentmobileapp.MainScreen.MainFragment;
import vsu.ru.medicamentmobileapp.Modules.PresentersModule;
import vsu.ru.medicamentmobileapp.Modules.RoutersModule;
import vsu.ru.medicamentmobileapp.Modules.Utils;
import vsu.ru.medicamentmobileapp.Modules.ViewsModule;

/**
 * Created by Влад on 27.05.2017.
 */

@dagger.Component(modules = {PresentersModule.class, Utils.class, RoutersModule.class, ViewsModule.class})
@Singleton
public interface ItemsViewComponents {

    void inject(ItemsView view);
    void inject(MedicamentsView view);
    void inject(PrescriptionsView view);
}

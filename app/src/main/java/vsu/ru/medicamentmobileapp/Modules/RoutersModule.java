package vsu.ru.medicamentmobileapp.Modules;

import dagger.Module;
import dagger.Provides;
import vsu.ru.medicamentmobileapp.ItemsView.Routers.BaseItemsRouter;
import vsu.ru.medicamentmobileapp.ItemsView.Routers.ItemsRouter;
import vsu.ru.medicamentmobileapp.ItemsView.Routers.MedicamentsRouter;
import vsu.ru.medicamentmobileapp.ItemsView.Routers.PrescriptionRouter;
import vsu.ru.medicamentmobileapp.ItemsView.ViewFactory.ItemsViewFactory;
import vsu.ru.medicamentmobileapp.ScreenManager;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

/**
 * Created by Влад on 27.05.2017.
 */

@Module
public class RoutersModule {

    @Provides
    BaseItemsRouter<MedicamentItem> provideItemsRouter(ScreenManager screenManager,
                                                       ItemsViewFactory<MedicamentItem> factory){
        return new ItemsRouter(screenManager, factory);
    }

    @Provides
    BaseItemsRouter<MedicamentDTO> provideMedicamentsRouter(ScreenManager screenManager,
                                                            ItemsViewFactory<MedicamentDTO> factory){
        return new MedicamentsRouter(screenManager, factory);
    }

    @Provides
    BaseItemsRouter<PrescriptionDTO> providePrescriptionsRouter(ScreenManager screenManager,
                                                              ItemsViewFactory<PrescriptionDTO> factory){
        return new PrescriptionRouter(screenManager, factory);
    }
}

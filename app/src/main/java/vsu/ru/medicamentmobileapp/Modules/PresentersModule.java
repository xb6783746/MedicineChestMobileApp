package vsu.ru.medicamentmobileapp.Modules;

import dagger.Module;
import dagger.Provides;
import vsu.ru.medicamentmobileapp.ItemsView.Presenters.BaseItemsPresenter;
import vsu.ru.medicamentmobileapp.ItemsView.Presenters.ItemsPresenter;
import vsu.ru.medicamentmobileapp.ItemsView.Presenters.MedicamentPresenter;
import vsu.ru.medicamentmobileapp.ItemsView.Presenters.PrescriptionPresenter;
import vsu.ru.medicamentmobileapp.ItemsView.Routers.BaseItemsRouter;
import vsu.ru.medicamentmobileapp.Model.Providers.DataProvider;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

/**
 * Created by Влад on 27.05.2017.
 */

@Module
public class PresentersModule {

    @Provides
    BaseItemsPresenter<MedicamentItem> provideItemsPresenter(DataProvider dataProvider,
                                                             BaseItemsRouter<MedicamentItem> router){

        return new ItemsPresenter(dataProvider, router);
    }

    @Provides
    BaseItemsPresenter<MedicamentDTO> provideMedicamentsPresenter(DataProvider dataProvider,
                                                                  BaseItemsRouter<MedicamentDTO> router){

        return new MedicamentPresenter(dataProvider, router);
    }

    @Provides
    BaseItemsPresenter<PrescriptionDTO> providePrescriptionsPresenter(DataProvider dataProvider,
                                                                    BaseItemsRouter<PrescriptionDTO> router){

        return new PrescriptionPresenter(dataProvider, router);
    }
}

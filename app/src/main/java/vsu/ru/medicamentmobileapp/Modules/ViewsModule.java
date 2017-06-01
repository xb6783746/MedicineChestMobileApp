package vsu.ru.medicamentmobileapp.Modules;

import dagger.Module;
import dagger.Provides;
import vsu.ru.medicamentmobileapp.ItemsView.ViewFactory.ItemDetailsViewFactory;
import vsu.ru.medicamentmobileapp.ItemsView.ViewFactory.ItemsViewFactory;
import vsu.ru.medicamentmobileapp.ItemsView.ViewFactory.MedicamentDetailsViewFactory;
import vsu.ru.medicamentmobileapp.ItemsView.ViewFactory.PrescriptionDetailsViewFactory;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

/**
 * Created by Влад on 27.05.2017.
 */

@Module
public class ViewsModule {


    @Provides
    ItemsViewFactory<MedicamentItem> provideItemsDetailsViewFactory(){

        return new ItemDetailsViewFactory();
    }

    @Provides
    ItemsViewFactory<MedicamentDTO> provideMedicamentDetailsViewFactory(){

        return new MedicamentDetailsViewFactory();
    }

    @Provides
    ItemsViewFactory<PrescriptionDTO> providePrescriptionDetailsViewFactory(){

        return new PrescriptionDetailsViewFactory();
    }
}

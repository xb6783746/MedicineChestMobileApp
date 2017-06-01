package vsu.ru.medicamentmobileapp.ItemsView.Routers;

import vsu.ru.medicamentmobileapp.ItemsView.ViewFactory.ItemsViewFactory;
import vsu.ru.medicamentmobileapp.ScreenManager;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;

/**
 * Created by Влад on 27.05.2017.
 */

public class MedicamentsRouter extends BaseItemsRouter<MedicamentDTO> {

    public MedicamentsRouter(ScreenManager screenManager, ItemsViewFactory<MedicamentDTO> factory) {
        super(screenManager, factory);
    }
}

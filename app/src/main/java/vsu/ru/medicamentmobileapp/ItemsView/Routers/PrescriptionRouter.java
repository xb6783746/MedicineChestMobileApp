package vsu.ru.medicamentmobileapp.ItemsView.Routers;

import vsu.ru.medicamentmobileapp.ItemsView.ViewFactory.ItemsViewFactory;
import vsu.ru.medicamentmobileapp.ScreenManager;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

/**
 * Created by Влад on 27.05.2017.
 */

public class PrescriptionRouter extends BaseItemsRouter<PrescriptionDTO> {

    public PrescriptionRouter(ScreenManager screenManager, ItemsViewFactory<PrescriptionDTO> factory) {
        super(screenManager, factory);
    }
}

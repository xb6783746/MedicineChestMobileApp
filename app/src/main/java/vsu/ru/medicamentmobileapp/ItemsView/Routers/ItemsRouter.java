package vsu.ru.medicamentmobileapp.ItemsView.Routers;

import vsu.ru.medicamentmobileapp.ItemsView.ViewFactory.ItemsViewFactory;
import vsu.ru.medicamentmobileapp.ScreenManager;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;

/**
 * Created by Влад on 27.05.2017.
 */

public class ItemsRouter extends BaseItemsRouter<MedicamentItem> {

    public ItemsRouter(ScreenManager screenManager, ItemsViewFactory<MedicamentItem> factory) {
        super(screenManager, factory);
    }
}

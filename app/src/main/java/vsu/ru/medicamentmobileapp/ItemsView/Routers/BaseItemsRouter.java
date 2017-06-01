package vsu.ru.medicamentmobileapp.ItemsView.Routers;

import android.app.Fragment;

import vsu.ru.medicamentmobileapp.ItemsView.ViewFactory.ItemsViewFactory;
import vsu.ru.medicamentmobileapp.ScreenManager;

/**
 * Created by Влад on 27.05.2017.
 */

public abstract class BaseItemsRouter<TItem> {

    protected BaseItemsRouter(ScreenManager screenManager, ItemsViewFactory<TItem> factory) {
        this.screenManager = screenManager;
        this.factory = factory;
    }

    private ScreenManager screenManager;
    private ItemsViewFactory<TItem> factory;

    public void openItemScreen(TItem item) {

        Fragment fragment = factory.create(item);
        screenManager.showScreen(fragment);
    }
}

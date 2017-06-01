package vsu.ru.medicamentmobileapp.ItemsView.Presenters;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import vsu.ru.medicamentmobileapp.ItemsView.Routers.BaseItemsRouter;
import vsu.ru.medicamentmobileapp.Model.Providers.DataProvider;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;
import vsu.ru.medicamentmobileapp.Exceptions.DataIsNotAvailableException;

/**
 * Created by Влад on 19.05.2017.
 */

public class ItemsPresenter extends BaseItemsPresenter<MedicamentItem>{

    @Inject
    public ItemsPresenter(DataProvider provider, BaseItemsRouter<MedicamentItem> router) {
        super(provider, router);
    }

    @Override
    protected Observable<List<MedicamentItem>> getItems() throws DataIsNotAvailableException {

        return provider.getItems();
    }


}

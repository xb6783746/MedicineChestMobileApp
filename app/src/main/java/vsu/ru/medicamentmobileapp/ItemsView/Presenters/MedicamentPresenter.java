package vsu.ru.medicamentmobileapp.ItemsView.Presenters;

import java.util.List;

import rx.Observable;
import vsu.ru.medicamentmobileapp.ItemsView.Routers.BaseItemsRouter;
import vsu.ru.medicamentmobileapp.Model.Providers.DataProvider;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;
import vsu.ru.medicamentmobileapp.Exceptions.DataIsNotAvailableException;

/**
 * Created by Влад on 19.05.2017.
 */

public class MedicamentPresenter extends BaseItemsPresenter<MedicamentDTO> {

    public MedicamentPresenter(DataProvider provider, BaseItemsRouter<MedicamentDTO> router) {
        super(provider, router);
    }

    @Override
    protected Observable<List<MedicamentDTO>> getItems() throws DataIsNotAvailableException {

        return provider.getMedicaments();
    }

}

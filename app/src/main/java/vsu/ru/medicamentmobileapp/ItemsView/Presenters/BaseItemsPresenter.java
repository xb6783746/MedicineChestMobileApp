package vsu.ru.medicamentmobileapp.ItemsView.Presenters;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import vsu.ru.medicamentmobileapp.ItemsView.Routers.BaseItemsRouter;
import vsu.ru.medicamentmobileapp.Model.Providers.DataProvider;
import vsu.ru.medicamentmobileapp.ItemsView.Interfaces.ItemsView;
import vsu.ru.medicamentmobileapp.Presenter;
import vsu.ru.medicamentmobileapp.Model.Dto.AbstractDTO;
import vsu.ru.medicamentmobileapp.Exceptions.DataIsNotAvailableException;

/**
 * Created by Влад on 19.05.2017.
 */

public abstract class BaseItemsPresenter<T extends AbstractDTO> implements Presenter{


    public BaseItemsPresenter(DataProvider provider, BaseItemsRouter<T> router) {
        this.provider = provider;
        this.router = router;
    }

    protected ItemsView<T> view;
    protected DataProvider provider;
    protected BaseItemsRouter<T> router;

    protected abstract Observable<List<T>> getItems() throws DataIsNotAvailableException;
    
    public void open() {

        reload();
    }
    public void close() {

    }
    public void destroy() {

    }
    public void attachView(ItemsView<T> view) {

        this.view = view;
    }
    public void reload() {

        try {
            getItems()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(x -> view.show(x));

        } catch (DataIsNotAvailableException e) {
            e.printStackTrace();
        }
    }
    public void showItem(int num) {

        try {
            getItems()
                    .subscribe(x -> router.openItemScreen(x.get(num)));
        } catch (DataIsNotAvailableException e) {
            e.printStackTrace();
        }
    }
}

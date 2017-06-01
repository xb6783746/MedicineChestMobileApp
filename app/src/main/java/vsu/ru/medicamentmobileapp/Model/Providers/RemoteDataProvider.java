package vsu.ru.medicamentmobileapp.Model.Providers;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import rx.Observable;
import vsu.ru.medicamentmobileapp.Model.Database.DatabaseHelper;
import vsu.ru.medicamentmobileapp.Model.Dto.ItemDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;
import vsu.ru.medicamentmobileapp.Model.Networking.MedicamentApi;
import vsu.ru.medicamentmobileapp.Exceptions.DataIsNotAvailableException;

/**
 * Created by Влад on 27.05.2017.
 */

public class RemoteDataProvider implements DataProvider{

    interface Function<T>{

        Observable<List<T>> invoke() throws SQLException;
    }

    private MedicamentApi api;
    private DatabaseHelper databaseHelper;

    public RemoteDataProvider(DatabaseHelper databaseHelper, MedicamentApi api) {

        this.api = api;
        this.databaseHelper = databaseHelper;

        reload();
    }

    private void reload() {

        new Thread(() -> {
            try {
                refresh(databaseHelper.getMedicamentDao(), api.getMedicaments());
                refresh(databaseHelper.getItemDao(), api.getItems());
                refresh(databaseHelper.getPrescriptionDao(), api.getPrescriptions());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private<T, K> void refresh(Dao<T, K> dao, Observable<List<T>> items) {

        items.toBlocking().subscribe(x -> {

            try {
                dao.delete(dao.queryForAll());

                for(T item: x){

                    dao.create(item);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, x -> {});
    }


    @Override
    public Observable<List<MedicamentDTO>> getMedicaments()
            throws DataIsNotAvailableException {

        return invoke(() ->
                Observable
                        .from(databaseHelper.getMedicamentDao().queryForAll())
                        .toList()
        );

    }

    @Override
    public Observable<List<MedicamentItem>> getItems()
            throws DataIsNotAvailableException {

        return invoke(() -> {

            Dao<ItemDTO, Long> itemDao = databaseHelper.getItemDao();
            return Observable.from(itemDao.queryForAll())
                    .groupBy(x -> x.getMedicament().getName())
                    .flatMap(Observable::toList)
                    .map(x -> {
                        MedicamentItem medicamentItem = new MedicamentItem(x.get(0).getMedicament());

                        for(ItemDTO item : x){
                            medicamentItem
                                    .getItems()
                                    .add(new MedicamentItem.ItemInfo(
                                            item.getNumber(),
                                            item.getExpirationDate()));
                        }

                        return medicamentItem;
                    }).toList();
        });
    }

    @Override
    public Observable<List<PrescriptionDTO>> getPrescriptions()
            throws DataIsNotAvailableException {

        return invoke(() ->
                Observable
                        .from(databaseHelper.getPrescriptionDao().queryForAll())
                        .toList()
        );
    }

    private <T> Observable<List<T>> invoke(RemoteDataProvider.Function<T> action)
            throws DataIsNotAvailableException {

        try {

            return action.invoke();

        } catch (SQLException e) {
            e.printStackTrace();

            throw new DataIsNotAvailableException(e, "");
        }
    }
}

package vsu.ru.medicamentmobileapp.Model.Providers;

import java.util.List;

import rx.Observable;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;
import vsu.ru.medicamentmobileapp.Exceptions.DataIsNotAvailableException;

/**
 * Created by Влад on 19.05.2017.
 */

public interface DataProvider {

    Observable<List<MedicamentDTO>> getMedicaments() throws DataIsNotAvailableException;
    Observable<List<MedicamentItem>> getItems() throws DataIsNotAvailableException;
    Observable<List<PrescriptionDTO>> getPrescriptions() throws DataIsNotAvailableException;
}

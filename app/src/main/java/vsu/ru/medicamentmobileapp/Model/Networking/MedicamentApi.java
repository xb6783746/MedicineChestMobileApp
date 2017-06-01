package vsu.ru.medicamentmobileapp.Model.Networking;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;
import vsu.ru.medicamentmobileapp.Model.Dto.ItemDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

/**
 * Created by Влад on 27.05.2017.
 */

public interface MedicamentApi {

    @GET("rest/medicaments")
    Observable<List<MedicamentDTO>> getMedicaments();

    @GET("rest/items")
    Observable<List<ItemDTO>> getItems();

    @GET("rest/prescriptions")
    Observable<List<PrescriptionDTO>> getPrescriptions();
}

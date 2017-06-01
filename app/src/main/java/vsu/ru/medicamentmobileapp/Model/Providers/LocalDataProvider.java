package vsu.ru.medicamentmobileapp.Model.Providers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.Observable;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

/**
 * Created by Влад on 20.05.2017.
 */

public class LocalDataProvider implements DataProvider {


    public LocalDataProvider() {

        medicaments = new ArrayList<>();
        items = new ArrayList<>();
        prescriptions = new ArrayList<>();

        medicaments.add(new MedicamentDTO(0L, "Арбидол", "0"));
        medicaments.add(new MedicamentDTO(1L, "Цитрамон", "1"));
        medicaments.add(new MedicamentDTO(2L, "Карсил", "2"));

        List<MedicamentItem.ItemInfo> itemInfo = new ArrayList<>();
        itemInfo.add(new MedicamentItem.ItemInfo(5, new Date()));
        itemInfo.add(new MedicamentItem.ItemInfo(7, new Date()));
        itemInfo.add(new MedicamentItem.ItemInfo(10, new Date()));

        items.add(new MedicamentItem(medicaments.get(0), itemInfo));
        items.add(new MedicamentItem(medicaments.get(0), itemInfo));
        items.add(new MedicamentItem(medicaments.get(0), itemInfo));

        prescriptions.add(new PrescriptionDTO(0L, new Date(), "ghj", medicaments.get(0)));
        prescriptions.add(new PrescriptionDTO(1L, new Date(), "vsdvds", medicaments.get(0)));
        prescriptions.add(new PrescriptionDTO(1L, new Date(), "dvsvsd", medicaments.get(0)));


    }

    private List<MedicamentDTO> medicaments;
    private List<MedicamentItem> items;
    private List<PrescriptionDTO> prescriptions;

    @Override
    public Observable<List<MedicamentDTO>> getMedicaments() {

        return Observable.from(medicaments).toList();
    }

    @Override
    public Observable<List<MedicamentItem>> getItems() {

        return Observable.from(items).toList();
    }

    @Override
    public Observable<List<PrescriptionDTO>> getPrescriptions() {
        return Observable.from(prescriptions).toList();
    }
}

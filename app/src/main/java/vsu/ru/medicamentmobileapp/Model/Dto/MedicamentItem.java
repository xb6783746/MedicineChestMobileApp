package vsu.ru.medicamentmobileapp.Model.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Влад on 21.05.2017.
 */

public class MedicamentItem extends AbstractDTO implements Serializable {

    public static class ItemInfo implements Serializable {

        public ItemInfo(int number, Date expDate) {
            this.number = number;
            this.expDate = expDate;
        }

        private int number;
        private Date expDate;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public Date getExpDate() {
            return expDate;
        }

        public void setExpDate(Date expDate) {
            this.expDate = expDate;
        }
    }

    public MedicamentItem(MedicamentDTO medicament) {
        this(medicament, new ArrayList<>());
    }
    public MedicamentItem(MedicamentDTO medicament, List<ItemInfo> items) {
        super(0L);
        this.medicament = medicament;
        this.items = items;
    }

    private MedicamentDTO medicament;
    private List<ItemInfo> items;

    public MedicamentDTO getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentDTO medicament) {
        this.medicament = medicament;
    }

    public List<ItemInfo> getItems() {
        return items;
    }

    public void setItems(List<ItemInfo> items) {
        this.items = items;
    }
}

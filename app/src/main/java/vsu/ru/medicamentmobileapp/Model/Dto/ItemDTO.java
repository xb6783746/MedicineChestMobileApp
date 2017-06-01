package vsu.ru.medicamentmobileapp.Model.Dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Влад on 25.02.2017.
 */
@DatabaseTable(tableName = "items")
public class ItemDTO extends AbstractDTO{

    public ItemDTO() {
    }

    public ItemDTO(Long id, Date date, int num, MedicamentDTO medicament) {
        super(id);

        this.expirationDate = date;
        this.number = num;
        this.medicament = medicament;
    }

    @SerializedName("expirationDate")
    @Expose
    @DatabaseField(dataType = DataType.DATE_STRING, format = "dd-MM-yyyy")
    private Date expirationDate;
    @SerializedName("number")
    @Expose
    @DatabaseField
    private Integer number;
    @SerializedName("medicament")
    @Expose
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private MedicamentDTO medicament;

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public MedicamentDTO getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentDTO medicament) {
        this.medicament = medicament;
    }
}

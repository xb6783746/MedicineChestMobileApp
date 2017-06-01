package vsu.ru.medicamentmobileapp.Model.Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Влад on 25.02.2017.
 */
@DatabaseTable(tableName = "prescriptions")
public class PrescriptionDTO extends AbstractDTO implements Serializable{


    public PrescriptionDTO(){

    }

    public PrescriptionDTO(Long id, Date endDate, String description, MedicamentDTO medicament) {
        super(id);
        this.endDate = endDate;
        this.medicament = medicament;
        this.description = description;
    }

    @SerializedName("endDate")
    @Expose
    @DatabaseField(dataType = DataType.DATE_STRING, format = "dd-MM-yyyy")
    private Date endDate;
    @SerializedName("description")
    @Expose
    @DatabaseField
    private String description;
    @SerializedName("medicament")
    @Expose
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private MedicamentDTO medicament;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public MedicamentDTO getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentDTO medicament) {
        this.medicament = medicament;
    }
}

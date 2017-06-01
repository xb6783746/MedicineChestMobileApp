package vsu.ru.medicamentmobileapp.Model.Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Влад on 25.02.2017.
 */
@DatabaseTable(tableName = "medicaments")
public class MedicamentDTO extends AbstractDTO implements Serializable{

    public MedicamentDTO(){

    }

    public MedicamentDTO(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    @SerializedName("name")
    @Expose
    @DatabaseField
    private String name;
    @SerializedName("description")
    @Expose
    @DatabaseField
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

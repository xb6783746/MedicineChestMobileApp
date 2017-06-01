package vsu.ru.medicamentmobileapp.Model.Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Влад on 25.02.2017.
 */
public class AbstractDTO {

    public AbstractDTO(){

    }

    public AbstractDTO(Long id) {
        this.id = id;
    }

    @SerializedName("id")
    @Expose
    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
    protected Long id;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}

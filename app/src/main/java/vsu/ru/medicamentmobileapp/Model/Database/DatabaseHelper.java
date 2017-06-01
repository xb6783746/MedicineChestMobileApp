package vsu.ru.medicamentmobileapp.Model.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import vsu.ru.medicamentmobileapp.Model.Dto.ItemDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

/**
 * Created by Влад on 28.05.2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    private static String DATABASE_NAME = "meddb8";
    private static int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private Dao<MedicamentDTO, Long> medicamentDao;
    private Dao<ItemDTO, Long> itemDao;
    private Dao<PrescriptionDTO, Long> prescriptionDao;

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, MedicamentDTO.class);
            TableUtils.createTable(connectionSource, ItemDTO.class);
            TableUtils.createTable(connectionSource, PrescriptionDTO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        //TODO
    }

    public Dao<MedicamentDTO, Long> getMedicamentDao() throws SQLException {
        if(medicamentDao == null){
            medicamentDao = getDao(MedicamentDTO.class);
        }

        return medicamentDao;
    }

    public Dao<ItemDTO, Long> getItemDao() throws SQLException {
        if(itemDao == null){
            itemDao = getDao(ItemDTO.class);
        }

        return itemDao;
    }

    public Dao<PrescriptionDTO, Long> getPrescriptionDao() throws SQLException {
        if(prescriptionDao == null){
            prescriptionDao = getDao(PrescriptionDTO.class);
        }

        return prescriptionDao;
    }
}

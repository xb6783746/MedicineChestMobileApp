package vsu.ru.medicamentmobileapp.Modules;

import android.content.Context;

import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;
import vsu.ru.medicamentmobileapp.Model.Providers.DataProvider;
import vsu.ru.medicamentmobileapp.Model.Database.DatabaseHelper;
import vsu.ru.medicamentmobileapp.Model.Networking.MedicamentApi;
import vsu.ru.medicamentmobileapp.Model.Providers.RemoteDataProvider;
import vsu.ru.medicamentmobileapp.ScreenManager;

/**
 * Created by Влад on 27.05.2017.
 */

@Module
public class Utils {

    public Utils(ScreenManager screenManager, Context context, String apiUrl) {
        this.screenManager = screenManager;
        this.context = context;
        this.apiUrl = apiUrl;
    }

    private ScreenManager screenManager;
    private Context context;
    private String apiUrl;

    @Provides
    @Singleton
    DataProvider provideDataProvider(DatabaseHelper helper, MedicamentApi api){

        return new RemoteDataProvider(helper, api);
    }

    @Provides
    ScreenManager provideScreenManager(){

        return screenManager;
    }

    @Provides
    @Singleton
    DatabaseHelper provideDatabaseHelper(){

        return new DatabaseHelper(context);
    }

    @Provides
    @Singleton
    MedicamentApi provideMedicamentApi(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("dd-MM-yyyy").create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        return retrofit.create(MedicamentApi.class);
    }
}

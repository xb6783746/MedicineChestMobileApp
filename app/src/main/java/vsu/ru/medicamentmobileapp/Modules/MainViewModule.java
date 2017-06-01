package vsu.ru.medicamentmobileapp.Modules;

import dagger.Module;
import dagger.Provides;
import vsu.ru.medicamentmobileapp.MainScreen.Interfaces.MainScreenViewFactory;
import vsu.ru.medicamentmobileapp.MainScreen.MainScreenViewFactoryImpl;

/**
 * Created by Влад on 30.05.2017.
 */

@Module
public class MainViewModule {

    @Provides
    MainScreenViewFactory provideMainScreenViewFactory(){

        return new MainScreenViewFactoryImpl();
    }
}

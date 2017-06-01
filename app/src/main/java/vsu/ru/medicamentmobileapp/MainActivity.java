package vsu.ru.medicamentmobileapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vsu.ru.medicamentmobileapp.ItemsView.Views.DaggerItemsViewComponents;
import vsu.ru.medicamentmobileapp.ItemsView.Views.ItemsViewComponents;
import vsu.ru.medicamentmobileapp.MainScreen.MainFragment;
import vsu.ru.medicamentmobileapp.Modules.PresentersModule;
import vsu.ru.medicamentmobileapp.Modules.Utils;

public class MainActivity extends AppCompatActivity implements ScreenManager{

    private ItemsViewComponents itemsViewComponents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsViewComponents = DaggerItemsViewComponents
                .builder()
                .presentersModule(new PresentersModule())
                .utils(new Utils(this, this, "http://192.168.1.34:8080/medWeb/"))
                .build();

        showScreen(MainFragment.newInstance());
    }

    public void showScreen(Fragment fragment){

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction
                .replace(R.id.host, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);


    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1 ) {
            getFragmentManager().popBackStack();
        }
    }

    public ItemsViewComponents getItemsViewComponents(){
        return itemsViewComponents;
    }
}

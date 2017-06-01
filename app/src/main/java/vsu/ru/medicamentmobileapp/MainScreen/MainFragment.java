package vsu.ru.medicamentmobileapp.MainScreen;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vsu.ru.medicamentmobileapp.MainScreen.Adapters.ItemsScreenAdapter;
import vsu.ru.medicamentmobileapp.MainScreen.Interfaces.MainScreenViewFactory;
import vsu.ru.medicamentmobileapp.Modules.MainViewModule;
import vsu.ru.medicamentmobileapp.R;

public class MainFragment extends Fragment {

    public MainFragment() {

    }

    @Inject
    MainScreenViewFactory factory;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private ItemsScreenAdapter adapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        DaggerMainViewComponents
                .builder()
                .mainViewModule(new MainViewModule())
                .build()
                .inject(this);

        super.onCreate(savedInstanceState);

        List<ItemsScreenAdapter.FragmentWithTitle> screens = new ArrayList<>();

        screens.add(new ItemsScreenAdapter.FragmentWithTitle(factory.getMedicamentsScreen(), "Лекарства"));
        screens.add(new ItemsScreenAdapter.FragmentWithTitle(factory.getItemsScreen(), "Упаковки"));
        screens.add(new ItemsScreenAdapter.FragmentWithTitle(factory.getPrescriptionsScreen(), "Рецепты"));

        adapter = new ItemsScreenAdapter(getChildFragmentManager(), screens);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}

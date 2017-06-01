package vsu.ru.medicamentmobileapp.ItemsView.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vsu.ru.medicamentmobileapp.ItemsView.Views.Adapters.ItemsAdapter;
import vsu.ru.medicamentmobileapp.R;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;

public class ItemsView extends BaseItemsView<MedicamentItem> {


    public ItemsView() {
    }

    public static ItemsView newInstance() {
        return new ItemsView();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getComponent()
                .inject(this);
        presenter.attachView(this);

        super.onCreate(savedInstanceState);

        adapter = new ItemsAdapter(pos -> presenter.showItem(pos));
    }


}

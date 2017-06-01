package vsu.ru.medicamentmobileapp.ItemsView.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vsu.ru.medicamentmobileapp.ItemsView.Views.Adapters.ItemsAdapter;
import vsu.ru.medicamentmobileapp.ItemsView.Views.Adapters.PrescriptionsAdapter;
import vsu.ru.medicamentmobileapp.R;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

public class PrescriptionsView extends BaseItemsView<PrescriptionDTO> {


    public PrescriptionsView() {
    }

    public static PrescriptionsView newInstance() {
        return new PrescriptionsView();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getComponent()
                .inject(this);
        presenter.attachView(this);

        super.onCreate(savedInstanceState);

        adapter = new PrescriptionsAdapter(pos -> presenter.showItem(pos));
    }


}

package vsu.ru.medicamentmobileapp.ItemsView.Views;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import vsu.ru.medicamentmobileapp.BaseFragment;
import vsu.ru.medicamentmobileapp.ItemsView.Presenters.BaseItemsPresenter;
import vsu.ru.medicamentmobileapp.ItemsView.Views.Adapters.BaseItemsAdapter;
import vsu.ru.medicamentmobileapp.Model.Dto.AbstractDTO;
import vsu.ru.medicamentmobileapp.R;

/**
 * Created by Влад on 27.05.2017.
 */

public class BaseItemsView<TItem extends AbstractDTO> extends BaseFragment
        implements vsu.ru.medicamentmobileapp.ItemsView.Interfaces.ItemsView<TItem> {

    @Inject
    protected BaseItemsPresenter<TItem> presenter;

    protected BaseItemsAdapter<TItem, ?> adapter;
    protected RecyclerView recyclerView;

    public BaseItemsView() {
    }


    @Override
    public void show(List<TItem> items) {
        adapter.setData(items);
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.open();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_medicaments_view, container, false);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerItemsView);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        return view;
    }
}

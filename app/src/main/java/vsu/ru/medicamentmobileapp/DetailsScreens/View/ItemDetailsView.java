package vsu.ru.medicamentmobileapp.DetailsScreens.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vsu.ru.medicamentmobileapp.DetailsScreens.View.Adapters.ItemDetailsAdapter;
import vsu.ru.medicamentmobileapp.R;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;

public class ItemDetailsView extends AbstractDetailsView<MedicamentItem> {

    private ItemDetailsAdapter adapter;

    public ItemDetailsView() {
    }

    public static ItemDetailsView newInstance(MedicamentItem items) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(ITEM, items);

        ItemDetailsView view = new ItemDetailsView();
        view.setArguments(bundle);

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ItemDetailsAdapter(item.getItems());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_details, container, false);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.itemFragmentRecycleView);
        TextView textView = (TextView) view.findViewById(R.id.itemFragmentMedicamentName);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        textView.setText(item.getMedicament().getName());
        return view;
    }

}

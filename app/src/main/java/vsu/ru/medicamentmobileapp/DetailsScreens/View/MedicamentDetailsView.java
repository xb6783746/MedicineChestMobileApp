package vsu.ru.medicamentmobileapp.DetailsScreens.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vsu.ru.medicamentmobileapp.R;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;

public class MedicamentDetailsView extends AbstractDetailsView<MedicamentDTO> {

    public MedicamentDetailsView() {
    }

    public static MedicamentDetailsView newInstance(MedicamentDTO items) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ITEM, items);

        MedicamentDetailsView view = new MedicamentDetailsView();
        view.setArguments(bundle);

        return view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.medicament_details, container, false);

        TextView medicamentName = (TextView) view.findViewById(R.id.medicamentName);
        TextView description = (TextView) view.findViewById(R.id.description);

        medicamentName.setText(item.getName());
        description.setText(item.getDescription());

        return view;
    }



}

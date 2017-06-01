package vsu.ru.medicamentmobileapp.DetailsScreens.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import vsu.ru.medicamentmobileapp.R;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

public class PrescriptionDetailsView extends AbstractDetailsView<PrescriptionDTO> {

    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public PrescriptionDetailsView() {
    }

    public static PrescriptionDetailsView newInstance(PrescriptionDTO items) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ITEM, items);

        PrescriptionDetailsView view = new PrescriptionDetailsView();
        view.setArguments(bundle);

        return view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.prescription_details, container, false);

        TextView medicamentName = (TextView) view.findViewById(R.id.medicamentName);
        TextView description = (TextView) view.findViewById(R.id.description);
        TextView endDate = (TextView) view.findViewById(R.id.endDate);

        medicamentName.setText(item.getMedicament().getName());
        description.setText(item.getDescription());
        endDate.setText(format.format(item.getEndDate()));

        return view;
    }



}

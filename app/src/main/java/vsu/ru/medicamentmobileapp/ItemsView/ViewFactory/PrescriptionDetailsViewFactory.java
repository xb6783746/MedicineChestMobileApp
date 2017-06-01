package vsu.ru.medicamentmobileapp.ItemsView.ViewFactory;

import android.app.Fragment;

import vsu.ru.medicamentmobileapp.DetailsScreens.View.PrescriptionDetailsView;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

/**
 * Created by Влад on 27.05.2017.
 */

public class PrescriptionDetailsViewFactory implements ItemsViewFactory<PrescriptionDTO> {
    @Override
    public Fragment create(PrescriptionDTO prescriptionDTO){

        return PrescriptionDetailsView.newInstance(prescriptionDTO);
    }
}

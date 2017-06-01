package vsu.ru.medicamentmobileapp.ItemsView.ViewFactory;

import android.app.Fragment;

import vsu.ru.medicamentmobileapp.DetailsScreens.View.MedicamentDetailsView;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;

/**
 * Created by Влад on 27.05.2017.
 */

public class MedicamentDetailsViewFactory implements ItemsViewFactory<MedicamentDTO> {
    @Override
    public Fragment create(MedicamentDTO medicamentDTO) {
        return MedicamentDetailsView.newInstance(medicamentDTO);
    }
}

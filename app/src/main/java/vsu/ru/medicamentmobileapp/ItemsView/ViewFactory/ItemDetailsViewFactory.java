package vsu.ru.medicamentmobileapp.ItemsView.ViewFactory;

import android.app.Fragment;

import vsu.ru.medicamentmobileapp.DetailsScreens.View.ItemDetailsView;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;

/**
 * Created by Влад on 27.05.2017.
 */

public class ItemDetailsViewFactory implements ItemsViewFactory<MedicamentItem> {

    @Override
    public Fragment create(MedicamentItem medicamentItem) {
        return ItemDetailsView.newInstance(medicamentItem);
    }
}

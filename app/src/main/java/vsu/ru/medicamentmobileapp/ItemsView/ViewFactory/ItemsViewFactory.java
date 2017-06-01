package vsu.ru.medicamentmobileapp.ItemsView.ViewFactory;

import android.app.Fragment;

/**
 * Created by Влад on 27.05.2017.
 */

public interface ItemsViewFactory<TItem> {

    Fragment create(TItem item);
}

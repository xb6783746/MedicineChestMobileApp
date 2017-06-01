package vsu.ru.medicamentmobileapp.ItemsView.Interfaces;

import java.util.List;

import vsu.ru.medicamentmobileapp.Model.Dto.AbstractDTO;

/**
 * Created by Влад on 19.05.2017.
 */

public interface ItemsView<T extends AbstractDTO> {

    void show(List<T> items);
}

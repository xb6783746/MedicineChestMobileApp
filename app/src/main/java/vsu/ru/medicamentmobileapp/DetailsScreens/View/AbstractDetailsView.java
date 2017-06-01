package vsu.ru.medicamentmobileapp.DetailsScreens.View;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by Влад on 01.06.2017.
 */

public class AbstractDetailsView<TItem extends Serializable> extends Fragment {

    protected static final String ITEM = "item";

    protected TItem item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        if(args != null){

            item = (TItem) args.getSerializable(ITEM);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(ITEM, item);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {

            item = (TItem)savedInstanceState.getSerializable(ITEM);
        }
    }
}

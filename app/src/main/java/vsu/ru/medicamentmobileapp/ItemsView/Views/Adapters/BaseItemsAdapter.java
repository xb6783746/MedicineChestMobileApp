package vsu.ru.medicamentmobileapp.ItemsView.Views.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 27.05.2017.
 */

public abstract class BaseItemsAdapter<TItem, TViewHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<TViewHolder>{

    public interface OnClickListener{

        void click(int pos);
    }

    public BaseItemsAdapter(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        items = new ArrayList<>();
    }

    protected List<TItem> items;
    protected OnClickListener onClickListener;

    public void setData(List<TItem> items){

        this.items = items;

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        if(items == null){
            return 0;
        }

        return items.size();
    }
}

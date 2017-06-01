package vsu.ru.medicamentmobileapp.ItemsView.Views.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vsu.ru.medicamentmobileapp.R;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;

/**
 * Created by Влад on 20.05.2017.
 */

public class ItemsAdapter extends BaseItemsAdapter<MedicamentItem, ItemsAdapter.ItemViewHolder>  {

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        CardView card;
        TextView medicamentName;
        TextView itemsCount;
        OnClickListener listener;

        public ItemViewHolder(View itemView, final OnClickListener listener) {
            super(itemView);

            this.listener = listener;
            card = (CardView)itemView.findViewById(R.id.itemCard);
            medicamentName = (TextView)itemView.findViewById(R.id.medicamentName);
            itemsCount = (TextView)itemView.findViewById(R.id.itemsCount);

            card.setOnClickListener(view -> {
                if(listener != null){

                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION) {
                        listener.click(pos);
                    }
                }
            });
        }
    }

    public ItemsAdapter(OnClickListener listener) {
        super(listener);
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);

        return new ItemViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        MedicamentItem medicament = items.get(position);

        holder.medicamentName.setText(medicament.getMedicament().getName());
        holder.itemsCount.setText(String.valueOf(medicament.getItems().size()) + " шт.");
    }
}

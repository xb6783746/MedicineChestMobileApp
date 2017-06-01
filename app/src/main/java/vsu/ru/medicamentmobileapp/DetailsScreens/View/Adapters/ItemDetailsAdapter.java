package vsu.ru.medicamentmobileapp.DetailsScreens.View.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import vsu.ru.medicamentmobileapp.R;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentItem;

/**
 * Created by Влад on 20.05.2017.
 */

public class ItemDetailsAdapter extends RecyclerView.Adapter<ItemDetailsAdapter.ItemsDetailsViewHolder> {


    public static class ItemsDetailsViewHolder extends RecyclerView.ViewHolder{

        CardView card;
        TextView itemsNumber;
        TextView itemsExpDate;

        public ItemsDetailsViewHolder(View itemView) {
            super(itemView);

            card = (CardView)itemView.findViewById(R.id.medCard);
            itemsNumber = (TextView)itemView.findViewById(R.id.itemsNumber);
            itemsExpDate = (TextView)itemView.findViewById(R.id.itemExpDate);
        }
    }

    public ItemDetailsAdapter(List<MedicamentItem.ItemInfo> items) {

        this.itemInfo = items;

        format = new SimpleDateFormat("dd-MM-yyyy");
    }

    private List<MedicamentItem.ItemInfo> itemInfo;
    private SimpleDateFormat format;

    public void setData(List<MedicamentItem.ItemInfo> data){

        this.itemInfo = data;

        notifyDataSetChanged();
    }

    @Override
    public ItemsDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details_card, parent, false);

        return new ItemsDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsDetailsViewHolder holder, int position) {

        MedicamentItem.ItemInfo itmInfo = itemInfo.get(position);

        holder.itemsNumber.setText(String.valueOf(itmInfo.getNumber()));
        holder.itemsExpDate.setText(format.format(itmInfo.getExpDate()));
    }

    @Override
    public int getItemCount() {
        return itemInfo.size();
    }
}

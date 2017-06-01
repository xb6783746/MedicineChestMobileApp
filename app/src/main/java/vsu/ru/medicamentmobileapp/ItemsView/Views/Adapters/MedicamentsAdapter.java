package vsu.ru.medicamentmobileapp.ItemsView.Views.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vsu.ru.medicamentmobileapp.R;
import vsu.ru.medicamentmobileapp.Model.Dto.MedicamentDTO;

/**
 * Created by Влад on 20.05.2017.
 */

public class MedicamentsAdapter extends BaseItemsAdapter<MedicamentDTO, MedicamentsAdapter.MedicamentViewHolder> {


    public static class MedicamentViewHolder extends RecyclerView.ViewHolder{

        CardView card;
        TextView medicamentName;
        OnClickListener listener;

        public MedicamentViewHolder(View itemView, final OnClickListener listener) {
            super(itemView);

            card = (CardView)itemView.findViewById(R.id.medCard);
            medicamentName = (TextView)itemView.findViewById(R.id.medicamentName);
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

    public MedicamentsAdapter(OnClickListener listener) {
        super(listener);
    }


    @Override
    public MedicamentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicament_card, parent, false);

        return new MedicamentViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(MedicamentViewHolder holder, int position) {

        MedicamentDTO medicament = items.get(position);

        holder.medicamentName.setText(medicament.getName());
    }
}

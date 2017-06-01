package vsu.ru.medicamentmobileapp.ItemsView.Views.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import vsu.ru.medicamentmobileapp.R;
import vsu.ru.medicamentmobileapp.Model.Dto.PrescriptionDTO;

/**
 * Created by Влад on 20.05.2017.
 */

public class PrescriptionsAdapter extends BaseItemsAdapter<PrescriptionDTO, PrescriptionsAdapter.PrescriptionViewHolder> {


    public static class PrescriptionViewHolder extends RecyclerView.ViewHolder{

        CardView card;
        TextView medicamentName;
        TextView endDate;
        OnClickListener listener;

        public PrescriptionViewHolder(View itemView, final OnClickListener listener) {
            super(itemView);

            card = (CardView)itemView.findViewById(R.id.medCard);
            medicamentName = (TextView)itemView.findViewById(R.id.medicamentName);
            endDate = (TextView)itemView.findViewById(R.id.endDate);
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

    public PrescriptionsAdapter(OnClickListener listener) {
        super(listener);

        format = new SimpleDateFormat("dd-MM-yyyy");
    }

    private SimpleDateFormat format;

    @Override
    public PrescriptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_card, parent, false);

        return new PrescriptionViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(PrescriptionViewHolder holder, int position) {

        PrescriptionDTO prescription = items.get(position);

        holder.medicamentName.setText(prescription.getMedicament().getName());
        holder.endDate.setText("до " + format.format(prescription.getEndDate()));
    }
}

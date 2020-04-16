package com.mobile.covidinfoapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.covidinfoapp.R;
import com.mobile.covidinfoapp.UpdateActivity;
import com.mobile.covidinfoapp.model.CovidData;

public class LastUpdateAdapter extends RecyclerView.Adapter<LastUpdateAdapter.ViewHolder> {
    private Context context;
    CovidData covidData;

    public LastUpdateAdapter(Context context, CovidData covidData) {
        this.context = context;
        this.covidData = covidData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtKonfirmasi.setText(covidData.getPositif());
        holder.txtSembuh.setText(covidData.getCovidSembuh());
        holder.txtMeninggal.setText(covidData.getCovidMeninggal());
        holder.txtWaktu.setText(covidData.getWaktu());
        holder.btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtKonfirmasi,txtSembuh,txtMeninggal,txtWaktu;
        private Button btnAll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtKonfirmasi = itemView.findViewById(R.id.txt_confirmed);
            txtSembuh = itemView.findViewById(R.id.txt_healthy);
            txtMeninggal = itemView.findViewById(R.id.txt_meninggal);
            txtWaktu = itemView.findViewById(R.id.txt_waktu);
            btnAll = itemView.findViewById(R.id.btn_all_data);
        }
    }
}

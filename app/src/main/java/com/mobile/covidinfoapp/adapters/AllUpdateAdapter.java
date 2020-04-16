package com.mobile.covidinfoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.covidinfoapp.R;
import com.mobile.covidinfoapp.model.CovidData;

import java.util.ArrayList;
import java.util.List;

public class AllUpdateAdapter extends RecyclerView.Adapter<AllUpdateAdapter.ViewHolder> {
    private final Context context;
    private List<CovidData> listData = new ArrayList<>();

    public AllUpdateAdapter(Context context, List<CovidData> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CovidData covidData = listData.get(position);
        holder.txtKonfirmasi.setText(covidData.getPositif());
        holder.txtSembuh.setText(covidData.getCovidSembuh());
        holder.txtMeninggal.setText(covidData.getCovidMeninggal());
        holder.txtWaktu.setText(covidData.getWaktu());
    }

    @Override
    public int getItemCount() {
        int count;
        if (listData == null) {
            count = 0;
            Toast.makeText(context, "Null", Toast.LENGTH_SHORT).show();
        } else {
            count = listData.size();
        }
        return count;
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
            btnAll.setVisibility(View.GONE);
        }
    }
}

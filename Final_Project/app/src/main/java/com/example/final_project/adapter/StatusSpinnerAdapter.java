package com.example.final_project.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.final_project.R;
import com.example.final_project.entity.RoomStatus;

import java.util.List;

public class StatusSpinnerAdapter extends ArrayAdapter<RoomStatus> {
    public StatusSpinnerAdapter(@NonNull Context context, int resource, @NonNull List<RoomStatus> objects) {
        super(context, resource, objects);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_status_spinner_selected, parent, false);
        TextView tvStatusSelected = convertView.findViewById(R.id.tv_selected);

        RoomStatus roomStatus = this.getItem(position);
        if(roomStatus != null) {
            tvStatusSelected.setText(roomStatus.statusName);
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_status_spinner, parent, false);
        TextView tvStatus = convertView.findViewById(R.id.status_spinner);

        RoomStatus roomStatus = this.getItem(position);
        if(roomStatus != null) {
            tvStatus.setText(roomStatus.statusName);
        }
        return convertView;
    }
}

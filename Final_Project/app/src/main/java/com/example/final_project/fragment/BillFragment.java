package com.example.final_project.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.final_project.R;
import com.example.final_project.adapter.StatusSpinnerAdapter;
import com.example.final_project.entity.RoomStatus;

import java.util.ArrayList;
import java.util.List;

public class BillFragment extends Fragment {

    private StatusSpinnerAdapter statusAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bill_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spnRoomStatus = view.findViewById(R.id.spinner_status_hd);
        statusAdapter = new StatusSpinnerAdapter(view.getContext(), R.layout.item_status_spinner_selected, getListStatus());

        spnRoomStatus.setAdapter(statusAdapter);

        spnRoomStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), statusAdapter.getItem(position).statusName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<RoomStatus> getListStatus() {
        //todo: Trả về list các status có trong db (tạm thời fix cứng data)
        List<RoomStatus> roomStatuses = new ArrayList<>();
        roomStatuses.add(new RoomStatus(1L, "Chua tra"));
        roomStatuses.add(new RoomStatus(2L, "Da tra"));
        roomStatuses.add(new RoomStatus(3L, "Chua nhan phong"));
        return roomStatuses;
    }
}
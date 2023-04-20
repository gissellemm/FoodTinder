package com.example.foodtinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class DiscoverPage extends Fragment {

    private List<Integer> images;
    private MyAdapter arrayAdapter;
    private int i;

    private SwipeFlingAdapterView flingContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_page, container, false);

        flingContainer = view.findViewById(R.id.frame);

        images = new ArrayList<>();
        images.add(R.drawable.poor_calvins);
        images.add(R.drawable.bww);
        images.add(R.drawable.pizzahut);
        images.add(R.drawable.ecco_midterm);
        images.add(R.drawable.zaxbys);
        images.add((R.drawable.halal_guys));
        images.add(R.drawable.mcdonalds);
        images.add((R.drawable.the_vortex));
        images.add(R.drawable.wingstop);
        images.add((R.drawable.el_valle));
        images.add((R.drawable.melting_pot));
        images.add(R.drawable.culvers);
        images.add(R.drawable.yebisuya);

        arrayAdapter = new MyAdapter(getContext(), images);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                images.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                Toast.makeText(getActivity(),"Eww!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(getActivity(),"Yummy!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                images.add(R.drawable.halal_guys);
                arrayAdapter.notifyDataSetChanged();
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });

        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(getActivity(),"Oops!", Toast.LENGTH_SHORT).show();
            }
        });

        Button rightButton = view.findViewById(R.id.btn_right);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingContainer.getTopCardListener().selectRight();
            }
        });

        Button leftButton = view.findViewById(R.id.btn_left);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingContainer.getTopCardListener().selectLeft();
            }
        });

        return view;
    }
}
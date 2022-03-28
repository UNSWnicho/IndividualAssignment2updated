package com.example.infs3634_individualassignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder> implements Filterable {

    private ArrayList<Holiday> mHolidays, mHolidaysFiltered;
    public HolidayAdapter(ArrayList<Holiday> holidays) {
        mHolidays = holidays;
        mHolidaysFiltered = holidays;
    }

    @NonNull
    @Override
    public HolidayAdapter.HolidayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new HolidayViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayAdapter.HolidayViewHolder holder, int position) {
        Holiday holiday = mHolidaysFiltered.get(position);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        holder.name.setText(holiday.getName());

        holder.rating.setText(holiday.getRating());

    }

    @Override
    public int getItemCount() {
        return mHolidaysFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mHolidaysFiltered = mHolidays;
                } else {
                    ArrayList<Holiday> filteredList = new ArrayList<>();
                    for (Holiday holiday : mHolidays) {
                        if (holiday.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(holiday);
                        }
                    }
                    mHolidaysFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mHolidaysFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mHolidaysFiltered = (ArrayList<Holiday>) filterResults.values;
                notifyDataSetChanged();
            }
        };

    }

    protected static class HolidayViewHolder extends RecyclerView.ViewHolder {
        TextView name, rating, change;

        public HolidayViewHolder(@NonNull View itemView) {
            super(itemView);
            // Get handle for view elements
            name = itemView.findViewById(R.id.tvName);
            rating = itemView.findViewById(R.id.tvRate);

        }


    }
    public void sort(final int sortMethod) {
        if (mHolidaysFiltered.size() > 0) {
            Collections.sort(mHolidaysFiltered, new Comparator<Holiday>() {
                @Override
                public int compare(Holiday o1, Holiday o2) {
                    if (sortMethod == 1) {
                        //Sort the list by name
                        return o1.getName().compareTo(o2.getName());
                    } else if(sortMethod == 2) {
                        // Sort the list by value
                        return Double.valueOf(o1.getRating()).compareTo(Double.valueOf(o2.getRating()));
                    }
                    return o1.getName().compareTo(o2.getName());
                }




});

        }
    }
}



package com.example.tabsyncedrecylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int header = 0, layout = 1;
    private Context context;
    private ArrayList<Object> list;

    public MyAdapter(Context mainActivity, ArrayList<Object> list) {
        this.context = mainActivity;
        this.list = list;
    }

    class Header extends RecyclerView.ViewHolder {

        private TextView headertext;

        public Header(View itemView) {
            super(itemView);
            headertext = itemView.findViewById(R.id.headerText);

        }
    }

    class Layout extends RecyclerView.ViewHolder {
        private TextView layoutText;

        public Layout(View itemView) {
            super(itemView);
            layoutText = itemView.findViewById(R.id.layoutText);

        }

    }

    public Object getItem(int position){
        return list.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof HeaderModel) {
            return header;
        } else {
            return layout;
        }
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == header) {
            return new Header(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item_header, parent, false));

        } else {
            return new Layout(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item_layout, parent, false));

        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder.getItemViewType() == header) {
            Header header = (Header) holder;
            HeaderModel headerModel = (HeaderModel) list.get(position);
            header.headertext.setText(headerModel.getHeader());
        } else {
            Layout layout = (Layout) holder;
            LayoutModel layoutModel = (LayoutModel) list.get(position);
            layout.layoutText.setText(layoutModel.getItem());

        }


    }
}
package com.example.listviewatv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewCustomAdapter extends BaseAdapter {
    String[] items;
    String[] subitems;
    int[] images;
    Context context;

    ListViewCustomAdapter(Context context, String[] items, String[] subitems, int[] images){
        this.context = context;
        this.items = items;
        this.subitems = subitems;
        this.images = images;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_system, parent, false);

            holder = new ViewHolder();
            holder.tvNomeItem = convertView.findViewById(R.id.tv_nome);
            holder.tvDescricaoItem = convertView.findViewById(R.id.tv_descricao);
            holder.ivItem = convertView.findViewById(R.id.iv_system);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();

        }

        holder.tvNomeItem.setText(items[position]);
        holder.tvDescricaoItem.setText(subitems[position]);
        holder.ivItem.setImageResource(images[position]);

        return convertView;
    }

    static class ViewHolder{
        TextView tvNomeItem;
        TextView tvDescricaoItem;
        ImageView ivItem;
    }



}



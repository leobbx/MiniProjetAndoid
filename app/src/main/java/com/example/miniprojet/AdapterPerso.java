package com.example.miniprojet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterPerso extends BaseAdapter {
    private Context context;
    private List<Dechet> valeurs;
    private int image = R.drawable.poubelle;

    private static LayoutInflater inflater = null;

    public AdapterPerso(Context context, List<Dechet> valeurs){
        this.context = context;
        this.valeurs = valeurs;

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return valeurs.size();
    }

    @Override
    public Object getItem(int pos) {
        return this.valeurs.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View previous = convertView;
        View retour = previous;

        if (retour == null) {
            retour = inflater.inflate(R.layout.liste_dechet,null);
        }

        TextView text = (TextView) retour.findViewById(R.id.tv_label);
        ImageView img = (ImageView) retour.findViewById(R.id.iv_img);
        text.setText(valeurs.get(pos).getLabel());
        img.setImageResource(this.image);

        return retour;
    }
}
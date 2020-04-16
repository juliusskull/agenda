package com.e.agenda.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.e.agenda.R;
import com.e.agenda.model.Agenda_pendiente;
import com.e.agenda.utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AgendaPendienteAdapter extends BaseAdapter {

    public static final int ERROR_MAX_SELECCIONADOS = 1;
    private final Context context;
    int layoutResourceId;
    private List<Agenda_pendiente> data;
    private ArrayList<Agenda_pendiente> tipoarray;
    private ArrayList<Agenda_pendiente> seleccionados = new ArrayList<Agenda_pendiente>();
    private Cursor cursor;
    private int TOTAL_SELECCIONADOS_POSIBLES = 1;//Configuracion.OPERARIOS_TOTAL_SELECCIONADOS_POSIBLES;
    private int TOTOTAL_SELECCIONADOS = 0;
    private static OnAdapterListaSelectAgenda_pendiente onAdapterListaSelectAgenda_pendiente;

    public AgendaPendienteAdapter(Context context, int layoutResourceId,
                                  List<Agenda_pendiente> data) {
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.tipoarray = new ArrayList<Agenda_pendiente>();
        this.data = data;
        this.tipoarray.addAll(this.data);
        Util.Log("data=>" + this.data.size());

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view;

        PlaceHolder holder = new PlaceHolder();
        final int pos = position;
/*
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent, false);
            holder.chk = (CheckBox) view.findViewById(R.id.checkBox1);
            view.setTag(holder);

        } else {
            view = convertView;
            holder = (PlaceHolder) view.getTag();
        }
        */
        view = convertView;
        holder = (PlaceHolder) view.getTag();
        view.setClickable(true);


        holder.chk.setText(data.get(position).getDesc_motivo());
        final PlaceHolder holder2 = holder;
        final int position_actual = position;
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Util.Log("=>clik view");
                if (TOTOTAL_SELECCIONADOS < TOTAL_SELECCIONADOS_POSIBLES) {
                    if (holder2.chk.isChecked()) {
                        holder2.chk.setChecked(false);
                        view.setBackgroundColor(Color.WHITE);
                        TOTOTAL_SELECCIONADOS--;
                        seleccionados.remove(data.get(position_actual));
                    } else {
                        holder2.chk.setChecked(true);
                        view.setBackgroundColor(Color.RED);
                        TOTOTAL_SELECCIONADOS++;

                    }
                    seleccionados.add(data.get(position_actual));

                } else {
                    if (holder2.chk.isChecked()) {
                        holder2.chk.setChecked(false);
                        view.setBackgroundColor(Color.WHITE);
                        seleccionados.remove(data.get(position_actual));
                        TOTOTAL_SELECCIONADOS--;
                    }
                    if (TOTOTAL_SELECCIONADOS > TOTAL_SELECCIONADOS_POSIBLES) {
                        onAdapterListaSelectAgenda_pendiente.onClickList(AgendaPendienteAdapter.ERROR_MAX_SELECCIONADOS);
                    }

                }
            }
        });

        return view;
    }

    public interface OnAdapterListaSelectAgenda_pendiente {
        // you can define any parameter as per your requirement
        void onClickList(int er);
    }

    @Override
    public int getCount() {
        if (data == null) {
            Log.d("w nullu", "w nullu");
            return 0;
        }
        return data.size();
    }

    @Override
    public Agenda_pendiente getItem(int position) {

        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).get_id();
    }

    private class PlaceHolder {
        /*
        TextView domicilio;
        TextView descripcion;
        TextView place;
        ImageView image;
        */
        CheckBox chk;

    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        this.data = new ArrayList<Agenda_pendiente>();
        if (charText.length() == 0) {
            data.addAll(tipoarray);
        } else {
            for (Agenda_pendiente wp : tipoarray) {
                if (wp.getDesc_motivo().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    data.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void swapCursor(Cursor newCursor) {
        cursor = newCursor;
        notifyDataSetChanged();
    }


    public ArrayList<Agenda_pendiente> getSeleccionados() {
        return seleccionados;
    }


    public void setSeleccionados(ArrayList<Agenda_pendiente> seleccionados) {
        this.seleccionados = seleccionados;
    }


    public OnAdapterListaSelectAgenda_pendiente getOnAdapterListaSelectAgenda_pendiente() {
        return onAdapterListaSelectAgenda_pendiente;
    }


    public void setOnAdapterListaSelectAgenda_pendiente(
            OnAdapterListaSelectAgenda_pendiente onAdapterListaSelectAgenda_pendiente) {
        AgendaPendienteAdapter.onAdapterListaSelectAgenda_pendiente = onAdapterListaSelectAgenda_pendiente;
    }


}
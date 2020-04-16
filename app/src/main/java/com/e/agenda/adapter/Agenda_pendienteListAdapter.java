package com.e.agenda.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.e.agenda.R;
import com.e.agenda.model.Agenda_pendiente;
import com.e.agenda.utils.Util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Agenda_pendienteListAdapter extends BaseAdapter {

	private final Context context;
	int layoutResourceId;
	private List<Agenda_pendiente>data;
	private ArrayList<Agenda_pendiente> tipoarray;
	private Cursor cursor;


	public Agenda_pendienteListAdapter(Context context, int layoutResourceId,
			List<Agenda_pendiente> data) {
		this.layoutResourceId=layoutResourceId;
		this.context = context;
		this.tipoarray = new ArrayList<Agenda_pendiente>();
		//this.data = new ArrayList<Agenda_pendiente>();
		this.data = data;//Arrays.asList(data);

		this.tipoarray.addAll(this.data);
		Util.Log("data=>"+this.data.size());
		//this.app = (TouristGuideApp) ((Activity) context).getApplication();
	}



	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;

		PlaceHolder holder = null;
		final int pos= position;

		if (convertView == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			view = inflater.inflate(layoutResourceId, parent, false);
			holder = new PlaceHolder();

			holder.place = (TextView) view.findViewById(R.id.tv_name);
			holder.descripcion = (
					TextView) view.findViewById(R.id.tv_descripcion);
			holder.domicilio = (TextView) view.findViewById(R.id.tv_domicilio);

			view.setTag(holder);

		} else {
			view = convertView;
			holder = (PlaceHolder) view.getTag();
		}

		holder.place.setText(data.get(position).getAgenda_pendiente());
		//holder.descripcion.setText(data.get(position).getDomicilio());
		holder.domicilio.setText("");

		return view;
	}

	@Override
	public int getCount() {
		if (data == null){
			Log.d("w nullu","w nullu");
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
		TextView domicilio;
		TextView descripcion;
		TextView place;
		ImageView image;

	}
	// Filter Class
				public void filter(String charText) {
					charText = charText.toLowerCase(Locale.getDefault());
					this.data = new ArrayList<Agenda_pendiente>();
					if (charText.length() == 0) {
						data.addAll(tipoarray);
					} else {
						for (Agenda_pendiente wp : tipoarray) {
							if (wp.getAgenda_pendiente().toLowerCase(Locale.getDefault())
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
}
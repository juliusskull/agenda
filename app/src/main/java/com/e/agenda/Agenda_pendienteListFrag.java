package com.e.agenda;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.e.agenda.adapter.Agenda_pendienteListAdapter;

import com.e.agenda.constants.Configuracion;
import com.e.agenda.db.DatabaseManager;
import com.e.agenda.model.Agenda_pendiente;
import com.e.agenda.model.Agenda_pendienteList;

import com.e.agenda.utils.Util;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.toolbox.Volley.*;

public class Agenda_pendienteListFrag extends Fragment{
	private ListView lista;
	private Agenda_pendienteListAdapter adapter2;
	protected Agenda_pendienteList list = new Agenda_pendienteList();
	private DatabaseManager dm;

	private static OnListaSelectAgenda_pendiente onListaSelectAgenda_pendiente;
	private Gson gson= new Gson();
	private Agenda_pendienteList agenda_pendienteList= new Agenda_pendienteList();

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.ppal_list, container,
				false);
		return rootView;
	}
	 @Override
	  public void onActivityCreated(Bundle state) {
	        super.onActivityCreated(state);
			String token= Util.SpGet(getActivity(),Configuracion.BIBLIOTECA, Configuracion.getBiblioClaveApi(),"");
	     	Util.Log("token=>"+token);
		 verLista();
		 requestAgendaPendiente();

	 }
	 public void verLista(){
		 dm= new DatabaseManager(getActivity());
		 list.datos=dm.getAgenda_pendientes();
		 if(list.datos!= null && list.datos.size()>0){
			 adapter2=new Agenda_pendienteListAdapter(getActivity(),R.layout.usuario_list_item,  list.datos);
			 lista=(ListView)getActivity().findViewById(R.id.ppal_list_id);
			 lista.setAdapter(adapter2);
			 lista.setOnItemClickListener(new OnItemClickListener() {
				 @Override
				 public void onItemClick(AdapterView<?> parent, View view,
										 int position, long id) {

					 Agenda_pendienteListFrag.onListaSelectAgenda_pendiente.onClickList(list.datos.get(position));
				 }


			 });
		 }

	 }
	 public void setFiltro(String arg0) {
			// TODO Auto-generated method stub
			Util.Log("arg0=>"+arg0);

			adapter2.filter(arg0);
		}
	 public  interface OnListaSelectAgenda_pendiente  {
		    // you can define any parameter as per your requirement
			void onClickList(Agenda_pendiente er);
	}
	public  OnListaSelectAgenda_pendiente getOnListaSelectAgenda_pendiente() {
		return onListaSelectAgenda_pendiente;
	}
	public  void setOnListaSelectAgenda_pendiente(
			OnListaSelectAgenda_pendiente onListaSelectAgenda_pendiente) {
		Agenda_pendienteListFrag.onListaSelectAgenda_pendiente = onListaSelectAgenda_pendiente;
	}
	public void requestAgendaPendiente() {
		Util.Log("Actualizando....");
		String url= Configuracion.getAuthorization();
		Util.Log("API=>" + Configuracion.getToken(getActivity()));
		RequestQueue queue = newRequestQueue(getActivity());
		Util.Log("url=>" + url);
		Util.Log("url-api=>" + Configuracion.getToken(getActivity()));

		StringRequest postRequest = new StringRequest(Request.Method.GET, url,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						// response
						Util.Log("response=>(url)" + response);
						try {
							agenda_pendienteList = gson.fromJson(response, Agenda_pendienteList.class);
						} catch (JsonSyntaxException e) {
							// TODO Auto-generated catch block
							Util.Log("error=>" + e.getMessage());
						}
						Util.Log("cant usuario=>" + agenda_pendienteList.datos.size());
						dm.setOTaddList(agenda_pendienteList.datos);
						/*
						otlist.actualizar();
						dm.setOTaddList(otlist.datos);
						//progress.dismiss();*/
						verLista();

					}
				},
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						Util.Log("error=>"+error.getMessage());
						//SyncError.ERROR_DISPLAY(error, getActivity());
						//progress.dismiss();

					}
				}

		) {
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				//ba4d1a5f35f8cf5600a74fa4e80a6fff

				Map<String, String> params = new HashMap<String, String>();
				params.put("Authorization", Configuracion.getToken(getActivity()));
				/* params.put("Usuario", "1");
				 */
				return params;
			}


		};
		queue.add(postRequest);

	}

}
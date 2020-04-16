package com.e.agenda.db;

import com.e.agenda.db.dao.Agenda_autorizadaDAO;
import com.e.agenda.db.dao.Agenda_borrarDAO;
import com.e.agenda.db.dao.Agenda_pendienteDAO;
import com.e.agenda.db.dao.Agenda_pendiente_historialDAO;
import com.e.agenda.db.dao.NotificacionesDAO;
import com.e.agenda.db.dao.TblregistrationDAO;
import com.e.agenda.db.dao.Tipo_accionesDAO;
import com.e.agenda.db.dao.UsuarioDAO;
import com.e.agenda.db.dao.Usuario_accionesDAO;

import com.e.agenda.model.Agenda_autorizada;
import com.e.agenda.model.Agenda_borrar;
import com.e.agenda.model.Agenda_pendiente;
import com.e.agenda.model.Agenda_pendiente_historial;
import com.e.agenda.model.Notificaciones;
import com.e.agenda.model.Tblregistration;
import com.e.agenda.model.Tipo_acciones;
import com.e.agenda.model.Usuario;
import com.e.agenda.model.Usuario_acciones;



import com.e.agenda.utils.Util;
import com.e.agenda.model.Agenda_pendiente;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DatabaseManager {

	private Context context;
	private SQLiteDatabase db;
	private OpenHelper openHelper;
	Agenda_autorizadaDAO agenda_autorizadaDAO;
Agenda_borrarDAO agenda_borrarDAO;
Agenda_pendienteDAO agenda_pendienteDAO;
Agenda_pendiente_historialDAO agenda_pendiente_historialDAO;
NotificacionesDAO notificacionesDAO;
TblregistrationDAO tblregistrationDAO;
Tipo_accionesDAO tipo_accionesDAO;
UsuarioDAO usuarioDAO;
Usuario_accionesDAO usuario_accionesDAO;



	public DatabaseManager(Context context) {
		this.context = context;
		openHelper = new OpenHelper(this.context);
		db = openHelper.getWritableDatabase();
        agenda_autorizadaDAO = new Agenda_autorizadaDAO(db);
agenda_borrarDAO = new Agenda_borrarDAO(db);
agenda_pendienteDAO = new Agenda_pendienteDAO(db);
agenda_pendiente_historialDAO = new Agenda_pendiente_historialDAO(db);
notificacionesDAO = new NotificacionesDAO(db);
tblregistrationDAO = new TblregistrationDAO(db);
tipo_accionesDAO = new Tipo_accionesDAO(db);
usuarioDAO = new UsuarioDAO(db);
usuario_accionesDAO = new Usuario_accionesDAO(db);



	}
	public  void loadContentExt(){
		//((OpenHelper) openHelper).loadContentExt();

	}

	public SQLiteDatabase gedDb() {
		return db;
	}

	public Usuario getUsuario(long id) {
		Usuario res = usuarioDAO.get(id);
		return res;
	}

	public List<Agenda_pendiente> getAgenda_pendientes() {
		List<Agenda_pendiente> features = new ArrayList<Agenda_pendiente>();
		features = null;
		Agenda_pendiente[] ap= agenda_pendienteDAO.get("", null);
		if(ap!=null)
			features = Arrays.asList(ap);
		return features;

	}
    public void setOTaddList(List<Agenda_pendiente> datos) {
        // TODO Auto-generated method stub
        //delete_table(OtTable.TABLE_NAME);
        for (int i = 0; i < datos.size(); i++) {
            Agenda_pendiente o = datos.get(i);
            agenda_pendienteDAO.insert2(o);

        }

    }

}

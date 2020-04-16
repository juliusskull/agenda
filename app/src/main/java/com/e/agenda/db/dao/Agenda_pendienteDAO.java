package com.e.agenda.db.dao;

import java.lang.reflect.Field;
import java.util.Locale;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.provider.BaseColumns;

import com.e.agenda.db.tables.Agenda_pendienteTable;
import com.e.agenda.db.tables.Agenda_pendienteTable.Agenda_pendienteColumns;
import com.e.agenda.model.Agenda_pendiente;
import com.e.agenda.utils.Util;


public class Agenda_pendienteDAO extends DAOBase implements DAO<Agenda_pendiente>{

	private static final String INSERT = "insert into "
			+ Agenda_pendienteTable.TABLE_NAME + "(" + Agenda_pendienteColumns._ID
		    + ", "+ Agenda_pendienteColumns.IDPROCESO
+ ", "+ Agenda_pendienteColumns.CATEGORIA
+ ", "+ Agenda_pendienteColumns.IDSUBCATEGORIA
+ ", "+ Agenda_pendienteColumns.SUBCATEGORIA
+ ", "+ Agenda_pendienteColumns.LEGAJO
+ ", "+ Agenda_pendienteColumns.NUMERO
+ ", "+ Agenda_pendienteColumns.IDGESP
+ ", "+ Agenda_pendienteColumns.TITULO
+ ", "+ Agenda_pendienteColumns.FCHINGRESO
+ ", "+ Agenda_pendienteColumns.FCHGESTION
+ ", "+ Agenda_pendienteColumns.FCHDESDE
+ ", "+ Agenda_pendienteColumns.FCHHASTA
+ ", "+ Agenda_pendienteColumns.UNIDADMEDIDA
+ ", "+ Agenda_pendienteColumns.MONTO
+ ", "+ Agenda_pendienteColumns.OBSERVACION
+ ", "+ Agenda_pendienteColumns.IDGERENCIA
+ ", "+ Agenda_pendienteColumns.GERENCIA
+ ", "+ Agenda_pendienteColumns.AUTORIZA
+ ", "+ Agenda_pendienteColumns.FCHALTA

			+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private SQLiteDatabase db;
	private SQLiteStatement insertStatement;

	public Agenda_pendienteDAO(SQLiteDatabase db) {
		this.db = db;
		try {
		    insertStatement = db.compileStatement(Agenda_pendienteDAO.INSERT);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Agenda_pendienteTable.onCreate(db, null);
			insertStatement = db.compileStatement(Agenda_pendienteDAO.INSERT);
			e.printStackTrace();
		}
	}
public long insert2(Agenda_pendiente obj) {
		//insertStatement.clearBindings();

		String INSERT2="";
		String INSERT2_P="";
		Field[] fields = Agenda_pendiente.class.getDeclaredFields();
		String[] s= new String[fields.length+1];
		int i=0;
		for( Field field : fields ){
			try {
				if (!field.getName().contains("$change") && !field.getName().contains("serialVersionUID")) {

					if (i > 0) {
						INSERT2 += ",";
						INSERT2_P += ",";
					}
					INSERT2 += field.getName().toString();
					INSERT2_P += "?";
				}
				 i++;

			}catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//-----------------
		INSERT2="insert into "+ Agenda_pendienteTable.TABLE_NAME +"("+INSERT2+")VALUES("+INSERT2_P+")";
		SQLiteStatement insertStatement2 = db.compileStatement(INSERT2);
		insertStatement2.clearBindings();

		i=0;
		for( Field field : fields ){
			try {
				if (!field.getName().contains("$change") && !field.getName().contains("serialVersionUID")) {

					field.setAccessible(true);
					Util.Log("field:" + field.getName().toString() + ":" + field.getType().getName());
					Util.Log("field->:" + field.get(obj));
					i++;
					if (field.getType().getName().contains("int") || field.getType().getName().contains("long")) {

						insertStatement2.bindLong(i, Long.valueOf(String.valueOf(field.get(obj))));

					} else {
						insertStatement2.bindString(i, String.valueOf(field.get(obj)));
					}
				}
				} catch (IllegalAccessException e) {

				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		Util.Log("INSERT2=>:"+INSERT2);
		return insertStatement2.executeInsert();

	}


	@Override
	public long insert(String[] data) {
		insertStatement.clearBindings();
		insertStatement.bindLong(1, Long.valueOf(data[0]));
		insertStatement.bindLong(2,  Long.valueOf(data[1]));
insertStatement.bindString(3, data[2]);
insertStatement.bindLong(4,  Long.valueOf(data[3]));
insertStatement.bindString(5, data[4]);
insertStatement.bindLong(6,  Long.valueOf(data[5]));
insertStatement.bindLong(7,  Long.valueOf(data[6]));
insertStatement.bindLong(8,  Long.valueOf(data[7]));
insertStatement.bindString(9, data[8]);
insertStatement.bindString(10, data[9]);
insertStatement.bindString(11, data[10]);
insertStatement.bindString(12, data[11]);
insertStatement.bindString(13, data[12]);
insertStatement.bindString(14, data[13]);
insertStatement.bindString(15, data[14]);
insertStatement.bindString(16, data[15]);
insertStatement.bindLong(17,  Long.valueOf(data[16]));
insertStatement.bindString(18, data[17]);
insertStatement.bindString(19, data[18]);
insertStatement.bindString(20, data[19]);


		return insertStatement.executeInsert();
	}

	@Override
	public void remove(long id) {
		db.delete(Agenda_pendienteTable.TABLE_NAME, BaseColumns._ID + " = ?",
				new String[] { String.valueOf(id) });

	}

	public Agenda_pendiente getAgenda_pendiente(long id) {
		Agenda_pendiente  place = null;
		String[] columns = Agenda_pendienteColumns.getColumns();
		String language = Locale.getDefault().getLanguage();

		Cursor c = db
				.query(Agenda_pendienteTable.TABLE_NAME, columns, BaseColumns._ID
						+ " = ?", new String[] { String.valueOf(id) }, null,
						null, null);
		if (c.moveToFirst()) {
			place = new Agenda_pendiente();
			place.set_id(c.getLong(0));
             place.setIdproceso((int)c.getLong(1));
 place.setCategoria(c.getString(2));
 place.setIdsubcategoria((int)c.getLong(3));
 place.setSubcategoria(c.getString(4));
 place.setLegajo((int)c.getLong(5));
 place.setNumero((int)c.getLong(6));
 place.setIdgesp((int)c.getLong(7));
 place.setTitulo(c.getString(8));
 place.setFchingreso(c.getString(9));
 place.setFchgestion(c.getString(10));
 place.setFchdesde(c.getString(11));
 place.setFchhasta(c.getString(12));
 place.setUnidadmedida(c.getString(13));
 place.setMonto(c.getString(14));
 place.setObservacion(c.getString(15));
 place.setIdgerencia((int)c.getLong(16));
 place.setGerencia(c.getString(17));
 place.setAutoriza(c.getString(18));
 place.setFchalta(c.getString(19));


		}
		if (!c.isClosed()) {
			c.close();
		}
		return place;
	}


	public Agenda_pendiente[] get(String condition, String[] params) {
		Agenda_pendiente[] Agenda_pendiente = null;
		String[] columns = Agenda_pendienteColumns.getColumns();
		String language = Locale.getDefault().getLanguage();

		Cursor c = db.query(Agenda_pendienteTable.TABLE_NAME, columns, condition,
				params, null, null, null);
		if (c.getCount() == 0) {
			c.close();
			return null;
		}
		if (c.moveToFirst()) {
			Agenda_pendiente = new Agenda_pendiente[c.getCount()];
			for (int i = 0; i < c.getCount(); i++) {
				Agenda_pendiente[i] = new Agenda_pendiente();
				Agenda_pendiente place = new Agenda_pendiente();
				place.set_id(c.getLong(0));
				  place.setIdproceso((int)c.getLong(1));
 place.setCategoria(c.getString(2));
 place.setIdsubcategoria((int)c.getLong(3));
 place.setSubcategoria(c.getString(4));
 place.setLegajo((int)c.getLong(5));
 place.setNumero((int)c.getLong(6));
 place.setIdgesp((int)c.getLong(7));
 place.setTitulo(c.getString(8));
 place.setFchingreso(c.getString(9));
 place.setFchgestion(c.getString(10));
 place.setFchdesde(c.getString(11));
 place.setFchhasta(c.getString(12));
 place.setUnidadmedida(c.getString(13));
 place.setMonto(c.getString(14));
 place.setObservacion(c.getString(15));
 place.setIdgerencia((int)c.getLong(16));
 place.setGerencia(c.getString(17));
 place.setAutoriza(c.getString(18));
 place.setFchalta(c.getString(19));


				Agenda_pendiente[i] = place;

				c.moveToNext();
			}
		}
		if (!c.isClosed()) {
			c.close();
		}
		return Agenda_pendiente;
	}
	@Override
	public Agenda_pendiente get(long id) {

		Agenda_pendiente[] agenda_pendiente = get(BaseColumns._ID + " = ?",
				new String[] { String.valueOf(id) });
		if (agenda_pendiente == null)
			return null;

		return agenda_pendiente[0];
	}




	@Override
	public Agenda_pendiente[] getAll() {
		return null;
	}



}

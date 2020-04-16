package com.e.agenda.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.e.agenda.db.tables.Agenda_autorizadaTable;
import com.e.agenda.db.tables.Agenda_borrarTable;
import com.e.agenda.db.tables.Agenda_pendienteTable;
import com.e.agenda.db.tables.Agenda_pendiente_historialTable;
import com.e.agenda.db.tables.NotificacionesTable;
import com.e.agenda.db.tables.TblregistrationTable;
import com.e.agenda.db.tables.Tipo_accionesTable;
import com.e.agenda.db.tables.UsuarioTable;
import com.e.agenda.db.tables.Usuario_accionesTable;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;




public class OpenHelper extends SQLiteOpenHelper {


	private static final int DATABASE_VERSION = 1;
	private Context context;


	public OpenHelper(final Context context) {
		super(context, "ordenes", null, DATABASE_VERSION);
		this.context = context;
	}
	public void onOpen(final SQLiteDatabase db) {
		super.onOpen(db);
		if (!db.isReadOnly()) {
			db.execSQL("PRAGMA foreign_keys=ON;");
			Cursor c = db.rawQuery("PRAGMA foreign_keys", null);
			if (c.moveToFirst()) {
				c.getInt(0);
			} else {
			}
			if (!c.isClosed()) {
				c.close();
			}
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.v("(SQL)", "ini script");
		Agenda_autorizadaTable.onCreate(db, context);
Agenda_borrarTable.onCreate(db, context);
Agenda_pendienteTable.onCreate(db, context);
Agenda_pendiente_historialTable.onCreate(db, context);
NotificacionesTable.onCreate(db, context);
TblregistrationTable.onCreate(db, context);
Tipo_accionesTable.onCreate(db, context);
UsuarioTable.onCreate(db, context);
Usuario_accionesTable.onCreate(db, context);


	}

	@Override
	public void onUpgrade(final SQLiteDatabase db, final int oldVersion,
			final int newVersion) {
		Agenda_autorizadaTable.onUpgrade(db, oldVersion, newVersion, context);
Agenda_borrarTable.onUpgrade(db, oldVersion, newVersion, context);
Agenda_pendienteTable.onUpgrade(db, oldVersion, newVersion, context);
Agenda_pendiente_historialTable.onUpgrade(db, oldVersion, newVersion, context);
NotificacionesTable.onUpgrade(db, oldVersion, newVersion, context);
TblregistrationTable.onUpgrade(db, oldVersion, newVersion, context);
Tipo_accionesTable.onUpgrade(db, oldVersion, newVersion, context);
UsuarioTable.onUpgrade(db, oldVersion, newVersion, context);
Usuario_accionesTable.onUpgrade(db, oldVersion, newVersion, context);


	}




}
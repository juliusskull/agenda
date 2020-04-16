package com.e.agenda.db.tables;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class Agenda_autorizadaTable {
public static final String TABLE_NAME = "agenda_autorizada";

public static class Agenda_autorizadaColumns implements BaseColumns {
public static final String ID="id";
public static final String IDPROCESO="idproceso";
public static final String FECHAAUTORIZA="fechaautoriza";
public static final String FECHACAD="fechacad";
public static final String OBSERVACION="observacion";
public static final String FCHREGISTRACION="fchregistracion";
public static final String IDACCION="idaccion";
public static final String CATEGORIA="categoria";

public static  String[] getColumns(){
return new String[] {  _ID,ID,IDPROCESO,FECHAAUTORIZA,FECHACAD,OBSERVACION,FCHREGISTRACION,IDACCION,CATEGORIA};


		}

	}


	public static void onCreate(SQLiteDatabase db, Context context) {
    StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLE_NAME + " (");
		sb.append(BaseColumns._ID + " INTEGER PRIMARY KEY, ");
		sb.append(Agenda_autorizadaColumns.ID + " INTEGER , ");
sb.append(Agenda_autorizadaColumns.IDPROCESO + " INTEGER , ");
sb.append(Agenda_autorizadaColumns.FECHAAUTORIZA + " TEXT , ");
sb.append(Agenda_autorizadaColumns.FECHACAD + " TEXT , ");
sb.append(Agenda_autorizadaColumns.OBSERVACION + " TEXT , ");
sb.append(Agenda_autorizadaColumns.FCHREGISTRACION + " TEXT , ");
sb.append(Agenda_autorizadaColumns.IDACCION + " INTEGER , ");
sb.append(Agenda_autorizadaColumns.CATEGORIA + " TEXT  ");


		sb.append(");");
		db.execSQL(sb.toString());
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion, Context context) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db, context);
}
	public static void onUpgrade2(SQLiteDatabase db, Context context) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db, context);
}
}
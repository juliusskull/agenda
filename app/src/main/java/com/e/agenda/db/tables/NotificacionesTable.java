package com.e.agenda.db.tables;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class NotificacionesTable {
public static final String TABLE_NAME = "notificaciones";

public static class NotificacionesColumns implements BaseColumns {
public static final String ID="id";
public static final String IDPROCESO="idproceso";
public static final String FECHAALTA="fechaalta";
public static final String FECHAAUTORIZA="fechaautoriza";
public static final String IDUSUARIOAUTORIZA="idusuarioautoriza";
public static final String IDPROCESOAUTORIZA="idprocesoautoriza";
public static final String OBSERVACION="observacion";
public static final String LEGAJO="legajo";

public static  String[] getColumns(){
return new String[] {  _ID,ID,IDPROCESO,FECHAALTA,FECHAAUTORIZA,IDUSUARIOAUTORIZA,IDPROCESOAUTORIZA,OBSERVACION,LEGAJO};


		}

	}


	public static void onCreate(SQLiteDatabase db, Context context) {
    StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLE_NAME + " (");
		sb.append(BaseColumns._ID + " INTEGER PRIMARY KEY, ");
		sb.append(NotificacionesColumns.ID + " INTEGER , ");
sb.append(NotificacionesColumns.IDPROCESO + " INTEGER , ");
sb.append(NotificacionesColumns.FECHAALTA + " TEXT , ");
sb.append(NotificacionesColumns.FECHAAUTORIZA + " TEXT , ");
sb.append(NotificacionesColumns.IDUSUARIOAUTORIZA + " TEXT , ");
sb.append(NotificacionesColumns.IDPROCESOAUTORIZA + " INTEGER , ");
sb.append(NotificacionesColumns.OBSERVACION + " TEXT , ");
sb.append(NotificacionesColumns.LEGAJO + " INTEGER  ");


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
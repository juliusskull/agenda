package com.e.agenda.db.tables;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class Tipo_accionesTable {
public static final String TABLE_NAME = "tipo_acciones";

public static class Tipo_accionesColumns implements BaseColumns {
public static final String CATEGORIA="categoria";
public static final String ID_ACCION="id_accion";
public static final String DESCRIPCION="descripcion";

public static  String[] getColumns(){
return new String[] {  _ID,CATEGORIA,ID_ACCION,DESCRIPCION};


		}

	}


	public static void onCreate(SQLiteDatabase db, Context context) {
    StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLE_NAME + " (");
		sb.append(BaseColumns._ID + " INTEGER PRIMARY KEY, ");
		sb.append(Tipo_accionesColumns.CATEGORIA + " TEXT , ");
sb.append(Tipo_accionesColumns.ID_ACCION + " INTEGER , ");
sb.append(Tipo_accionesColumns.DESCRIPCION + " TEXT  ");


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
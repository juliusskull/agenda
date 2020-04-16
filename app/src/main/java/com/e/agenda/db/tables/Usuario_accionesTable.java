package com.e.agenda.db.tables;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class Usuario_accionesTable {
public static final String TABLE_NAME = "usuario_acciones";

public static class Usuario_accionesColumns implements BaseColumns {
public static final String ID="id";
public static final String LEGAJO="legajo";
public static final String DESCRIPCION="descripcion";
public static final String APLICACION="aplicacion";
public static final String VERSION="version";
public static final String FCHALTA="fchalta";

public static  String[] getColumns(){
return new String[] {  _ID,ID,LEGAJO,DESCRIPCION,APLICACION,VERSION,FCHALTA};


		}

	}


	public static void onCreate(SQLiteDatabase db, Context context) {
    StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLE_NAME + " (");
		sb.append(BaseColumns._ID + " INTEGER PRIMARY KEY, ");
		sb.append(Usuario_accionesColumns.ID + " INTEGER , ");
sb.append(Usuario_accionesColumns.LEGAJO + " INTEGER , ");
sb.append(Usuario_accionesColumns.DESCRIPCION + " TEXT , ");
sb.append(Usuario_accionesColumns.APLICACION + " TEXT , ");
sb.append(Usuario_accionesColumns.VERSION + " TEXT , ");
sb.append(Usuario_accionesColumns.FCHALTA + " TEXT  ");


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
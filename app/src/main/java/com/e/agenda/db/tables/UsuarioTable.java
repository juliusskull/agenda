package com.e.agenda.db.tables;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class UsuarioTable {
public static final String TABLE_NAME = "usuario";

public static class UsuarioColumns implements BaseColumns {
public static final String IDUSUARIO="idUsuario";
public static final String NOMBRE="nombre";
public static final String CONTRASENA="contrasena";
public static final String CLAVEAPI="claveApi";
public static final String CORREO="correo";
public static final String LEGAJO="legajo";
public static final String IMEI="imei";
public static final String PROVISORIA="provisoria";

public static  String[] getColumns(){
return new String[] {  _ID,IDUSUARIO,NOMBRE,CONTRASENA,CLAVEAPI,CORREO,LEGAJO,IMEI,PROVISORIA};


		}

	}


	public static void onCreate(SQLiteDatabase db, Context context) {
    StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLE_NAME + " (");
		sb.append(BaseColumns._ID + " INTEGER PRIMARY KEY, ");
		sb.append(UsuarioColumns.IDUSUARIO + " INTEGER , ");
sb.append(UsuarioColumns.NOMBRE + " TEXT , ");
sb.append(UsuarioColumns.CONTRASENA + " TEXT , ");
sb.append(UsuarioColumns.CLAVEAPI + " TEXT , ");
sb.append(UsuarioColumns.CORREO + " TEXT , ");
sb.append(UsuarioColumns.LEGAJO + " INTEGER , ");
sb.append(UsuarioColumns.IMEI + " TEXT , ");
sb.append(UsuarioColumns.PROVISORIA + " TEXT  ");


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
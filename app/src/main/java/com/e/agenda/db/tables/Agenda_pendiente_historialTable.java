package com.e.agenda.db.tables;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class Agenda_pendiente_historialTable {
public static final String TABLE_NAME = "agenda_pendiente_historial";

public static class Agenda_pendiente_historialColumns implements BaseColumns {
public static final String ID="id";
public static final String IDPROCESO="idproceso";
public static final String CATEGORIA="categoria";
public static final String IDSUBCATEGORIA="idsubcategoria";
public static final String SUBCATEGORIA="subcategoria";
public static final String IDGESP="idgesp";
public static final String LEGAJO="legajo";
public static final String NUMERO="numero";
public static final String TITULO="titulo";
public static final String FCHINGRESO="fchingreso";
public static final String FCHGESTION="fchgestion";
public static final String FCHDESDE="fchdesde";
public static final String FCHHASTA="fchhasta";
public static final String UNIDADMEDIDA="unidadmedida";
public static final String MONTO="monto";
public static final String OBSERVACION="observacion";
public static final String IDGERENCIA="idgerencia";
public static final String GERENCIA="gerencia";
public static final String AUTORIZA="autoriza";
public static final String FCHREGISTRACION="fchregistracion";

public static  String[] getColumns(){
return new String[] {  _ID,ID,IDPROCESO,CATEGORIA,IDSUBCATEGORIA,SUBCATEGORIA,IDGESP,LEGAJO,NUMERO,TITULO,FCHINGRESO,FCHGESTION,FCHDESDE,FCHHASTA,UNIDADMEDIDA,MONTO,OBSERVACION,IDGERENCIA,GERENCIA,AUTORIZA,FCHREGISTRACION};


		}

	}


	public static void onCreate(SQLiteDatabase db, Context context) {
    StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLE_NAME + " (");
		sb.append(BaseColumns._ID + " INTEGER PRIMARY KEY, ");
		sb.append(Agenda_pendiente_historialColumns.ID + " INTEGER , ");
sb.append(Agenda_pendiente_historialColumns.IDPROCESO + " INTEGER , ");
sb.append(Agenda_pendiente_historialColumns.CATEGORIA + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.IDSUBCATEGORIA + " INTEGER , ");
sb.append(Agenda_pendiente_historialColumns.SUBCATEGORIA + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.IDGESP + " INTEGER , ");
sb.append(Agenda_pendiente_historialColumns.LEGAJO + " INTEGER , ");
sb.append(Agenda_pendiente_historialColumns.NUMERO + " INTEGER , ");
sb.append(Agenda_pendiente_historialColumns.TITULO + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.FCHINGRESO + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.FCHGESTION + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.FCHDESDE + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.FCHHASTA + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.UNIDADMEDIDA + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.MONTO + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.OBSERVACION + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.IDGERENCIA + " INTEGER , ");
sb.append(Agenda_pendiente_historialColumns.GERENCIA + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.AUTORIZA + " TEXT , ");
sb.append(Agenda_pendiente_historialColumns.FCHREGISTRACION + " TEXT  ");


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
package com.e.agenda.db.tables;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class Agenda_pendienteTable {
public static final String TABLE_NAME = "agenda_pendiente";

public static class Agenda_pendienteColumns implements BaseColumns {
public static final String IDPROCESO="idproceso";
public static final String CATEGORIA="categoria";
public static final String IDSUBCATEGORIA="idsubcategoria";
public static final String SUBCATEGORIA="subcategoria";
public static final String LEGAJO="legajo";
public static final String NUMERO="numero";
public static final String IDGESP="idgesp";
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
public static final String FCHALTA="fchalta";

public static  String[] getColumns(){
return new String[] {  _ID,IDPROCESO,CATEGORIA,IDSUBCATEGORIA,SUBCATEGORIA,LEGAJO,NUMERO,IDGESP,TITULO,FCHINGRESO,FCHGESTION,FCHDESDE,FCHHASTA,UNIDADMEDIDA,MONTO,OBSERVACION,IDGERENCIA,GERENCIA,AUTORIZA,FCHALTA};


		}

	}


	public static void onCreate(SQLiteDatabase db, Context context) {
    StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLE_NAME + " (");
		sb.append(BaseColumns._ID + " INTEGER PRIMARY KEY, ");
		sb.append(Agenda_pendienteColumns.IDPROCESO + " INTEGER , ");
sb.append(Agenda_pendienteColumns.CATEGORIA + " TEXT , ");
sb.append(Agenda_pendienteColumns.IDSUBCATEGORIA + " INTEGER , ");
sb.append(Agenda_pendienteColumns.SUBCATEGORIA + " TEXT , ");
sb.append(Agenda_pendienteColumns.LEGAJO + " INTEGER , ");
sb.append(Agenda_pendienteColumns.NUMERO + " INTEGER , ");
sb.append(Agenda_pendienteColumns.IDGESP + " INTEGER , ");
sb.append(Agenda_pendienteColumns.TITULO + " TEXT , ");
sb.append(Agenda_pendienteColumns.FCHINGRESO + " TEXT , ");
sb.append(Agenda_pendienteColumns.FCHGESTION + " TEXT , ");
sb.append(Agenda_pendienteColumns.FCHDESDE + " TEXT , ");
sb.append(Agenda_pendienteColumns.FCHHASTA + " TEXT , ");
sb.append(Agenda_pendienteColumns.UNIDADMEDIDA + " TEXT , ");
sb.append(Agenda_pendienteColumns.MONTO + " TEXT , ");
sb.append(Agenda_pendienteColumns.OBSERVACION + " TEXT , ");
sb.append(Agenda_pendienteColumns.IDGERENCIA + " INTEGER , ");
sb.append(Agenda_pendienteColumns.GERENCIA + " TEXT , ");
sb.append(Agenda_pendienteColumns.AUTORIZA + " TEXT , ");
sb.append(Agenda_pendienteColumns.FCHALTA + " TEXT  ");


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
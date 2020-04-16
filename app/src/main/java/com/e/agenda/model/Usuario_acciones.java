package com.e.agenda.model;

public class Usuario_acciones extends Base{
     int id;
  int legajo;
  String descripcion;
  String aplicacion;
  String version;
  String fchalta;

	public Usuario_acciones() {
		super();

	}
	public Usuario_acciones( int id, int legajo, String descripcion, String aplicacion, String version, String fchalta) {
		super();
	this.id = id;
this.legajo = legajo;
this.descripcion = descripcion;
this.aplicacion = aplicacion;
this.version = version;
this.fchalta = fchalta;

	}
	
            public int getId() {
		        return id;
	        }
	        public void setId(int id) {
                this.id = id;
            }
            public int getLegajo() {
		        return legajo;
	        }
	        public void setLegajo(int legajo) {
                this.legajo = legajo;
            }
            public String getDescripcion() {
		        return descripcion;
	        }
	        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
            }
            public String getAplicacion() {
		        return aplicacion;
	        }
	        public void setAplicacion(String aplicacion) {
                this.aplicacion = aplicacion;
            }
            public String getVersion() {
		        return version;
	        }
	        public void setVersion(String version) {
                this.version = version;
            }
            public String getFchalta() {
		        return fchalta;
	        }
	        public void setFchalta(String fchalta) {
                this.fchalta = fchalta;
            }

}
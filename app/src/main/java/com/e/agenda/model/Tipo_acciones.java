package com.e.agenda.model;

public class Tipo_acciones extends Base{
     String categoria;
  int id_accion;
  String descripcion;

	public Tipo_acciones() {
		super();

	}
	public Tipo_acciones( String categoria, int id_accion, String descripcion) {
		super();
	this.categoria = categoria;
this.id_accion = id_accion;
this.descripcion = descripcion;

	}
	
            public String getCategoria() {
		        return categoria;
	        }
	        public void setCategoria(String categoria) {
                this.categoria = categoria;
            }
            public int getId_accion() {
		        return id_accion;
	        }
	        public void setId_accion(int id_accion) {
                this.id_accion = id_accion;
            }
            public String getDescripcion() {
		        return descripcion;
	        }
	        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
            }

}
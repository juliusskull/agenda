package com.e.agenda.model;

public class Agenda_autorizada extends Base{
     int id;
  int idproceso;
  String fechaautoriza;
  String fechacad;
  String observacion;
  String fchregistracion;
  int idaccion;
  String categoria;

	public Agenda_autorizada() {
		super();

	}
	public Agenda_autorizada( int id, int idproceso, String fechaautoriza, String fechacad, String observacion, String fchregistracion, int idaccion, String categoria) {
		super();
	this.id = id;
this.idproceso = idproceso;
this.fechaautoriza = fechaautoriza;
this.fechacad = fechacad;
this.observacion = observacion;
this.fchregistracion = fchregistracion;
this.idaccion = idaccion;
this.categoria = categoria;

	}
	
            public int getId() {
		        return id;
	        }
	        public void setId(int id) {
                this.id = id;
            }
            public int getIdproceso() {
		        return idproceso;
	        }
	        public void setIdproceso(int idproceso) {
                this.idproceso = idproceso;
            }
            public String getFechaautoriza() {
		        return fechaautoriza;
	        }
	        public void setFechaautoriza(String fechaautoriza) {
                this.fechaautoriza = fechaautoriza;
            }
            public String getFechacad() {
		        return fechacad;
	        }
	        public void setFechacad(String fechacad) {
                this.fechacad = fechacad;
            }
            public String getObservacion() {
		        return observacion;
	        }
	        public void setObservacion(String observacion) {
                this.observacion = observacion;
            }
            public String getFchregistracion() {
		        return fchregistracion;
	        }
	        public void setFchregistracion(String fchregistracion) {
                this.fchregistracion = fchregistracion;
            }
            public int getIdaccion() {
		        return idaccion;
	        }
	        public void setIdaccion(int idaccion) {
                this.idaccion = idaccion;
            }
            public String getCategoria() {
		        return categoria;
	        }
	        public void setCategoria(String categoria) {
                this.categoria = categoria;
            }

}
package com.e.agenda.model;

public class Notificaciones extends Base{
     int id;
  long idproceso;
  String fechaalta;
  String fechaautoriza;
  String idusuarioautoriza;
  long idprocesoautoriza;
  String observacion;
  long legajo;

	public Notificaciones() {
		super();

	}
	public Notificaciones( int id, int idproceso, String fechaalta, String fechaautoriza, String idusuarioautoriza, int idprocesoautoriza, String observacion, int legajo) {
		super();
	this.id = id;
this.idproceso = idproceso;
this.fechaalta = fechaalta;
this.fechaautoriza = fechaautoriza;
this.idusuarioautoriza = idusuarioautoriza;
this.idprocesoautoriza = idprocesoautoriza;
this.observacion = observacion;
this.legajo = legajo;

	}
	
            public int getId() {
		        return id;
	        }
	        public void setId(int id) {
                this.id = id;
            }
            public long getIdproceso() {
		        return idproceso;
	        }
	        public void setIdproceso(long idproceso) {
                this.idproceso = idproceso;
            }
            public String getFechaalta() {
		        return fechaalta;
	        }
	        public void setFechaalta(String fechaalta) {
                this.fechaalta = fechaalta;
            }
            public String getFechaautoriza() {
		        return fechaautoriza;
	        }
	        public void setFechaautoriza(String fechaautoriza) {
                this.fechaautoriza = fechaautoriza;
            }
            public String getIdusuarioautoriza() {
		        return idusuarioautoriza;
	        }
	        public void setIdusuarioautoriza(String idusuarioautoriza) {
                this.idusuarioautoriza = idusuarioautoriza;
            }
            public long getIdprocesoautoriza() {
		        return idprocesoautoriza;
	        }
	        public void setIdprocesoautoriza(long idprocesoautoriza) {
                this.idprocesoautoriza = idprocesoautoriza;
            }
            public String getObservacion() {
		        return observacion;
	        }
	        public void setObservacion(String observacion) {
                this.observacion = observacion;
            }
            public long getLegajo() {
		        return legajo;
	        }
	        public void setLegajo(long legajo) {
                this.legajo = legajo;
            }

}
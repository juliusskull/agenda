package com.e.agenda.model;

public class Agenda_borrar extends Base{
     int idproceso;
  String fchalta;

	public Agenda_borrar() {
		super();

	}
	public Agenda_borrar( int idproceso, String fchalta) {
		super();
	this.idproceso = idproceso;
this.fchalta = fchalta;

	}
	
            public int getIdproceso() {
		        return idproceso;
	        }
	        public void setIdproceso(int idproceso) {
                this.idproceso = idproceso;
            }
            public String getFchalta() {
		        return fchalta;
	        }
	        public void setFchalta(String fchalta) {
                this.fchalta = fchalta;
            }

}
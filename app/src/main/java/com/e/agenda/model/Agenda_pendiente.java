package com.e.agenda.model;

public class Agenda_pendiente extends Base{
     int idproceso;
  String categoria;
  int idsubcategoria;
  String subcategoria;
  int legajo;
  int numero;
  int idgesp;
  String titulo;
  String fchingreso;
  String fchgestion;
  String fchdesde;
  String fchhasta;
  String unidadmedida;
  String monto;
  String observacion;
  int idgerencia;
  String gerencia;
  String autoriza;
  String fchalta;

	public Agenda_pendiente() {
		super();

	}
	public Agenda_pendiente( int idproceso, String categoria, int idsubcategoria, String subcategoria, int legajo, int numero, int idgesp, String titulo, String fchingreso, String fchgestion, String fchdesde, String fchhasta, String unidadmedida, String monto, String observacion, int idgerencia, String gerencia, String autoriza, String fchalta) {
		super();
	this.idproceso = idproceso;
this.categoria = categoria;
this.idsubcategoria = idsubcategoria;
this.subcategoria = subcategoria;
this.legajo = legajo;
this.numero = numero;
this.idgesp = idgesp;
this.titulo = titulo;
this.fchingreso = fchingreso;
this.fchgestion = fchgestion;
this.fchdesde = fchdesde;
this.fchhasta = fchhasta;
this.unidadmedida = unidadmedida;
this.monto = monto;
this.observacion = observacion;
this.idgerencia = idgerencia;
this.gerencia = gerencia;
this.autoriza = autoriza;
this.fchalta = fchalta;

	}
	
            public int getIdproceso() {
		        return idproceso;
	        }
	        public void setIdproceso(int idproceso) {
                this.idproceso = idproceso;
            }
            public String getCategoria() {
		        return categoria;
	        }
	        public void setCategoria(String categoria) {
                this.categoria = categoria;
            }
            public int getIdsubcategoria() {
		        return idsubcategoria;
	        }
	        public void setIdsubcategoria(int idsubcategoria) {
                this.idsubcategoria = idsubcategoria;
            }
            public String getSubcategoria() {
		        return subcategoria;
	        }
	        public void setSubcategoria(String subcategoria) {
                this.subcategoria = subcategoria;
            }
            public int getLegajo() {
		        return legajo;
	        }
	        public void setLegajo(int legajo) {
                this.legajo = legajo;
            }
            public int getNumero() {
		        return numero;
	        }
	        public void setNumero(int numero) {
                this.numero = numero;
            }
            public int getIdgesp() {
		        return idgesp;
	        }
	        public void setIdgesp(int idgesp) {
                this.idgesp = idgesp;
            }
            public String getTitulo() {
		        return titulo;
	        }
	        public void setTitulo(String titulo) {
                this.titulo = titulo;
            }
            public String getFchingreso() {
		        return fchingreso;
	        }
	        public void setFchingreso(String fchingreso) {
                this.fchingreso = fchingreso;
            }
            public String getFchgestion() {
		        return fchgestion;
	        }
	        public void setFchgestion(String fchgestion) {
                this.fchgestion = fchgestion;
            }
            public String getFchdesde() {
		        return fchdesde;
	        }
	        public void setFchdesde(String fchdesde) {
                this.fchdesde = fchdesde;
            }
            public String getFchhasta() {
		        return fchhasta;
	        }
	        public void setFchhasta(String fchhasta) {
                this.fchhasta = fchhasta;
            }
            public String getUnidadmedida() {
		        return unidadmedida;
	        }
	        public void setUnidadmedida(String unidadmedida) {
                this.unidadmedida = unidadmedida;
            }
            public String getMonto() {
		        return monto;
	        }
	        public void setMonto(String monto) {
                this.monto = monto;
            }
            public String getObservacion() {
		        return observacion;
	        }
	        public void setObservacion(String observacion) {
                this.observacion = observacion;
            }
            public int getIdgerencia() {
		        return idgerencia;
	        }
	        public void setIdgerencia(int idgerencia) {
                this.idgerencia = idgerencia;
            }
            public String getGerencia() {
		        return gerencia;
	        }
	        public void setGerencia(String gerencia) {
                this.gerencia = gerencia;
            }
            public String getAutoriza() {
		        return autoriza;
	        }
	        public void setAutoriza(String autoriza) {
                this.autoriza = autoriza;
            }
            public String getFchalta() {
		        return fchalta;
	        }
	        public void setFchalta(String fchalta) {
                this.fchalta = fchalta;
            }

    public String getAgenda_pendiente() {
        return this.titulo;
    }


    public String getDesc_motivo() {

        return this.titulo;
    }
}
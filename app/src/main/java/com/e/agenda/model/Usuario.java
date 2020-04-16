package com.e.agenda.model;

public class Usuario extends Base{
     int idUsuario;
  String nombre;
  String contrasena;
  String claveApi;
  String correo;
  int legajo;
  String imei;
  String provisoria;

	public Usuario() {
		super();

	}
	public Usuario( int idUsuario, String nombre, String contrasena, String claveApi, String correo, int legajo, String imei, String provisoria) {
		super();
	this.idUsuario = idUsuario;
this.nombre = nombre;
this.contrasena = contrasena;
this.claveApi = claveApi;
this.correo = correo;
this.legajo = legajo;
this.imei = imei;
this.provisoria = provisoria;

	}
	
            public int getIdUsuario() {
		        return idUsuario;
	        }
	        public void setIdUsuario(int idUsuario) {
                this.idUsuario = idUsuario;
            }
            public String getNombre() {
		        return nombre;
	        }
	        public void setNombre(String nombre) {
                this.nombre = nombre;
            }
            public String getContrasena() {
		        return contrasena;
	        }
	        public void setContrasena(String contrasena) {
                this.contrasena = contrasena;
            }
            public String getClaveApi() {
		        return claveApi;
	        }
	        public void setClaveApi(String claveApi) {
                this.claveApi = claveApi;
            }
            public String getCorreo() {
		        return correo;
	        }
	        public void setCorreo(String correo) {
                this.correo = correo;
            }
            public int getLegajo() {
		        return legajo;
	        }
	        public void setLegajo(int legajo) {
                this.legajo = legajo;
            }
            public String getImei() {
		        return imei;
	        }
	        public void setImei(String imei) {
                this.imei = imei;
            }
            public String getProvisoria() {
		        return provisoria;
	        }
	        public void setProvisoria(String provisoria) {
                this.provisoria = provisoria;
            }

}
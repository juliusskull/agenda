package com.e.agenda.model;

public class Tblregistration extends Base{
     int id;
  String registration_id;

	public Tblregistration() {
		super();

	}
	public Tblregistration( int id, String registration_id) {
		super();
	this.id = id;
this.registration_id = registration_id;

	}
	
            public int getId() {
		        return id;
	        }
	        public void setId(int id) {
                this.id = id;
            }
            public String getRegistration_id() {
		        return registration_id;
	        }
	        public void setRegistration_id(String registration_id) {
                this.registration_id = registration_id;
            }

}
package com.disieu.applicationMVC.app.modelo.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.MappedSuperclass;

/**
 * 
 *
 *
 * @author Camilo Rivera Fecha: @date
 */
@MappedSuperclass
public class EntidadGenerica implements Serializable {

	private static final long serialVersionUID = 8414724837620832829L;

	private Date fing;

	private Time hing;

	private Date fmod;

	private Time hmod;

	public EntidadGenerica() {
		super();
	}

	public Date getFing() {
		return fing;
	}

	public void setFing(Date fing) {
		this.fing = fing;
	}

	public Time getHing() {
		return hing;
	}

	public void setHing(Time hing) {
		this.hing = hing;
	}

	public Date getFmod() {
		return fmod;
	}

	public void setFmod(Date fmod) {
		this.fmod = fmod;
	}

	public Time getHmod() {
		return hmod;
	}

	public void setHmod(Time hmod) {
		this.hmod = hmod;
	}

}

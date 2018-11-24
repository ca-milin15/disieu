package com.disieu.applicationMVC.app.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.disieu.applicationMVC.app.modelo.dao.RolDAO;
import com.disieu.applicationMVC.app.servicio.ServicioRol;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
public class ServicioRolImpl implements ServicioRol {

	@Autowired
	private RolDAO rolDAO;
}

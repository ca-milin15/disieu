package com.disieu.applicationMVC.app.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disieu.applicationMVC.app.modelo.entidad.Rol;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
public interface RolDAO extends JpaRepository<Rol, Integer> {

}

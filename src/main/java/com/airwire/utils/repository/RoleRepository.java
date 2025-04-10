package com.airwire.utils.repository;

import java.util.List;

import com.airwire.utils.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	List<Role> findAll();

	
	@Query("SELECT u FROM Role u WHERE u.id=:id")
	Role getRoleById(@Param("id") Long id);
	
}
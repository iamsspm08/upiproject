package com.sujitmaity.project.upi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sujitmaity.project.upi.entity.UPIEntity;

public interface UpiDao extends JpaRepository<UPIEntity,String>  {
	

}

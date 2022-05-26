package com.sujitmaity.project.upi.iservice;

import com.sujitmaity.project.upi.entity.UPIEntity;

public interface IUpiService {
	// UPIEntity class name

	UPIEntity getUpiUser(String upiId);

	String CreateUpiDetail(UPIEntity data);

	String UpdateFirstName(UPIEntity data);

	String deleteUpiId(String userId);

	





}
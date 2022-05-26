package com.sujitmaity.project.upi.iservice;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sujitmaity.project.upi.dao.UpiDao;
import com.sujitmaity.project.upi.entity.UPIEntity;
import com.sujitmaity.project.upi.exception.EmailIdInValidException;
import com.sujitmaity.project.upi.exception.PhoneNumberInvalidException;
import com.sujitmaity.project.upi.exception.UpiIdDoesNotExistException;
import com.sujitmaity.project.upi.exception.UpiIdInValidException;
import com.sujitmaity.project.upi.exception.UserIdIsNotPresentException;




@Service
public class ImpUpiService implements IUpiService {
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate; 

	@Autowired
	UpiDao upiDao;

	Logger LOGGER=LoggerFactory.getLogger("ImpUpiService.class");

	@Override
	public UPIEntity getUpiUser(String upiId) {
		LOGGER.info("Retriving User{}",upiId);
		Optional<UPIEntity> upiRecord = upiDao.findById(upiId);
		if(!upiRecord.isPresent()) {
			throw new UpiIdDoesNotExistException("UpiId DoesNot Exist in Database");
		}
		UPIEntity u=upiRecord.get();
		Pattern p= Pattern.compile("^[\\w\\.\\-_]{3,}@[a-zA-Z]{3,}");
		Matcher m = p.matcher(u.getUpiId());
		if(!m.find()) {
			throw new UpiIdInValidException("Invalid UpiId");
		}
		//Phone Checker For Validation
		Long l1=u.getPhoneNo();
		String str1=String.valueOf(l1);
		int phoneSize=str1.length();
		if(phoneSize!=10) {
			throw new PhoneNumberInvalidException("Invalid PhoneNumber");
		}
		//Email Checker For Validation
		Pattern p1= Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z0]{2,6}");
		Matcher m1 = p1.matcher(u.getUserEmail());
		if(!m1.find()) {
			throw new EmailIdInValidException("Invalid EmailId");
		}
		return upiRecord.get();
	}

	@Override
	public String CreateUpiDetail(UPIEntity data) {
		upiDao.save(data);
		return "UPI Created Successfully!!!!";
	}

	@Override
	public String UpdateFirstName(UPIEntity data) {
		Optional<UPIEntity> upi4=upiDao.findById(data.getUpiId());
		if(upi4.isPresent()) {
			UPIEntity ad=upi4.get();
			ad.setFirstName(data.getFirstName());
			upiDao.save(ad);
			return "update successfully";
		}
		return "Not update successfully";
	}

	@Override
	public String deleteUpiId(String userId) {
		LOGGER.info("Retriving User {}",userId);
		Optional<UPIEntity> upiRecord=upiDao.findById(userId);
		if(!upiRecord.isPresent()) {
			throw new UserIdIsNotPresentException("UPI-Id Doesnot Exist in Database");
		}
		upiDao.deleteById(userId);
		return "Deleted UpiId Successfully";
	}
	}

	





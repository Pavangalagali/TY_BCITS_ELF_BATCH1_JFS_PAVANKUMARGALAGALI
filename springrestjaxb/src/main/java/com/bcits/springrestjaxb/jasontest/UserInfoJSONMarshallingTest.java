package com.bcits.springrestjaxb.jasontest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.bean.UserAddessBean;
import com.bcits.springrestjaxb.bean.UserInfo;
import com.bcits.springrestjaxb.bean.UserOtherInfo;

public class UserInfoJSONMarshallingTest {
	public static void main(String[] args) {
		UserInfo infoBean = new UserInfo();
		infoBean.setBirthDate(new Date());
		infoBean.setBloodGroup("A+");
		infoBean.setDeptId(16);
		infoBean.setDesignation("jsd");
		infoBean.setEmpId(100);
		infoBean.setJoiningDate(new Date());
		infoBean.setMaildId("manju@gmail.com");
		infoBean.setMgrId(12);
		infoBean.setMobileNum(9876878789L);
		infoBean.setName("Manju");
		infoBean.setSalary((double) 40000);
		infoBean.setPassword("qwerty");

		UserOtherInfo otherInfo = new UserOtherInfo();
		otherInfo.setAadhar(12344321L);
		otherInfo.setGender("Male");

		infoBean.setOtherInfo(otherInfo);
		UserAddessBean tempUserAddess = new UserAddessBean();
		tempUserAddess.setHouseNum(11);
		tempUserAddess.setStreet("NR COLONY");
		tempUserAddess.setCity("BLR");
		tempUserAddess.setAddressType('T');
		
		UserAddessBean PermanentAdress = new UserAddessBean();
		PermanentAdress.setHouseNum(11);
		PermanentAdress.setStreet("MG ROAD");
		PermanentAdress.setCity("BGK");
		PermanentAdress.setAddressType('P');
		
		List<UserAddessBean> addessBeans = new ArrayList<>();
		addessBeans.add(PermanentAdress);
		addessBeans.add(tempUserAddess);

		infoBean.setUserAddesses(addessBeans);

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("userInfo2.json"), infoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

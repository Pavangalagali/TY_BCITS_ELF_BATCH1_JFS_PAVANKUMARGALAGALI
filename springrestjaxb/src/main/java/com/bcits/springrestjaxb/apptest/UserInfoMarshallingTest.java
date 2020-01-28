package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.bean.UserAddessBean;
import com.bcits.springrestjaxb.bean.UserInfo;
import com.bcits.springrestjaxb.bean.UserOtherInfo;

public class UserInfoMarshallingTest {
	public static void main(String[] args) {

		UserInfo infoBean = new UserInfo();
		infoBean.setBirthDate(new Date());
		infoBean.setBloodGroup("A-");
		infoBean.setDeptId(11);
		infoBean.setDesignation("ssd");
		infoBean.setEmpId(101);
		infoBean.setJoiningDate(new Date());
		infoBean.setMaildId("sai@gmail.com");
		infoBean.setMgrId(22);
		infoBean.setMobileNum(9876878789L);
		infoBean.setName("Sai");
		infoBean.setSalary((double) 60000);
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
			JAXBContext context = JAXBContext.newInstance(UserInfo.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(infoBean, System.out);
			marshaller.marshal(infoBean, new File("userInfo1.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}

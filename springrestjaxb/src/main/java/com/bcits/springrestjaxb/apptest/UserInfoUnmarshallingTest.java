package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.bean.UserAddessBean;
import com.bcits.springrestjaxb.bean.UserInfo;
import com.bcits.springrestjaxb.bean.UserOtherInfo;

public class UserInfoUnmarshallingTest {
	public static void main(String[] args) {

	
		try {
			JAXBContext context = JAXBContext.newInstance(UserInfo.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			UserInfo infoBean = (UserInfo) unmarshaller.unmarshal(new File("UserInfo1.xml"));

			System.out.println("Name : " + infoBean.getName());
			System.out.println("ID   : " + infoBean.getEmpId());
			System.out.println("DOB  : " + infoBean.getBirthDate());
			System.out.println("Role : " + infoBean.getDesignation());
			System.out.println("salary : " + infoBean.getSalary());
			System.out.println("Gender : " +infoBean.getOtherInfo().getGender());
			System.out.println("aadhar : " + infoBean.getOtherInfo().getAadhar());
			List<UserAddessBean> addessBeans = infoBean.getUserAddesses();

			System.out.println("Address");
			for (UserAddessBean userAddessBean : addessBeans) {
				System.out.println(userAddessBean.getHouseNum());
				System.out.println(userAddessBean.getStreet());
				System.out.println(userAddessBean.getCity());
				System.out.println(userAddessBean.getAddressType());
				System.out.println("------------");
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}
			
		
	

	}
}

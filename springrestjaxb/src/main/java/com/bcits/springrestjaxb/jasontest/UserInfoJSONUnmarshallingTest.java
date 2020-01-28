package com.bcits.springrestjaxb.jasontest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.bean.UserAddessBean;
import com.bcits.springrestjaxb.bean.UserInfo;

public class UserInfoJSONUnmarshallingTest {

	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			UserInfo infoBean = mapper.readValue(new File("userInfo2.json"), UserInfo.class);

			System.out.println("Name : " + infoBean.getName());
			System.out.println("ID   : " + infoBean.getEmpId());
			System.out.println("DOB  : " + infoBean.getBirthDate());
			System.out.println("Role : " + infoBean.getDesignation());
			System.out.println("salary : " + infoBean.getSalary());
			System.out.println("Gender : " + infoBean.getOtherInfo().getGender());

			List<UserAddessBean> addessBeans = infoBean.getUserAddesses();

			System.out.println("Address");
			for (UserAddessBean userAddessBean : addessBeans) {
				System.out.println(userAddessBean.getHouseNum());
				System.out.println(userAddessBean.getStreet());
				System.out.println(userAddessBean.getCity());
				System.out.println(userAddessBean.getAddressType());
				System.out.println("------------");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

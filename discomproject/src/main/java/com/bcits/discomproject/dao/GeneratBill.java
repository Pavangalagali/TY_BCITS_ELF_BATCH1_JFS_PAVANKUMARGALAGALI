package com.bcits.discomproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.discomproject.beans.TarrifMaster;

@Repository
public class GeneratBill {

	@Autowired
	private  EntityManagerFactory managerFactory;


	public  Double generateBill(String type, Double init, Double fnl) {
		if(init == null) {
			init=0.0;
		}
		EntityManager manager = managerFactory.createEntityManager();
		String gettarrif = " from TarrifMaster where type =: type ";
		Query query = manager.createQuery(gettarrif);
		query.setParameter("type", type);

		List<TarrifMaster> tarrifMasters = query.getResultList();
		Long initRange = tarrifMasters.get(0).getTarrif().getRange();
		Long midRange = tarrifMasters.get(1).getTarrif().getRange();
		Long finalRange = tarrifMasters.get(2).getTarrif().getRange();

		Double initAmount = tarrifMasters.get(0).getAmount();
		Double midAmount = tarrifMasters.get(1).getAmount();
		Double finalAmount = tarrifMasters.get(2).getAmount();

		System.out.println(initRange + " " + midRange + " " + finalRange);
		Double units = fnl - init;
		Double bill = 0.0;
		if (units < initRange) {
			bill = units * initAmount;
		} else if (units < midRange) {
			bill = (initRange * initAmount) + ((units - initRange) * midAmount);
		} else if (units > midRange) {
			bill = (initRange * initAmount) + (midRange * midAmount) + ((units - midAmount) * finalAmount);
		}
		return bill;
	}

}

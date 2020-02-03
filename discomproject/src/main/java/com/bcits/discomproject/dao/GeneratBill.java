package com.bcits.discomproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.bcits.discomproject.beans.TarrifMaster;

public class GeneratBill {

	@PersistenceUnit
	private static EntityManagerFactory managerFactory;

	private static EntityManager manager = managerFactory.createEntityManager();

	public static Double generateBill(String region, Double init, Double fnl) {
		String gettarrif = " from TarrifMaster where region := region ";
		Query query = manager.createQuery(gettarrif);
		query.setParameter("region", region);

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

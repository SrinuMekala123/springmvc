package com.surya.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import com.surya.pojo.Doctor;
import com.surya.pojo.Doctor1;

 
public class DoctorDao {

	public void onetomany(Doctor d) {

		Configuration cf = new Configuration();
		cf.configure("hibernate.cfg.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		ss.save(d);
		tx.commit();
		ss.close();

	}

	public 	 List<Doctor1> retrieveDoctorsDetails() {
		List<Doctor1> listdoctors = new ArrayList();

		Configuration cf = new Configuration();
		cf.configure("hibernate.cfg.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session ss = sf.openSession();
		String qry = " select * from doctor d full join pasient p on p.did=d.did";
		SQLQuery sqlQuery = ss.createSQLQuery(qry);
		List list = sqlQuery.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Doctor1 d1 = new Doctor1();
			Object[] object = (Object[]) iterator.next();

			System.out.println("DID : " + object[0] + " DNAME : " + object[1] + " PID : " + object[2] + " PNAME : "
					+ object[3] + " ADDRESS : " + object[4]);

			BigDecimal did = (BigDecimal) object[0];
			String dname = (String) object[1];
			BigDecimal pid = (BigDecimal) object[2];
			String pname = (String) object[3];
			String address = (String) object[4];

			d1.setDid(did);
			d1.setDname(dname);
			d1.setPid(pid);
			d1.setPname(pname);
			d1.setAddress(address);

			listdoctors.add(d1);
		}
		return listdoctors;
	}

	public Doctor1 get(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Doctor1 doctor) {
		Configuration cf = new Configuration();
		cf.configure("hibernate.cfg.xml");
		SessionFactory sf=cf.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		
		ss.save(doctor);
		tx.commit();
		ss.close();
		
	}
	public List<Doctor1> searchDoctorDetails(int did) {
		List<Doctor1> listdoctors = new ArrayList();

		Configuration cf = new Configuration();
		cf.configure("hibernate.cfg.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session ss = sf.openSession();
		String qry = " select * from doctor d full join pasient p on p.did=d.did where d.did=1?";
		SQLQuery sqlQuery = ss.createSQLQuery(qry);
		List list = sqlQuery.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Doctor1 d1 = new Doctor1();
			Object[] object = (Object[]) iterator.next();

			System.out.println("DID : " + object[0] + " DNAME : " + object[1] + " PID : " + object[2] + " PNAME : "
					+ object[3] + " ADDRESS : " + object[4]);

			BigDecimal did1 = (BigDecimal) object[0];
			String dname = (String) object[1];
			BigDecimal pid = (BigDecimal) object[2];
			String pname = (String) object[3];
			String address = (String) object[4];

			d1.setDid(did1);
			d1.setDname(dname);
			d1.setPid(pid);
			d1.setPname(pname);
			d1.setAddress(address);

			listdoctors.add(d1);
		}
		return listdoctors;
	}
	public void deleteDoctor(int did) {

		Configuration cf = new Configuration();
		cf.configure("hibernate.cfg.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session ss = sf.openSession();
		
		 Transaction tx=ss.beginTransaction();
		 Doctor doctor = (Doctor) ss.get(Doctor.class, did); // Load the parent entity
		 ss.delete(doctor);
		 
		tx.commit();
		ss.close();
	}

}
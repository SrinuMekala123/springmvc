package com.surya.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.dao.DoctorDao;
import com.surya.pojo.Doctor;
import com.surya.pojo.Doctor1;
import com.surya.pojo.Pasient;

@Service
public class DoctorService {

	@Autowired
	DoctorDao doctorDao;

	public void onetomany() {
		Doctor d = new Doctor();
		d.setDid(201);
		d.setDname("chiranjeevi");

		Set<Pasient> pasients = new HashSet<Pasient>();
		Pasient p = new Pasient();
		p.setPid(1);
		p.setPname("ram");
		p.setAddress("ongole");

		Pasient p1 = new Pasient();
		p1.setPid(2);
		p1.setPname("raju");
		p1.setAddress("podili");

		Pasient p2 = new Pasient();
		p2.setPid(3);
		p2.setPname("santosh");
		p2.setAddress("addanki");

		Pasient p3 = new Pasient();
		p3.setPid(4);
		p3.setPname("subbu");
		p3.setAddress("darsi");

		Pasient p4 = new Pasient();
		p4.setPid(5);
		p4.setPname("balu");
		p4.setAddress("darsi");

		Pasient p5 = new Pasient();
		p5.setPid(6);
		p5.setPname("rahesh");
		p5.setAddress("kakinada");

		Pasient p6 = new Pasient();
		p6.setPid(7);
		p6.setPname("ravi");
		p6.setAddress("bhimsvsram");

		Pasient p7 = new Pasient();
		p7.setPid(8);
		p7.setPname("naidu");
		p7.setAddress("naidupalem");

		Pasient p8 = new Pasient();
		p8.setPid(9);
		p8.setPname("koti");
		p8.setAddress("kurichedu");

		Pasient p9 = new Pasient();
		p9.setPid(10);
		p9.setPname("shekhar");
		p9.setAddress("nspuram");

		Pasient p10 = new Pasient();
		p10.setPid(11);
		p10.setPname("yaswanth");
		p10.setAddress("n.g.padu");

		pasients.add(p);
		pasients.add(p1);
		pasients.add(p2);
		pasients.add(p3);
		pasients.add(p5);
		pasients.add(p6);
		pasients.add(p7);
		pasients.add(p8);
		pasients.add(p9);
		pasients.add(p10);

		d.setPasientList(pasients);
		doctorDao.onetomany(d);
	}

	public List<Doctor1> retrieveDoctorsDetails() {
		List<Doctor1> listdoctors = doctorDao.retrieveDoctorsDetails();
		return listdoctors;
	}

	public Doctor1 get(Integer pid) {
		Doctor1 listdoctors1 = doctorDao.get(pid);
		return listdoctors1;
	}

	public void save(Doctor1 doctor1) {
		Doctor1 doctor =new Doctor1();
		doctor.setPid(doctor1.getDid());
		doctor.setPname(doctor1.getDname());
		doctor.setPid(doctor1.getPid());
		doctor.setPname(doctor1.getPname());
		doctor.setAddress(doctor1.getAddress());
		
		doctorDao.save(doctor);
		

	}
	public void searchApi(int did) {
		doctorDao.searchDoctorDetails(did);
		
	}

}

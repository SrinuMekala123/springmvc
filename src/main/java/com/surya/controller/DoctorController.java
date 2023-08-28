package com.surya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.surya.pojo.Doctor1;
import com.surya.service.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	DoctorService doctorservice;

	@RequestMapping(value = "/onetomany", method = RequestMethod.GET)
	public void onetomany() {

		doctorservice.onetomany();
	}

	@RequestMapping(value = "/retrieveDoctorDetails", method = RequestMethod.GET)
	ModelAndView getDataUsingOnetomany() {

		List<Doctor1> listdoctors = doctorservice.retrieveDoctorsDetails();
		ModelAndView mvc = new ModelAndView();
		mvc.setViewName("doctor1");

		mvc.addObject("doctordata", listdoctors);
		return mvc;

	}
}
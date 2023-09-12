package com.surya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.surya.pojo.Doctor1;
import com.surya.service.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorservice;

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

	@RequestMapping(value = "/savedoctor", method = RequestMethod.POST)
	public String saveDoctor(@ModelAttribute("doctor") Doctor1 doctor1) {
		doctorservice.save(doctor1);
		return "redirect:/retrieveDoctorDetails";
	}
	@RequestMapping(value="/deleteDoctor",method = RequestMethod.POST)
	void deleteDoctor(@RequestParam("empid") String empid) {
		System.out.println("deleteDoctor");
		doctorservice.deleteDoctor(empid);
	}

	@RequestMapping("/edit")
	public ModelAndView editForm(@RequestParam Integer pid) {
		ModelAndView mav = new ModelAndView("editpatient");
		Doctor1 listofdoctors = doctorservice.get(pid);
		mav.addObject("doctor", listofdoctors);

		return mav; 
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void searchApi(@RequestParam(required = true) int did) {
		doctorservice.searchApi(did);
	}


}
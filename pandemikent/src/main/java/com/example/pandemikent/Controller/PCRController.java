package com.example.pandemikent.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pandemikent.Model.PCR;
import com.example.pandemikent.Services.CovidHistoryService;

@Controller
public class PCRController {
	
	@Autowired
	private CovidHistoryService covidHistoryService;
	
	@GetMapping("/pcrTracker")
	public String displayPCRTrackerPage(@RequestParam("patientId") String patientId, Model theModel) {
		List<PCR> pcrs = covidHistoryService.listUserPCRs(patientId);
		theModel.addAttribute("pcrs", pcrs);
		return "PCRTracker";
	}
	
	@GetMapping("/addPCR")
	public String displayAddPCRPage(@ModelAttribute("newPCR") PCR newPCR) {
		PCR pcr = covidHistoryService.savePCR(newPCR);
		if(pcr == null)
			return "error";
		else
			return "redirect:pcrTracker";
	}
}

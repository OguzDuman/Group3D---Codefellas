package com.example.pandemikent.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

import com.example.pandemikent.Model.Student;
import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.StudentRepository;
import com.example.pandemikent.Repo.UserProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.Query;
import com.example.pandemikent.Model.PCR;
import com.example.pandemikent.Model.Vaccine;
import com.example.pandemikent.Repo.HESCodeRepository;
import com.example.pandemikent.Repo.PCRRepository;
import com.example.pandemikent.Repo.VaccineRepository;

@Service
public class CovidHistoryService {
	
	@Autowired
	private PCRRepository pcrRepoitory;
	
	@Autowired
	private VaccineRepository vaccineRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired 
	private EntityManager entityManager;
	
	public PCR savePCR(PCR pcr) {
		return pcrRepoitory.save(pcr);
	}
	
	public Boolean addVaccineAppointment(Vaccine vacApt) {
		vacApt.setSuccessful(false);
		vaccineRepository.save(vacApt);
		return true;
	}
	
	public List<Vaccine> getVaccineHistory(String name) {
		return vaccineRepository.getVaccineByPatientId(name);
	}

	public List<String> getCovidHistory(String userID) {
		Optional<Student> s = studentRepository.findById(userID);
		return null;
	}

	public Boolean addCovidHistory(String userID, String history) {
		Optional<Student> s = studentRepository.findById(userID);
		if (s.get() == null || history.equals("")) {
			return false;
		}
		s.get().addHistory(history);
		return true;
	}
	
	public List<PCR> listUserPCRs(String id) {		
		return pcrRepoitory.getPCRByPatientId(id);
	}

	public void setCampusAccessStatus(String userID, boolean accessStatus) {
		Optional<Student> s = studentRepository.findById(userID);
		s.get().setAccessStatus(accessStatus);
	}

	public String findAccessStatus(String userID) {
		Optional<UserProfile> s = userProfileRepository.findById(userID);
		Boolean b = s.get().getAccessStatus();
		String access = "";
		  if(b)
			  access = "You are allowed on campus.";
		  else 
			  access = "You are not allowed on campus.";
		return access;
	}

}

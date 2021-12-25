package com.example.pandemikent.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

import com.example.pandemikent.Model.Student;
import com.example.pandemikent.Repo.StudentRepository;
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
		Query q = entityManager.createNativeQuery("SELECT * FROM pandemikent.VACCINE WHERE patient_id = :pId;", Vaccine.class);
		q.setParameter("pId", name);
		List<Object> temp = q.getResultList();
		ArrayList<Vaccine> vaccines = new ArrayList<>();
		for (Object t : temp) {
			vaccines.add((Vaccine)t);
		}
		return vaccines;
	}

	public List<String> getCovidHistory(String userID) {
		Optional<Student> s = studentRepository.findById(userID);
		return s.get().getHistory();
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
		Query q = entityManager.createNativeQuery("SELECT * FROM pandemikent.PCR WHERE patient_id = :pId;", PCR.class);
		q.setParameter("pId", id);
		
		return q.getResultList();
	}

}

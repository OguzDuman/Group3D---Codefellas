package com.example.pandemikent.Service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pandemikent.Model.Class;
import com.example.pandemikent.Model.MakeUpExam;
import com.example.pandemikent.Model.MakeUpSession;
import com.example.pandemikent.Model.Section;
import com.example.pandemikent.Repo.AttendanceRepository;
import com.example.pandemikent.Repo.ClassRepository;
import com.example.pandemikent.Repo.MakeUpExamRepository;
import com.example.pandemikent.Repo.MakeUpSessionRepository;
import com.example.pandemikent.Repo.SectionRepository;

@Service
public class MakeUpService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private SectionRepository sectionRepository;
	
	// public Boolean setMakeUpExam(MakeUpExam makeUpExam, String classId) {
	// 	Class c = classRepository.getById(classId);
	// 	ArrayList<String> ids = (ArrayList<String>) c.getAttendance().getStudentIDs();
	// 	ArrayList<String> reasons = (ArrayList<String>) c.getAttendance().getReason();
	// 	for(int i = 0; i < ids.size();  i++) {
	// 		if(!reasons.get(i).equals("quarantined")) {
	// 			ids.remove(i);
	// 		}
	// 	}
		
	// 	makeUpExam.setStudentIDs(ids);
	// 	c.setMakeUpExam(makeUpExam);
	// 	return true;
	// }
	
	public Boolean setMakeUpSession(MakeUpSession makeUpSession, Long sectionId) {
		Section s = sectionRepository.getById(sectionId);
		ArrayList<MakeUpSession> newList = (ArrayList<MakeUpSession>) s.getMakeUpSessions();
		newList.add(makeUpSession);
		s.setMakeUpSessions(newList);
		return true;
	}
	
	public MakeUpExam getClassMakeUpExam(String classId) {
		return classRepository.getById(classId).getMakeUpExam();
	}
	
	public ArrayList<MakeUpSession> getClassMakeUpSessions(Long sectionId) {
		return (ArrayList<MakeUpSession>) sectionRepository.getById(sectionId).getMakeUpSessions();
	}
}

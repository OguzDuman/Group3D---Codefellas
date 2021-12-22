package com.example.pandemikent.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.example.pandemikent.Model.Class;
import com.example.pandemikent.Model.Instructor;
import com.example.pandemikent.Model.Section;
import com.example.pandemikent.Model.Student;
import com.example.pandemikent.Repo.ClassRepository;
import com.example.pandemikent.Repo.InstructorRepository;
import com.example.pandemikent.Repo.QuarantineRepository;
import com.example.pandemikent.Repo.SectionRepository;
import com.example.pandemikent.Repo.StudentRepository;

@Service
public class ClassService {
	
  	private StudentRepository studentRepository;
	
  	@Autowired
  	private InstructorRepository instructorRepository;
	
  	@Autowired
  	private ClassRepository classRepository;
	
  	@Autowired
  	private SectionRepository sectionRepository; 
	
  	@Autowired
  	private QuarantineRepository quarantineRepository;
	
  	public Class save(Class addClass, String instrId) {
  		Instructor instr = instructorRepository.findById(instrId).get();
  		if(classRepository.getById(addClass.getName()) == null) {
  			Class newClass = new Class();
  			newClass.setName(addClass.getName());
  			Section newSection = new Section();
  			newSection.setInstructor(instr);
  			String sectionId = addClass.getSections().get(0).getSectionNumber();
  			newSection.setSectionNumber(sectionId);
  			ArrayList<Section> sections = new ArrayList<Section>();
  			sections.add(newSection);
  			newClass.setSections(sections);
  			return classRepository.save(newClass);
  		}
  		else {
  			Boolean b = false;
  			for( Section s : classRepository.getById(addClass.getName()).getSections()) {
  				if(s.getSectionNumber() == addClass.getSections().get(0).getSectionNumber()) {
  					b = true;
  					break;
  				}
  			}
  			if(b)
  				return null;
  			else {
  				Section newSection = new Section();
  	  			newSection.setInstructor(instr);
  	  			newSection.setSectionNumber(addClass.getSections().get(0).getSectionNumber());
	  	  		ArrayList<Section> sections = (ArrayList<Section>) classRepository.getById(addClass.getName()).getSections();
	  			sections.add(newSection);
	  			classRepository.getById(addClass.getName()).setSections(sections);
	  			return classRepository.getById(addClass.getName());
  			}
  		}
  	}
	
  	public List<Class> listUserClasses(String userId) {
  		if(studentRepository.findById(userId) != null) {
  			List<String> classesString = studentRepository.findById(userId).get().getClasses();
  			List<Class> classes = new ArrayList<Class>();
  			for(String s : classesString) {
  				Class c = classRepository.findById(s).get();
  				classes.add(c);
  			}
  			return classes;
  		}
  		else if(instructorRepository.findById(userId) != null) {
  			return instructorRepository.findById(userId).get().getClasses();
  		}
  		else 
  			return null;
  	}
	
  	public List<Section> listUserSections(String userId, String classId) {
  		List<Section> sections = classRepository.getById(classId).getSections();
  		for(Section section: sections) {
  			if(section.getInstructor().getUsername() != userId) {
  				sections.remove(section);
  			}
  		}
  		return sections;
  	}
	
  	public Class addClass(Class newClass) {
  		return classRepository.save(newClass);
  	}
	
  	public Boolean joinClass(Class joinClass, Section joinSection, String userId) {
  		Class c = classRepository.findById(joinClass.getName()).get();
  		if(c == null) {
  			return false;
  		}
  		else {
  			for(Section s : c.getSections()) {
  				if(s.getSectionNumber() == joinSection.getSectionNumber()) {
  					joinSection = s;
  					break;
  				}
  			}
  			if(joinSection.getInstructor() == null) {
  				return false;
  			}
  			else {
  				Student stu = studentRepository.findById(userId).get();
  				stu.getClasses().add(c.getName());
  				c.getStudents().add(stu);
  				joinSection.getStudents().add(stu);
  				return true;
  			}
  		}
  	}
	
  	public ArrayList<Student> listParticipants(Long sectionId) {
  		return (ArrayList<Student>) sectionRepository.getById(sectionId).getStudents();
  	}
	
  	public List<Date> getMissedClasses() {
  		return null;
  	}
	
  	public Instructor getSectionInstr(Long sectionId) {
  		return sectionRepository.findById(sectionId).get().getInstructor();
  	}
	
  	public Boolean getUserAccess(String userId) {
  		//return studentRepository.findById(userId).get().getCampusAccess();
  		return true;
  	}
	
  	public ArrayList<Student> listQuarantinedStudents(String classId, String instrId) {
  		return null;
  	}
  	
  	public String getUserId() {
  		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

  		String username;
  		if (principal instanceof UserDetails) {
  		  username = ((UserDetails)principal).getUsername();
  		} else {
  		  username = principal.toString();
  		}
  		
  		return username;
  	}
}

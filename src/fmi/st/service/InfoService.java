package fmi.st.service;

import java.util.ArrayList;
import java.util.Date;

public class InfoService {

	ArrayList<StudentInfo> studentList = new ArrayList<StudentInfo>();

	public InfoService() {
		StudentInfo st1 = new StudentInfo();
		st1.setName("Ivan Ivanov");
		st1.setAge(22);
		st1.setBirthDate(new Date(1996, 2, 3));
		st1.setSpeciality("math");
		st1.setFacultyNumber("11111111");

		StudentInfo st2 = new StudentInfo();
		st2.setName("K K");
		st2.setAge(33);
		st2.setBirthDate(new Date(1998, 8, 8));
		st2.setSpeciality("math");
		st2.setFacultyNumber("22222222");

		studentList.add(st1);
		studentList.add(st2);

	}

	public StudentInfo findStudent (Filter filter) {

		StudentInfo stu = new StudentInfo();

		for (int i = 0; i < studentList.size(); i++) {

			if (stu.getName().equals(filter.getStudentName())) {
				return stu;
			}
			
			
		}
		return null;

	}

}

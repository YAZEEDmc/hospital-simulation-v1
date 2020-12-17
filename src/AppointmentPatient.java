import java.util.Random;

public class AppointmentPatient extends patient {

	
	public AppointmentPatient(int iD) {
		super(iD);
		AddHistory(String.format(" The info of the patient in Appointment department is\n"
				+ " ID is : %d \n" ,getID()));
		Random ttl=new Random();
		 setTimeToLeave(ttl.nextInt(50)+24);	// 1-49 +23 (+1 Because of 0).
	   
	}

	@Override
	public String ExplaintYourPain() {
	
	
		return "no";// arry.bc 
	}

	@Override
	public void AddHistory(String ph) {
		PaitentHistory+=ph;
	}

	
	@Override
	public String toString() {
		return String.format(" The info of the patient in Appointment department is \n %s \n ", super.toString());
		
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private String AppiontDay;
private Doctor doctor;

public Appointment(String name, String nationalty, String bloodType, String birthDay, String gender, String address,
		int iD, double age, int fileNumber, String appiontDay, Doctor doctor) {
	super(name, nationalty, bloodType, birthDay, gender, address, iD, age, fileNumber);
	AppiontDay = appiontDay;
	this.doctor = doctor;
}
public Appointment(File myfile,Doctor doctor,String AppiontDay) {
	super(myfile);
this.doctor=doctor;
this.AppiontDay=AppiontDay;
}


public String getAppiontDay() {
	return AppiontDay;
}
public void setAppiontDay(String appiontDay) {
	AppiontDay = appiontDay;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}

public String nextAppointment() {
	return"";
}
@Override
public String toString() {
	return "Appointment [AppiontDay=" + AppiontDay + ", doctor=" + doctor + ", nextAppointment()=" + nextAppointment()
			+ ", toString()=" + super.toString() + "]";
}




*/
}

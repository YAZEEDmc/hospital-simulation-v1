

public abstract class patient implements InPain {
	private int ID;
	private int TimeToLeave;//hours
	protected String PaitentHistory;//protected for more securty it could be public
	private int myRoom;
	private int myBed;
	private boolean HasAroom;//controll for data base
	private boolean DoctorPermission;//to get room or not
    private boolean SawTheDoctor;

	public patient(int iD) {
		ID = iD;
		//initlize for paitinet history
		String S="========================\nthe paintiet history is\n========================\n";
		PaitentHistory=S;
	}

	public abstract void AddHistory(String ph); 
	
	public String getPaitentHistory() {
		return PaitentHistory;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getTimeToLeave() {
		return TimeToLeave;
	}
	public void setTimeToLeave(int timeToLeft) {
		TimeToLeave = timeToLeft;
	}

	public int getMyRoom() {
		return myRoom;
	}

	public void setMyRoom(int myRoom) {
		this.myRoom = myRoom;
	}

	public int getMyBed() {
		return myBed;
	}

	public void setMyBed(int myBed) {
		this.myBed = myBed;
	}

	public boolean isDoctorPermission() {
		return DoctorPermission;
	}

	public void setDoctorPermission(boolean doctorPermission) {
		DoctorPermission = doctorPermission;
	}
	public boolean isSawTheDoctor() {
		return SawTheDoctor;
	}

	public void setSawTheDoctor(boolean sawTheDoctor) {
		SawTheDoctor = sawTheDoctor;
	}
	public boolean isHasAroom() {
		return HasAroom;
	}

	public void setHasAroom(boolean hasAroom) {
		HasAroom = hasAroom;
	}

	@Override
	public String toString() {
		return String.format("ID is : %d \n Time to left :%d" ,ID,TimeToLeave ) ;
		
	}
	/*int m=100;
			for(int u=1;u<m;u++) {
			p.get(u).setTimeToLeave(p.get(u).getTimeToLeave()-1);
			
			if(p.get(u).getTimeToLeave()==0) {
				p.remove(u);
				m=m-1;
			
				System.out.println("******************");
			}
			}

	
	//---------------------------------------------------------------------------------------
	/*
	private String Name;
private String Nationalty;
private String BloodType;
private String BirthDay;
private String Gender;
private String Address;
private int ID;
private double Age;
private int FileNumber;
private boolean WantARoom; //FACTOR
private File myfile;//text file from the patient info

public patient(String name, String nationalty, String bloodType, String birthDay, String gender, String address,
		int iD, double age, int fileNumber) {
	Name = name;
	Nationalty = nationalty;
	BloodType = bloodType;
	BirthDay = birthDay;
	Gender = gender;
	Address = address;
	ID = iD;
	Age = age;
	FileNumber = fileNumber;
}


public patient(File myfile) {
	//use scanner
	//loops
	 //this.
	 }


public boolean isWantARoom() {
	return WantARoom;
}


public void setWantARoom(boolean wantARoom) {
	WantARoom = wantARoom;
}


public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getNationalty() {
	return Nationalty;
}
public void setNationalty(String nationalty) {
	Nationalty = nationalty;
}
public String getBloodType() {
	return BloodType;
}
public void setBloodType(String bloodType) {
	BloodType = bloodType;
}
public String getBirthDay() {
	return BirthDay;
}
public void setBirthDay(String birthDay) {
	BirthDay = birthDay;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public double getAge() {
	return Age;
}
public void setAge(double age) {
	Age = age;
}
public int getFileNumber() {
	return FileNumber;
}
public void setFileNumber(int fileNumber) {
	FileNumber = fileNumber;
}


@Override
public String toString() {
	return "Patients [isWantARoom()=" + isWantARoom() + ", getName()=" + getName() + ", getNationalty()="
			+ getNationalty() + ", getBloodType()=" + getBloodType() + ", getBirthDay()=" + getBirthDay()
			+ ", getGender()=" + getGender() + ", getAddress()=" + getAddress() + ", getID()=" + getID() + ", getAge()="
			+ getAge() + ", getFileNumber()=" + getFileNumber() + "]";
}


*/
}


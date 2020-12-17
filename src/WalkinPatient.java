import java.util.Random;
//it could become Emergency or Appointment patient
public class WalkinPatient extends patient {

	
	
	public WalkinPatient(int iD) {
		super(iD);
		AddHistory(String.format(" The info of the patient in  Walkin patient department is\n"
				+ " ID is : %d \n" ,getID()));
		Random ttl=new Random();
		 setTimeToLeave(ttl.nextInt(2)+1)	;
	    
	}

	
	
	@Override
	public String ExplaintYourPain() {
		String [] disease={"fever","stomach upsets","cuts and bruises","Muscle pain","Coughs and colds and viruses"};	
		Random r=new Random();
		int x=r.nextInt(disease.length);
	
		return disease[x]  ;// arry.bc 
	}
	
	
	@Override
	public void AddHistory(String ph) {
		PaitentHistory+=ph;
	}


	
	public AppointmentPatient beAppointment(boolean y) {

		AppointmentPatient a1=new AppointmentPatient(getID());
		if(y==false) {
			
		a1=null;// Garbage collector will take care of it
		}
		else {
		a1.PaitentHistory="";
			a1.AddHistory(getPaitentHistory()+"\nThe patient become Appointment");
			a1.setMyRoom(getMyRoom());
			a1.setMyBed(getMyBed());
		}
		
		return a1;
	 
	}

	@Override
	public String toString() {
		return String.format(" The info of the patient in  Walkin patient department is \n %s \n ", super.toString());
		
	}
		
	
	


	
/*private int ticketNumber;
private int ClientTpye;
//new Patient

public WalkinPatient(String name, String nationalty, String bloodType, String birthDay, String gender, String address,
		int iD, double age, int fileNumber, int ticketNumber, int clientTpye) {
	super(name, nationalty, bloodType, birthDay, gender, address, iD, age, fileNumber);
	this.ticketNumber = ticketNumber;
	ClientTpye = clientTpye;
}

//had a file
public WalkinPatient(File myfile, int ticketNumber, int clientTpye) {
	super(myfile);
	this.ticketNumber = ticketNumber;
	ClientTpye = clientTpye;
}

public int getTicketNumber() {
	return ticketNumber;
}

public void setTicketNumber(int ticketNumber) {
	this.ticketNumber = ticketNumber;
}

public int getClientTpye() {
	return ClientTpye;
}

public void setClientTpye(int clientTpye) {
	ClientTpye = clientTpye;
}

public Emergncy EmergncyST(File myfile,boolean NeedBlood,boolean NeedOpration) {
	Emergncy d=new Emergncy(myfile,NeedOpration,NeedOpration);
	return d;
}
*/
}

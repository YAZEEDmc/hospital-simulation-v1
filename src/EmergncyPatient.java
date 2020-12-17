import java.util.Random;

public class EmergncyPatient extends patient{
	
	
	

	public EmergncyPatient(int iD ) {
		super(iD);
		AddHistory(String.format(" The info of the patient in  Emergncy department is\n"
				+ " ID is : %d \n" ,getID()));
		Random ttl=new Random();
    setTimeToLeave(ttl.nextInt(4)+1)	;
  
  
	}

	@Override
	public String ExplaintYourPain() {
		String [] disease={"Bleeding","Breathing difficulties","Severe pain","Heart attack","Broken bones"};	
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
		return String.format(" The info of the patient in Emergncy department is \n %s \n ", super.toString());
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private boolean NeedBlood;
		private boolean NeedOpration;
		
		public Emergncy(String name, String nationalty, String bloodType, String birthDay, String gender,
				String address, int iD, double age, int fileNumber, boolean needBlood, boolean needOpration) {
			super(name, nationalty, bloodType, birthDay, gender, address, iD, age, fileNumber);
			NeedBlood = needBlood;
			NeedOpration = needOpration;
		}
		//has file
		public Emergncy(File myfile,boolean NeedOpration,boolean NeedBlood) {
			super(myfile);
		this.NeedBlood=NeedBlood;
		this.NeedOpration=NeedOpration;
		
		}	
		
			public Appointment needAppoint(File myfile,Doctor doctor,String AppiontDay) {
			Appointment d=new Appointment(myfile,doctor,AppiontDay);//complex Lab java
				return d;
			}
			
			public void opreation(boolean np) {
				if(np==this.NeedOpration) {
					//set doctor
					//set room
					//blood
					//etc
				}
				else {
					System.out.println("need for opreation");
				}
			} 
			
			public boolean getNeedBlood() {
				return NeedBlood;
			}

			public void setNeedBlood(boolean needBlood) {
				NeedBlood = needBlood;
			}

			public boolean getNeedOpration() {
				return NeedOpration;
			}

			public void setNeedOpration(boolean needOpration) {
				NeedOpration = needOpration;
			}
			@Override
			public String toString() {
				return "Emergncy [NeedBlood=" + NeedBlood + ", NeedOpration=" + NeedOpration + ", toString()="
						+ super.toString() + "]";
			}
			
*/
}


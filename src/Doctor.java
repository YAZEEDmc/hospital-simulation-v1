import java.util.Random;

public class Doctor {
	private int RofBA;
	
	
	public int getRofBA() {
		return RofBA;
	}
	public void setRofBA(int rofBA) {
		RofBA = rofBA;
	}
	
	
	public void seedoctor (patient p,int D) { 
			
		String f=p.ExplaintYourPain();
			
		
		if(f.equals("fever")) {
			p.AddHistory(" The patient disease is:"+f);
			p.setDoctorPermission(false);
			p.setTimeToLeave(0);
			
		}
		else if (f.equals("stomach upsets")) {
			p.AddHistory(" The patient disease is:"+f);
		    p.setDoctorPermission(true);
			p.setTimeToLeave(4+D);
		}
       else if (f.equals("cuts and bruises")) {
    	   p.AddHistory(" The patient disease is:"+f);
    	   p.setDoctorPermission(true);
    	   p.setTimeToLeave(2);
		  }
         else if (f.equals("Muscle pain")) {
        	p.AddHistory(" The patient disease is:"+f);
        	p.setDoctorPermission(false);
			p.setTimeToLeave(0);
          }
        else if (f.equals("Coughs and colds and viruses")) {
        	p.AddHistory(" The patient disease is:"+f);
        	p.setDoctorPermission(false);
			p.setTimeToLeave(0);
         }
        else if (f.equals("Bleeding")) {
        	p.AddHistory(" The patient disease is:"+f);
        	p.setDoctorPermission(true);
			p.setTimeToLeave(20+D);
		        }
       else if (f.equals("Breathing difficulties")) {
    	   p.AddHistory(" The patient disease is:"+f);
    	   p.setDoctorPermission(true);
    	   p.setTimeToLeave(6+D);
       }
       else if (f.equals("Severe pain")) {
    	   p.AddHistory(" The patient disease is:"+f);
    	   p.setDoctorPermission(true);
		   p.setTimeToLeave(48+D);
       }
       else if (f.equals("Heart attack")) {
    	   p.AddHistory(" The patient disease is:"+f);
    	   p.setDoctorPermission(true);
    	   p.setTimeToLeave(72+D);
       }
       else if (f.equals("Broken bones")) {
    	   p.AddHistory(" The patient disease is:"+f);
    	   p.setDoctorPermission(true);
    	   p.setTimeToLeave(10+D);
       }
       else if (f.equals("no")) {
    	   p.setDoctorPermission(true);
    	   p.setTimeToLeave(p.getTimeToLeave()+D);
       }

		/*
			switch (f) {
			
			case "fever":
				p.setDoctorPermission(false);
				p.setTimeToLeave(0);
				break;
			case "stomach upsets":
				p.setDoctorPermission(true);
				p.setTimeToLeave(8);
				break;
			case "cuts and bruises":
				p.setDoctorPermission(true);
				p.setTimeToLeave(2);
				break;
            case "Muscle pain":
            	p.setDoctorPermission(false);
				p.setTimeToLeave(0);
            	break;
            case "Coughs and colds and viruses":
            	p.setDoctorPermission(true);
				p.setTimeToLeave(2);
            	break;
            case "Bleeding":
            	p.setDoctorPermission(true);
				p.setTimeToLeave(20);
            	break;
            case "Breathing difficulties":
            	p.setDoctorPermission(true);
				p.setTimeToLeave(6);
            	break;
            case "Severe pain":
            	p.setDoctorPermission(true);
				p.setTimeToLeave(48);
            	break;
            case "Heart attack":
            	p.setDoctorPermission(true);
				p.setTimeToLeave(72);
            	break;
            case "Broken bones":
            	p.setDoctorPermission(true);
				p.setTimeToLeave(10);
            	break;
            	
            case "no":
            	p.setDoctorPermission(true);
            	break;

			}
			*/
			
		
		
		//return String.format("the dez of the patient %d id %s",pid ,disease[g] );
		
	}
	/*public void DoctorPermission(patient p) {
	if(p instanceof WalkinPatient ) {
		p.setDoctorPermission();
	}
	else if(p instanceof EmergncyPatient ) {
		p.setDoctorPermission();
	}
	else {//AppointmentPatient
		p.setDoctorPermission(true);
	}
	
	}
	*/
	public boolean beAppointment() {
		
		Random r=new Random();
		RofBA=r.nextInt(100)+1;
		if(RofBA>=70) {
			
			return true;
			
		}
		else  {
			return false;
			
		}
		
	}
	
	
	public void extendTimeToLeave(patient p,int n ) {
		p.setTimeToLeave(p.getTimeToLeave()+n);
	}
	
	public void youShouldLeave (patient p) {
		p.setTimeToLeave(p.getTimeToLeave()-p.getTimeToLeave());
	}
	
	
	
	
}

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Hospital {

	public static void main(String[] args) {
		
		//crate ArrayLists for patients and Rooms.  
		ArrayList<patient> patients =new ArrayList<patient>();
		ArrayList<Rooms> rooms =new ArrayList<Rooms>();
		ArrayList<Integer> RemovePatient =new ArrayList<Integer>() ;//ID numbers
		ArrayList<patient> Archive =new ArrayList<patient>();
		// make a Doctor.
		Doctor doctor =new Doctor();
		Scanner s1 = new Scanner(System.in);
		//make an object from random.
		Random r=new Random();

		//Initialize for patient ID and Room Number Bed Number in the Hospital. 
	    int  patientID=10000;
		int RoomNumber=100;
		int BedNumber=10; 
		int NumberOfPatient=0;
      	int NumberOfRooms=0;
      	System.out.print("simulation time(hours):");
		int vc=s1.nextInt();
		
        System.out.print("Numbers of rooms in the hospital :");
        int ro=s1.nextInt();
        
        System.out.print("Patient average time for staying on the bed by the Doctor (hours):");
        int ta=s1.nextInt();
        System.out.println("=============================");
        
		//Initialize for the room.
		for(int j=1;j<=ro;j++) {
			
				rooms.add(new Rooms(RoomNumber,BedNumber));
				RoomNumber++;
				BedNumber++;
				NumberOfRooms++;
		}
		//make sharedrooms
		int sharedBedNumber=200;
		for(int kj=0;kj<rooms.size();kj++) {
			if(kj%2==0) {
			rooms.get(kj).AllBeds.add(new Bed(sharedBedNumber));	
			sharedBedNumber++;
			
			}
			
		}
		
		
		  ////////////////////////////
		 //          THE MAIN      //
		////////////////////////////

		// the main loop for 24 hour .
		for(int i=1;i<vc;i++) {
			
			//timetoleft-1
			   for(int k=0;k<patients.size();k++) {
				 if(patients.get(k).getMyRoom()!=0) { 
				     patients.get(k).setTimeToLeave(patients.get(k).getTimeToLeave()-1);
			    }}
			  
			//Initialize for the patients and determined their type.
		
			int x=r.nextInt(4)+1;
		while(x>=1 && x<=4) {
			
		int j=r.nextInt(100)+1;	
				if(j<=30) {
				patients.add(new EmergncyPatient(patientID));
				NumberOfPatient++;
				}
				else if (j<=50) {
				patients.add(new AppointmentPatient(patientID));
				NumberOfPatient++;
				}
				else {
					patients.add(new WalkinPatient(patientID));
					NumberOfPatient++;
				} 
				patientID++;
				x++;
				
			      }
		
		// The seedotor loop
		for(int q=0;q<patients.size();q++) {
			if(patients.get(q).isSawTheDoctor()==false) {
			doctor.seedoctor(patients.get(q),ta);
			patients.get(q).setSawTheDoctor(true);
			boolean y=doctor.beAppointment();
			if (patients.get(q) instanceof EmergncyPatient ) {
			//	((EmergncyPatient) patients.get(q)).beAppointment(d1.beAppointment());
				if(y==true) {
				patients.set(q, ((EmergncyPatient) patients.get(q)).beAppointment(y));
				}
			}
			else if(patients.get(q) instanceof WalkinPatient) {
			//((WalkinPatient) patients.get(q)).beAppointment(d1.beAppointment());
				if(y==true) {
				patients.set(q, ((WalkinPatient) patients.get(q)).beAppointment(y));
				}
			}
			}
			else if(patients.get(q).isDoctorPermission()==false) {
				RemovePatient.add(patients.get(q).getID());
				patients.get(q).AddHistory("The Doctor said he can go home\n paitenit has left the hospital at:"+i+" hour/hours");
			}
			
		}
		

		// Give the patients rooms and beds.
	      for(int k=0;k<patients.size();k++) {
	    	  for(int rr=0;rr<rooms.size();rr++) {
	    		  for(int tt=0;tt<rooms.get(rr).AllBeds.size();tt++) {
	    	   if(patients.get(k).isHasAroom()==false && rooms.get(rr).AllBeds.get(tt).isOcupied().equals("empty")&& rooms.get(rr).AllBeds.get(tt).issOcupied()==false
	    	     && patients.get(k).isDoctorPermission()==true ) {
		    	rooms.get(rr).AddPatient(patients.get(k));
		        patients.get(k).setHasAroom(true);
		    	}
	    	  }
	      }
	}
	      
	      
		//Add paitents to the remove list.
		
		for(int y=0;y<=patients.size()-1;y++) {	
			if(patients.get(y).getTimeToLeave()<=0) { //&& patients.get(y).getMyBed()!=0) {
				RemovePatient.add(patients.get(y).getID());
			}
		}
		//removeing process.
		
		for(int r1=RemovePatient.size()-1;r1>-1;r1-- ) {
			for(int o=patients.size()-1;o>-1;o--) {
			if(	patients.get(o).getID()== RemovePatient.get(r1)) {
				patients.get(o).AddHistory("\n paitenit has left the hospital at:"+i+" hour/hours");
			    Archive.add(patients.get(o));
			    for(int ocp=0;ocp<rooms.size();ocp++) {	//
			    	 for(int tt=0;tt<rooms.get(ocp).AllBeds.size();tt++) {
			    	if(patients.get(o).getMyRoom()==rooms.get(ocp).getRoomNumber()) {
			    rooms.get(ocp).AllBeds.get(tt).setOcupied(false);
			    break;}
			    }}
				patients.remove(o);
			}
		
			}//for loop end	
		}//for loop end
		
		
		if (i==vc-1) {
			
			// Give the patients rooms and beds.
		      for(int k=0;k<patients.size();k++) {
		    	  for(int rr=0;rr<rooms.size();rr++) {
		    		  for(int tt=0;tt<rooms.get(rr).AllBeds.size();tt++) {
		    	   if(patients.get(k).isHasAroom()==false && rooms.get(rr).AllBeds.get(tt).isOcupied()=="empty"
		    	     && patients.get(k).isDoctorPermission()==true ) {
			    	rooms.get(rr).AddPatient(patients.get(k));
			        patients.get(k).setHasAroom(true);
			    	}
		    	  }
		      }
		}
		      }
		
		
		}//end loop 24 hours
		int patientsWithRooms=0;
		for(int u=0;u<patients.size();u++) {
			if(patients.get(u).isHasAroom()==true) {
				patientsWithRooms++;
			}
		}
		//show that all the room are full and there are a lot of patients in the wait list. 
		int WaitListCounter=0;
		for(int h=0;h<=patients.size()-1;h++) {
			if(h==0) {
				System.out.println("the number of Rooms in the hospital :"+ NumberOfRooms);
				System.out.println("the number of patients today :"+ NumberOfPatient);
				System.out.println("the number of patients in the hos Right Now :"+ patients.size());
				System.out.println("the number of patients who got rooms today :"+patientsWithRooms); 
				int PatientsInWaitList=patients.size()-patientsWithRooms;
				if(PatientsInWaitList>0)
				System.out.println("the number of patients who still in the wait list for at the end of the day :"
				+ PatientsInWaitList
				);
				System.out.println("\n============================="
				+"\n --- REPORT OF ALL THE PATIENTS :---"); 
			}
		if(patients.get(h).isHasAroom()==true) {
			System.out.println(" No."+(h+1));
			System.out.println(patients.get(h).toString()+"and his room is :"+patients.get(h).getMyRoom()
					+"\n and his bed is :"+patients.get(h).getMyBed()+"\n=============================");
		}
		//Wait List
			else  {
				
				WaitListCounter++;
				System.out.println("Wiat list No."+WaitListCounter);
    	System.out.println(patients.get(h).toString()+"in the wait list\n=============================");
			}
			}
		
	/*	for(int tr=0;tr<rooms.size();tr++) {
			
			System.out.println(rooms.get(tr).AllBeds.size()+"");	
			}*/

		ArrayList<patient> all =new ArrayList<patient>();
		all.addAll(Archive);
		all.addAll(patients);
		int condition=0;
		while(condition==0) {
			System.out.print(" see patients history? write the ID or -1 to quit: ");
			int tu=s1.nextInt();
			 if (tu==-1) {
					condition=11;
					break;
				}
			for(int rq=0;rq<all.size();rq++) {
				if(all.get(rq).getID()==tu) {
					System.out.println(all.get(rq).getPaitentHistory());	
					break;
				}
				else if(rq==all.size()-1) {
					System.out.println("write the correct number");
				}	
			}
			
		}
		
		
	//rr.get(0).AllBeds.add(new Bed(102));
	//System.out.println(rr.get(0).AllBeds.get(1).getBedNumber());
			
/*//Add paitents to the remove list.
	ArrayList<Integer> idrv =new ArrayList<Integer>() ;
	for(int y=0;y<=p.size()-1;y++) {	
		if(p.get(y).getTimeToLeave()<=0 && p.get(y).getMyBed()!=0) {
			idrv.add(p.get(y).getID());
            
		}
	}
	//removeing process.
	ArrayList<patient> Archive =new ArrayList<patient>();
	for(int r1=idrv.size()-1;r1>-1;r1-- ) {
		for(int o=p.size()-1;o>-1;o--) {
		if(	p.get(o).getID()== idrv.get(r1)) {
			p.get(o).AddHistory("\n paitenit has left the hospital");
		//	System.out.println(p.get(o).getPaitentHistory());
			Archive.add(p.get(o));
			p.remove(o);
		}
	
		}//for loop end	
	}//for loop end
	*/
	//System.out.println(p.size());
	//System.out.println(idrv.size());
	//show that all the room are full and there are a lot of patients in the wait list. 
		/*	for(int h=0;h<=p.size()-1;h++) {
				if(h==0) {
					System.out.println("the number of Rooms in the hospital :"+ NumberOfRooms);
					System.out.println("the number of patients today :"+ NumberOfPatient);
					System.out.println("the number of patients who got rooms today :"+rr.size()); 
					int PatientsInWaitList=NumberOfPatient-rr.size();
					System.out.println("the number of patients who still in the wait list for today :"
					+ PatientsInWaitList
					+"\n============================="
					+"\n --- REPORT OF ALL THE PATIENTS :---" );
					
				}
			if(h<z-1)
				System.out.println(p.get(h).toString()+"and his room is :"+p.get(h).getMyRoom()
						+"\n and his bed is :"+p.get(h).getMyBed()+"\n=============================");
			//Wait List
				else if(h>z-1) {
	    	System.out.println(p.get(h).toString()+"in the wait list\n=============================");
				}
				}
	*/
	}

}









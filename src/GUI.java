import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.Event;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class GUI extends Application implements EventHandler<ActionEvent> {

	TextField t1=new TextField();
	TextField t2=new TextField();
	TextField t3=new TextField();
	Button bt1=new Button("Start");
	Button bt2=new Button("Back");
	TextArea l1=new TextArea();
	@Override
	public void start(Stage primaryStage) throws Exception {
	//Scene 1
		GridPane p1=new GridPane();
		p1.setAlignment(Pos.CENTER);
		p1.setHgap(10);
		p1.setVgap(10);
		VBox vbox=new VBox();
		vbox.setAlignment(Pos.CENTER);
		bt1.setMinSize(150, 40);
		bt1.setFont(Font.font(20));
		Text tt1=new Text("Fill All The Requirments");
		tt1.setFont(Font.font(20));
		Text tt2=new Text("Simualtion Time : ");
		tt2.setFont(Font.font(20));
		Text tt3=new Text("Numbers of rooms in the hospital :");
		tt3.setFont(Font.font(20));
		Text tt4=new Text("Patient average time for staying on the bed by the Doctor (hours): ");
		tt4.setFont(Font.font(20));
		p1.add(tt1,0, 1);
		p1.addRow(2,tt2,t1);
		p1.addRow(3,tt3,t2);
		p1.addRow(4,tt4,t3);
		p1.addRow(5,new Text());
		//Scene 2
		vbox.getChildren().addAll(p1,bt1);
		VBox vbox2=new VBox();
		l1.setMinSize(500, 550);
		l1.setEditable(false);
		l1.setFont(Font.font(22));
		bt2.setMinSize(200, 50);
		bt2.setFont(Font.font(12));
		vbox2.setAlignment(Pos.TOP_CENTER);
		vbox2.getChildren().addAll(l1,bt2);

		//
		Scene scene1=new Scene(vbox,1300,750);
		Scene scene2=new Scene(vbox2,1300,750);
		bt1.setOnAction(myevent-> {primaryStage.setScene(scene2);
		GUI.this.handle(myevent);
		});

		bt2.setOnAction(e->{primaryStage.setScene(scene1);
		GUI.this.handle(e);
		});
		primaryStage.setTitle("Simualtion");
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	//////////////////////////////////////
	
	@Override
	public void handle(ActionEvent event) {
		//crate ArrayLists for patients and Rooms.  
		ArrayList<patient> patients =new ArrayList<patient>();
		ArrayList<Rooms> rooms =new ArrayList<Rooms>();
		ArrayList<Integer> RemovePatient =new ArrayList<Integer>() ;//ID numbers
		ArrayList<patient> Archive =new ArrayList<patient>();
		
		Doctor doctor =new Doctor();
	
		//make an object from random.
		Random r=new Random();

		//Initialize for patient ID and Room Number Bed Number in the Hospital. 
	    int  patientID=10000;
		int RoomNumber=100;
		int BedNumber=1; 
		int NumberOfPatient=0;
      	int NumberOfRooms=0;

		//Initialize for the room.
		for(int j=1;j<=Integer.parseInt(t2.getText());j++) {
			rooms.add(new Rooms(RoomNumber,BedNumber));
			  RoomNumber++;
			BedNumber++;
			NumberOfRooms++;
			
		}

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
		for(int i=1;i<Integer.parseInt(t1.getText());i++) {
			
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
			doctor.seedoctor(patients.get(q),Integer.parseInt(t3.getText()));
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
				

		
		if (i==Integer.parseInt(t1.getText())-1) {
			
			// Give the patients rooms and beds.
		      for(int k=0;k<patients.size();k++) {
		    	  for(int rr=0;rr<rooms.size();rr++) {
		    	   if(patients.get(k).isHasAroom()==false && rooms.get(rr).AllBeds.get(0).isOcupied()=="empty"
		    	     && patients.get(k).isDoctorPermission()==true ) {
			    	rooms.get(rr).AddPatient(patients.get(k));
			        patients.get(k).setHasAroom(true);
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
				l1.setText("the number of Rooms in the hospital :"+ NumberOfRooms+"\n");
				l1.setText(l1.getText()+"the number of patients today :"+ NumberOfPatient+"\n");
				l1.setText(l1.getText()+"the number of patients in the hospital Right Now :"+ patients.size()+"\n");
				l1.setText(l1.getText()+"the number of patients who got rooms today :"+patientsWithRooms+"\n"); 
				int PatientsInWaitList=patients.size()-patientsWithRooms;
				if(PatientsInWaitList>0)
					l1.setText(l1.getText()+"the number of patients who still in the wait list for at the end of the day :"
				+ PatientsInWaitList
				);
				l1.setText(l1.getText()+"\n============================="
				+"\n --- REPORT OF ALL THE PATIENTS :---"); 
			}
		if(patients.get(h).isHasAroom()==true) {
			l1.setText(l1.getText()+"\n"+" No."+(h+1)+"\n");
			l1.setText(l1.getText()+patients.get(h).toString()+"and his room is :"+patients.get(h).getMyRoom()
					+"\n and his bed is :"+patients.get(h).getMyBed()+"\n=============================");
		}
		//Wait List
			else  {
				
				WaitListCounter++;
				l1.setText(l1.getText()+"\n"+"Wiat list No."+WaitListCounter+"\n");
				l1.setText(l1.getText()+patients.get(h).toString()+"in the wait list\n=============================");
			}
		
			}

		
		ArrayList<patient> all =new ArrayList<patient>();
		all.addAll(Archive);
		all.addAll(patients);
		int condition=0;
	/*	while(condition==0) {
			System.out.print(" see patients history? write the ID or -1 to quit: ");
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
			
		}*/
	}

	public static void main(String[] args) {
		launch(args);
}

}//class








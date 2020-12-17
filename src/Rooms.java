import java.util.ArrayList;
import java.util.Random;


public class Rooms {
	private int RoomNumber;
 
ArrayList<Bed> AllBeds =new ArrayList<Bed>() ;


public Rooms(int number1,int number2) {
	
	this.RoomNumber=number1;
	AllBeds.add(new Bed(number2));
}


public int getRoomNumber() {
	return RoomNumber;
}

public void setRoomNumber(int roomNumber) {
	RoomNumber = roomNumber;
}

public String roomtype() {
	
	if (AllBeds.size()==1) {
	return "single";	
	}
	 else if(AllBeds.size()>1)  {
		return "shared";
	} 
	 else {
		 return "empty";
	 }
	
	
}

public void AddPatient(patient n) {
	for(int i=0;i<AllBeds.size();i++) {
		if(AllBeds.get(i).isOcupied().equals("empty")) {
		AllBeds.get(i).setOcupied(true); 
		n.setMyRoom(RoomNumber++);
		n.setMyBed(AllBeds.get(i).getBedNumber());
		n.AddHistory(" in this room : " +RoomNumber+ "\n in bed number : "+n.getMyBed() );
		break;
	}
	
	}	
}

@Override
public String toString() {
	return String.format("the number of the room is :%d"
			+ " \n and the number of beds inside the room :%d \n"
	+"=========================\n",RoomNumber,AllBeds.size());
	
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	/*private int number;
private double cost;
private int days;
private int min;
private int sec;
private int hour;
private int daysOfStaying=0;






//private int floor;
//private String location;


/*public int getFloor() {
return floor;
}
public void setFloor(int floor) {
this.floor = floor;
}
/*public String getLocation() {
return location;
}
public void setLocation(String location) {
this.location = location;
}


public Rooms(int number, double cost, int days, int min, int sec, int hour, int daysOfStaying) {
	super();
	this.number = number;
	this.cost = cost;
	this.days = days;
	this.min = min;
	this.sec = sec;
	this.hour = hour;
	this.daysOfStaying = daysOfStaying;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public int getDays() {
	return days;
}
public void setDays(int days) {
	this.days = days;
}
public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
public int getSec() {
	return sec;
}
public void setSec(int sec) {
	this.sec = sec;
}
public int getHour() {
	return hour;
}
public void setHour(int hour) {
	this.hour = hour;
}
public int getDaysOfStaying() {
	return daysOfStaying;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}

public String checkin() {
	String s="";
	//s=String.format(" the ", );
	
	return s;
}




public String checkout() {

	// there is a local vib.
	String s="";
	return s;
	
	// pay !!
}



public int changedaysOfStaying () {
	int s=0;
	return s;
}

*/


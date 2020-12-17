
public class Bed {
private  boolean ocupied;
private int BedNumber;


public Bed(int n) {
	this.ocupied = false;
	this.BedNumber=n;
}

public int getBedNumber() {
	return BedNumber;
}
public void setBedNumber(int bedNumber) {
	BedNumber = bedNumber;
}
public boolean issOcupied() {
	return ocupied;
}
public String isOcupied() {
if(ocupied==true) {
	return "ocupied";
}
else {
	return "empty";
}
	
}
public void setOcupied(boolean ocupied) {
	this.ocupied = ocupied;
}


//public abstract String BedInfo();
/*
public int getMobilty() {
	return mobilty;
}

public void setMobilty(int mobilty) {
	this.mobilty = mobilty;*/

}

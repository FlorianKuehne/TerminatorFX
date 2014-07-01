package logic;

import java.util.Date;

public class Aufgabe {

	String name,beschreibung,anmerkung;
	byte  wichtigkeit;  //länge 128
	//  Long ID;
	Date endTime,startTime;
	long duration;

	/*  private id() {
	  Math.random()
	  Rand
	  }
	 */
	public long duration() {
		long duration = endTime.getTime() - startTime.getTime();
		return duration;
	}
	
	
	//Gettger & Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getAnmerkung() {
		return anmerkung;
	}

	public void setAnmerkung(String anmerkung) {
		this.anmerkung = anmerkung;
	}

	public byte getWichtigkeit() {
		return wichtigkeit;
	}

	public void setWichtigkeit(byte wichtigkeit) {
		this.wichtigkeit = wichtigkeit;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	// Constructoren
	public Aufgabe(String name,Date start,Date end,String beschreibung,String anmerkung) {
		super();
		this.startTime = start;
		this.endTime = end;
		this.duration = this.duration();
		this.beschreibung= beschreibung;
		this.anmerkung= anmerkung;
		this.name = name;
	}
	public Aufgabe(String name) {
		this(name,new Date(0),new Date(0),"","");
		
	}

	public Aufgabe() {
		this("");
		//ID = iD;
	}
	
	@Override
	public String toString() {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(this.name);
		stringbuilder.append(String.format("%n"));
		stringbuilder.append(this.beschreibung+" ");
		//	stringbuilder.append(String.format("%n"));
		stringbuilder.append(this.anmerkung);
		stringbuilder.append(String.format("%n"));
		stringbuilder.append(this.endTime.toString());
		stringbuilder.append(String.format("  "));
		//	stringbuilder.append(String.format("%n"));
		stringbuilder.append(this.startTime.toString());
		stringbuilder.append(String.format("%n"));
		stringbuilder.append(this.wichtigkeit);
		String finalstring = stringbuilder.toString();
		return "Elternklasse "+super.toString()+", Aufgabe: "+finalstring;
	}


}

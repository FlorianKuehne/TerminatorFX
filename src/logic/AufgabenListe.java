package logic;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class AufgabenListe {

	ObservableList <Aufgabe> liste;
	boolean systemOutput;
	//List<Aufgabe> liste;
	//ObservableList<Aufgabe> observableListe;

	public void addAufgabe(Aufgabe aufgabe) {
		this.liste.add(aufgabe);
	}
	
	public void addAufgabe() {
		this.liste.add(new Aufgabe());
	}
	
	public int getSize() {
		return liste.size();
	}
	
	/** returns -1 if input doesent match the list	 */
	public Aufgabe getAufgabeNr(int indexNr) {
		if (indexNr<liste.size() && indexNr>=0 ) {
		return liste.get(indexNr);
		} else {
			return null;
		}
	}

	/**
	 * Gibt die Liste absteigend nach EndDatum sortiert zur�ck 
	 */
	//InstertionSort (war zumindest der Plan)
	public void sortForEndDate() {
		Aufgabe gespeicherteAufgabe;
		int j;
		for (int i=1;i<this.liste.size();i++) {
			gespeicherteAufgabe = this.liste.get(i);
			j=i;
			//WHILE: j > 1 and A[j-1] > einzusortierender_wert do {			
			while (j > 0 && this.liste.get(j-1).getEndTime().after(gespeicherteAufgabe.getEndTime())) {
				// A[j] <- A[j-1] 
				this.liste.set(j, this.liste.get(j-1));
				j--;
			}
			this.liste.set(j, gespeicherteAufgabe);
		}
		
	}
	
	/**
	 * Gibt die Liste aufsteigend nach StartDatum sortiert zur�ck 
	 */
	public void sortForStartDate() {
		Aufgabe gespeicherteAufgabe;
		int j;
		for (int i=1;i<this.liste.size();i++) {
			gespeicherteAufgabe = this.liste.get(i);
			j=i;
			//WHILE: j > 1 and A[j-1] > einzusortierender_wert do {			
			while (j > 0 && this.liste.get(j-1).getStartTime().before(gespeicherteAufgabe.getStartTime())) {
				// A[j] <- A[j-1] 
				this.liste.set(j, this.liste.get(j-1));
				j--;
			}
			this.liste.set(j, gespeicherteAufgabe);
		}
		//ListChangeListener.Change(ObservableList<observableListe> this.liste);
		//this.observableListe.wasPermutated()
		//ListChangeListener<Aufgabe>.changed()observableListe;
		//ListChangeListener.Change<Aufgabe>();
	//this.observableListe.sorted();
			
	}


	public void enableConsoleOut(){
		systemOutput=true;
	}
	public void disableConsoleOut(){
		systemOutput=false;
	}
	
	//Constructoren
	public AufgabenListe(Aufgabe aufgabe) {
		this();
		this.liste.add(aufgabe);
	}

	public AufgabenListe() {
		super();
		this.systemOutput=false;
		//this.liste = new ArrayList<Aufgabe>();
		//this.observableListe = FXCollections.observableList(liste);
		//this.observableListe.addListener(new ListChangeListener<Aufgabe>() {
		this.liste = FXCollections.observableList(new ArrayList<Aufgabe>());
		this.liste.addListener(new ListChangeListener<Aufgabe>()
			{

				@Override
				public void onChanged(javafx.collections.ListChangeListener.Change<? extends Aufgabe> c) {
					c.next();
					if (systemOutput==true){
					System.out.println("change!"+c.getAddedSubList());
					}
					if (c.wasPermutated() ){
						System.out.println("reinfolgegeändert");
					}
					if (c.wasUpdated() ){
						System.out.println("Updated");
					}
					if (c.wasRemoved()){
						System.out.println("Removed");
					}
					if (c.wasReplaced()){
						System.out.println("Replaced");
					}
				}
			} 
		);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Listen größe: "+liste.size()+String.format("%n"));
		for (int i=0;i<liste.size();i++) {
			stringBuilder.append(liste.get(i).toString());
			stringBuilder.append(String.format("%n"+"  ---------"));
		}
		stringBuilder.append(/*String.format("%n")+*/" END of LIST ");
		String finalString = stringBuilder.toString();
		return "Elternklasse "+super.toString()+", Liste: "+finalString;
	}
}

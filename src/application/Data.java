package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.AufgabenListe;
/**
 * 
 * @author Florian Kühne
 *
 * Diese Klasse enthält alle daten die verarbeitet werden können/sollen what so ever.. damit alle(s) darauf zugreifen kann
 * mit aussreichend respekt versteht sich. ^^ 
 * 
 */
public class Data {

	private ObservableList<AufgabenListe> aufgabenListenArray= FXCollections.observableArrayList();
	private boolean debug;

	public Data() {
		super();
		//TODO
		aufgabenListenArray.add(new AufgabenListe());
		this.debug=application.TerminatorFX.debug;
	}
	
	public void addAufgabenliste() {
		aufgabenListenArray.add(new AufgabenListe());
		if (debug==true){
			System.out.println("Aufgabenliste hinzugefügt");
			System.out.println(aufgabenListenArray.size());
			System.out.println(aufgabenListenArray);
		}
	}
	/**
	 * 
	 * @param aufgabenListenNummer - Indexnummer der Aufgabenliste welcher eine aufgabe hinzugefügt wird, elemente von 1 an...
	 */
	public void addAufgabe(int aufgabenListenNummer) {
		if (aufgabenListenArray.size()>(aufgabenListenNummer-1)){
		aufgabenListenArray.get(aufgabenListenNummer-1).addAufgabe();
		} else {
			System.out.println("Fehler, aufgabenliste existiert nicht");
		}
	}
	
	/** returns all the AufgabenLists */
	public ObservableList<AufgabenListe> getAufgabenListenArray(){
		return aufgabenListenArray;
	}
	
	public AufgabenListe getAufgabenListe(int indexNr){
		return aufgabenListenArray.get(indexNr);
	}
	
	public boolean getDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public int size() {
		return aufgabenListenArray.size();
	}
	
	
}

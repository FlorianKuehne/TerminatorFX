package controller;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.*;


public class UiController {
	//@FXML //alle FXML Elemente können durch die Annotation auf die Methode zugreifen, welcher Status (private,public,..) egal	
	//denn wenn "private" weggelassen, nicht deklariert ist, ist es auto private, denk ich.

	boolean debug;
	
	//TerminatorFX.fxml elemente
	@FXML Tab tabTermine;
	@FXML Tab tabSettings;
	
	@FXML public void addAufgabenListeClicked(ActionEvent event) throws IOException {
		Parent parent= getParent(event);	  		//returned das Elternelement vom Knopf (VBox, als Parent)
		HBox hbox=(HBox) parent.getParent();						//das ElternObject vom Parent wird zugreifbar (HBox)
		if (debug=true){
			System.out.println(parent);
			System.out.println(hbox);
			System.out.println(hbox.getChildren());
		}
		hbox.getChildren().add(FXMLLoader.load(getClass().getResource("/gui/AufgabenListePane.fxml")));
		hbox.getChildren().add(new Separator(Orientation.VERTICAL));
		application.TerminatorFX.daten.addAufgabenliste();
	}
	
//	private void clicked(ActionEvent event) {
//	    System.out.println("Button clicked" + event.toString()+"\nTarget:  " + event.getTarget() + "\nSource:  " + event.getSource());
//	   // if (event.getTarget().)
//	  }
	
	//UeberschriftZeile.fxml elemente
	@FXML Label ueberschriftLabel;
	@FXML Button sortUP;
	@FXML Button sortDown;
	@FXML Button addAufgabenListe;
	
	@FXML public void addAufgabeClicked(ActionEvent event) throws IOException {
		Parent uberschriftHbox= getParent(event);	  		//returned die HBox der Überschriftzeile (Elternelement von "+"-Button)
		VBox vbox=(VBox) uberschriftHbox.getParent();		//das ElternObject vom Überschritzeile wird zugreifbar (VBox)
		vbox.getChildren().add(FXMLLoader.load(getClass().getResource("/gui/TabellenElementGui.fxml"))); //die Box bekommt ein weiteres TabellenElementGUI Kind (ein Aufgabeneintrag)
		if (debug==true){
			System.out.println("1 "+vbox.toString());		//Der Vbox ihr "Name"
			System.out.println("2 "+vbox.getParent().getChildrenUnmodifiable());// Kinder der HBox, Vboxen & Separatoren
			System.out.println("3 "+vbox.getChildrenUnmodifiable());					//zeigt Kinder der VBox
//			System.out.println("4 "+vbox.getId());
			System.out.println("5 indexnummer der vbox: "+vbox.getParent().getChildrenUnmodifiable().indexOf(vbox));
		}
		int aufgabenListenNummer = vbox.getParent().getChildrenUnmodifiable().indexOf(vbox);
		aufgabenListenNummer=aufgabenListenNummer/2;
		if (debug==true){
			System.out.println(aufgabenListenNummer);
		}
		application.TerminatorFX.daten.addAufgabe(aufgabenListenNummer);		//In den Daten wird ein Objekt für die Aufgaben der Box hinzugefügt
	}

	//TabellenElemt.fxml emelente
	@FXML Button addAufgabe;
	@FXML Label startDate;
	@FXML DatePicker startDatePicker;
	@FXML Label endDate;
	@FXML DatePicker endDatePicker;
	@FXML TextField importanceValue;
	@FXML TextArea workDescription;
	@FXML Label Aufgabenbezeichnung;
	@FXML Button editAufgabenbezeichnungName;
	@FXML VBox tabellenEintragAufgabe;		//root Box
	
	@FXML public void sortForDateUp() {
		//TODO
	}

	@FXML public void sortForDateDown() {
		//TODO
	}

	//optional, definiert/ist definiert als, die Controller klasse der FXML datei(en?) 
	@FXML void initialize() {
	}
	
	/*
	 * gibt das Elternelement von betätigten, Events auslösenden Elementen wieder
	 */
	Parent getParent(ActionEvent event){
		Object source;
		if(debug==true){
			System.out.println("Source "+event.getSource() +"  +  Klassentyp"+ event.getSource().getClass());
		}
		String objektTyp=event.getSource().getClass().getName();//kompletter Klassenpfad der Quelle von Event
//		if(debug==true){
//			System.out.println(objektTyp);		//zum testen des Klassennamens von event
//		}
		//http://openbook.galileocomputing.de/javainsel/javainsel_04_008.html#dodtpb7c12b47-3234-4d45-967e-0e365a0e12e6
		if (objektTyp.matches("javafx.scene.control.*")){
			source= (Control) event.getSource(); //gibt das geklickte Object wieder, castet ihn zu Controll
		} else {
			System.out.println("Fehler: Parent nicht gefunden/implementiert von: "+objektTyp);
			return null;
		}
		Parent parent=((Parent) source).getParent();
		return parent;
	}
	
	public UiController() {
		super();
		this.debug = application.TerminatorFX.debug;
	}
}

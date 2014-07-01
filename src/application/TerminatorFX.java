package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;



public class TerminatorFX extends Application {
	
	public static boolean debug=true; //|false schaltet logging & testing aus
	public static Data daten;
	public static boolean testOnly;
	
	public static void main(String[] args) {
		
		//Variablen
		daten= new Data(); //Daten der Anwendung

		//Übergebene Argumente
		for (int i=0; i<=args.length;i++){
			if (args[i].contains("debug")){
				debug=true;
			}else{
				debug=false;
			}
			if (args[i].contains("testOnly")){
				testOnly=true;
			}else{
				testOnly=false;
			} 
		}
			
		//testing
		if (debug==true){
			//initalisierung vom Testing
			@SuppressWarnings("unused")
			//test.AufgabenListeTest listenTest = new test.AufgabenListeTest();
			test.TestClass testKlasse = new test.TestClass();  //Läd die Testverwaltungsklasse, alles Testing darin verwalten
		}
		
		/* ab hier Programm */
		//Fenster erzeugung, ruft wohl init() und dann start(Stage primaryStage).. auf. In Start wird das Hauptfenster erzeugt
		if (testOnly==false){
		Application.launch(args);
		}
	
	/* Nicht nötig so far
    // Give the controller access to the main app
    TerminatorFX controller = loader.getController();
    controller.setMainApp(this);
    */
	}
	
	@Override
	//Startet das Fenster (der ..FX teil)
	public void start(Stage primaryStage) throws Exception {
		Parent 	p= FXMLLoader.load(TerminatorFX.class.getResource("/gui/TerminatorFX.fxml"));
		Scene 	s= new Scene(p);
		primaryStage.setScene(s);
		primaryStage.setTitle("TerminatorFX");
		primaryStage.getIcons().add(new Image("file:resources/1398718753_calendar.png"));
		primaryStage.show();
	}
}


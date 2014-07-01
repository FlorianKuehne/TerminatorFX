package test;


public class DatenTest {
	application.Data datenTest;
	public boolean systemOut;
	
	public void enableDataOutput(){
		datenTest.setDebug(true);
		
	}
	
	public void disableDataOutput(){
		datenTest.setDebug(false);
	}
	
	public DatenTest() {
		super();
		this.datenTest= new application.Data();
		this.systemOut=false;
	}
	
	public DatenTest(boolean systemOut) {
		super();
		this.datenTest= new application.Data();
		this.systemOut= systemOut;
		}
	
	public void Zustand() {
		if (systemOut==true){
			System.out.println("AufgabenListenArray  zustand");
		}
		System.out.println(datenTest.getAufgabenListenArray());
	}
	
	public void addAufgabeListe() {
		if (systemOut==true){
			System.out.println("AddAufgabenliste ");
		}
		datenTest.addAufgabenliste();
	}
	
	public void addAufgabe(int nummer) {
		if (systemOut==true){
			System.out.println("add Aufgabe: Nummer "+nummer);
		}
		datenTest.addAufgabe(nummer);
	}
	
	public void getAufgabenListe(int indexNr){
		if (systemOut==true){
			System.out.println("getAufgabenListe index: "+indexNr);
		}
		System.out.println(datenTest.getAufgabenListe(indexNr));
	}
	
	public void getAufgabenListe(){
		if (systemOut==true){
			System.out.println("getAufgabenListe ");
		}
		System.out.println(datenTest.getAufgabenListenArray());
	}
	

}

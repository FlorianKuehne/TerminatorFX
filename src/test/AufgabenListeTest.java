package test;

import java.util.Date;

import logic.Aufgabe;
import logic.AufgabenListe;

public class AufgabenListeTest {


	AufgabenListe liste;

	public AufgabenListeTest() {
		super();
		liste = new AufgabenListe();
	}

	public void testAddAufgabe() {
		Date datum0= new Date(0);
		Date datum1= new Date(34345);
		Date datum3= new Date(1000050);
		Date datum2= new Date(100000000);
		Date datum4= new Date (23498920);
		Aufgabe aufgabe4 = new Aufgabe("fünf",datum4,datum4,"","");
		Aufgabe aufgabe5 = new Aufgabe("null",datum0,datum0,"","");
		Aufgabe aufgabe6 = new Aufgabe("eins",datum1,datum1,"","");
		Aufgabe aufgabe7 = new Aufgabe("zwei",datum2,datum2,"","");
		Aufgabe aufgabe8 = new Aufgabe("drei",datum3,datum3,"","");
		Aufgabe aufgabe9 = new Aufgabe("vier",datum4,datum4,"","");
		AufgabenListe liste = new AufgabenListe(aufgabe4);
		liste.addAufgabe(aufgabe5);
		liste.addAufgabe(aufgabe6);
		liste.addAufgabe(aufgabe7);
		liste.addAufgabe(aufgabe8);
		liste.addAufgabe(aufgabe9);
	}

	public void testAddAufgabeExtended() {
		Aufgabe aufgabe1 = new Aufgabe();
		Aufgabe aufgabe2 = new Aufgabe("*");
		Aufgabe aufgabe3 = new Aufgabe("aufgabe3");
		Date datum0= new Date(0);
		Date datum1= new Date(34345);
		Date datum3= new Date(1000050);
		Date datum2= new Date(100000000);
		Date datum4= new Date (23498920);
		Aufgabe aufgabe4 = new Aufgabe("f�nf",datum4,datum4,"","");
		Aufgabe aufgabe5 = new Aufgabe("null",datum0,datum0,"","");
		Aufgabe aufgabe6 = new Aufgabe("eins",datum1,datum1,"","");
		Aufgabe aufgabe7 = new Aufgabe("zwei",datum2,datum2,"","");
		Aufgabe aufgabe8 = new Aufgabe("drei",datum3,datum3,"","");
		Aufgabe aufgabe9 = new Aufgabe("vier",datum4,datum4,"","");
		AufgabenListe liste1 = new AufgabenListe();
		AufgabenListe liste2 = new AufgabenListe(aufgabe3);
		AufgabenListe liste3 = new AufgabenListe();
		AufgabenListe liste = new AufgabenListe(aufgabe4);
		liste.addAufgabe(aufgabe5);
		liste.addAufgabe(aufgabe6);
		liste.addAufgabe(aufgabe7);
		liste.addAufgabe(aufgabe8);
		liste.addAufgabe(aufgabe9);
		liste1.addAufgabe(aufgabe1);
		liste1.addAufgabe(aufgabe3);
		liste1.addAufgabe(aufgabe2);
		liste2.addAufgabe(aufgabe3);
		liste2.addAufgabe(aufgabe2);
		liste2.addAufgabe(aufgabe1);


		System.out.println(aufgabe1.toString());
		System.out.println(aufgabe2.toString());
		System.out.println(aufgabe3.toString());
		System.out.println();
		System.out.println(liste1.toString());
		System.out.println(liste2.toString());
		System.out.println(liste3.toString());
	}

	public void testSorting() {
		System.out.println(liste.toString());
		liste.sortForEndDate();
		System.out.println(liste.toString());
		liste.sortForStartDate();
		System.out.println(liste.toString());
		liste.sortForStartDate();
		System.out.println(liste.toString());
	}


}
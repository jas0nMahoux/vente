package fr.jmahoux.vente.model;

import java.util.Scanner;

public class Owner {

    private String firstname;

    private String lastname;

    private int phoneNumber;


    public Owner(String firstname, String lastname, int phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }


    public Owner() {

        System.out.println("Entrez votre prénom : ");
        Scanner scannerFirstname = new Scanner(System.in);
        this.firstname = scannerFirstname.next();

        System.out.println("Entrez votre nom : ");
        Scanner scannerLastName = new Scanner(System.in);
        this.lastname = scannerLastName.next();

        System.out.println("Entrez votre téléphone : ");
        Scanner scannerPhone = new Scanner(System.in);
        this.phoneNumber = scannerPhone.nextInt();
    }
}

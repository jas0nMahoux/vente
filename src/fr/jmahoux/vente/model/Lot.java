package fr.jmahoux.vente.model;

import java.util.Scanner;

public class Lot {

    private int id;

    private int beginPrice;

    private String description;

    private double weight;

    private Owner owner;

    private int sellPrice;

    private int currentPrice;


    public Lot(int id, int beginPrice, String description, double weight, Owner owner) {
        this.beginPrice = beginPrice;
        this.description = description;
        this.weight = weight;
        this.owner = owner;
        this.currentPrice = 0;
    }

    public Lot(int id) {
        this.id = id;

        System.out.println("A combien voulez vous démarer vos enchères ? ");
        Scanner scannerBeginPrice = new Scanner(System.in);
        this.beginPrice = scannerBeginPrice.nextInt();
        this.currentPrice = this.beginPrice;

        System.out.println("Entrez une description pour votre lot : ");
        Scanner scannerDescription = new Scanner(System.in);
        this.description = scannerDescription.next();

        System.out.println("Entrez un poid à votre lot : ");
        Scanner scannerWeight = new Scanner(System.in);
        this.weight = scannerWeight.nextInt();

        System.out.println("Creer votre profil de vendeur : ");
        Scanner scannerOwner = new Scanner(System.in);
        this.owner = new Owner();
    }


    public int getBeginPrice() {
        return beginPrice;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getId() {
        return this.id;
    }

    public int getSellPrice() {
        return this.sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getCurrentPrice() {
        return this.currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        if (this.currentPrice > currentPrice) {
            System.out.println("Le prix proposé doit être suppérieur au prix courant");
            return;
        }
        this.currentPrice = currentPrice;
    }

    public String sellToString() {
        return "Le lot numéro " + this.getId() +" a été vendu pour " + this.getSellPrice();
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", beginPrice=" + beginPrice +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", owner=" + owner +
                '}';
    }
}

package fr.jmahoux.vente.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sale {

    private List<Lot> lots = new ArrayList<>();

    public Sale() {
        startSale();
    }

    public List getLots() {
        return lots;
    }

    public Boolean isEmpty() {
        return this.lots.size() == 0;
    }

    public void startCreateLot() {
        int idLot = 1;

        System.out.println("Il y a 0 lot prévu pour cette enchère, création du lot numéro 1 :");
        String stopCreation = "";

        while (!stopCreation.equals("stopCreation")) {

            this.lots.add(new Lot(idLot));
            Scanner scannerContinue = new Scanner(System.in);
            System.out.println("Voulez vous continuer ? OUI / NON ");
            if (scannerContinue.next().equals("NON")) {
                stopCreation = "stopCreation";
            }
            idLot++;

        }
    }

    public void startSale() {

        if (isEmpty()) {
            startCreateLot();
        }

        this.lots.forEach(lot -> {

            String stop = "";

            System.out.println("Mise aux enchères du lot numéro " + lot.getId());
            System.out.println(lot.getDescription());
            System.out.println("Début des enchères à " + lot.getBeginPrice());

            while (!stop.equals("stop")) {
                Scanner scannerPrix = new Scanner(System.in);
                System.out.println("Proposer un prix : ");
                String input = scannerPrix.nextLine();// nextLine ET parseInt
                if (input.equals("stop")) {
                    lot.setSellPrice(lot.getCurrentPrice());
                    stop = "stop";
                } else {
                    try {
                        lot.setCurrentPrice(Integer.parseInt(input));
                    } catch (NumberFormatException e) {
                        System.out.println("Les lettres ne sont pas autorisé \nil faut entrer des chiffres");
                    }

                }
            }
            System.out.println(lot.sellToString());
            lot.setSellPrice(lot.getSellPrice());
        });
    }

    public void display() {
        this.lots.forEach(lot -> {
            System.out.println(lot.toString());
        });
    }

}



import java.util.Scanner;

/**
 * Chooser
 * 
 * Questa classe gestisce l'interazione con l'utente per la selezione di
 * opzioni.
 * 
 * @author: Pintescul Patric - Eletr Shehab Ali Latif Ali
 * @version: 1.0
 */
public class Chooser {
    public static Scanner sc = new Scanner(System.in);
    private String[] choices;

    /**
     * Costruttore della classe Chooser.
     * 
     * @param choices Un array di stringhe rappresentanti le opzioni disponibili.
     */
    public Chooser(String[] choices) {
        this.choices = choices;
    }

    /**
     * Restituisce le opzioni disponibili.
     * 
     * @return Un array di stringhe contenente le opzioni.
     */
    public String[] getChoices() {
        return choices;
    }

    /**
     * Imposta le opzioni disponibili.
     * 
     * @param choices Un array di stringhe rappresentanti le opzioni.
     */
    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    /**
     * Consente all'utente di selezionare un'opzione e restituisce l'indice dell'opzione selezionata.
     * 
     * @return L'indice dell'opzione selezionata (1 - numero di opzioni).
     */
    public int choose() {
        int maxSize = 0;

        // Calcola la lunghezza massima tra le opzioni per la formattazione
        for (String string : choices) {
            if (maxSize < string.length())
                maxSize = string.length();
        }
        // Aggiungi spazio per numerazione e bordi
        maxSize += Integer.toString(choices.length).length() + 3;
        System.out.println("*" + "-".repeat(maxSize) + "*");

        // Visualizza le opzioni con numerazione
        for (int i = 0; i < choices.length; i++) {
            System.out.println("|" + (i + 1) + ". " + choices[i]);
        }
        System.out.println("*" + "-".repeat(maxSize) + "*");
        int choice;

        // Richiedi all'utente di selezionare un'opzione valida
        do {
            try {
                System.out.print(String.format(" Seleziona (1-%s) >>> ", choices.length));
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Errore durante il recupero dell'input, riprova.");
                choice = 0;
            }
        } while (choice < 1 || choice > choices.length);
        return choice;
    }
}
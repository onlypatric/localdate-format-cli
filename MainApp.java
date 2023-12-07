import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

/**
 * MainApp - Entry point of the application.
 */
public class MainApp {

    /**
     * CLI Interface to collect every class of the app (unit test case)
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Instantiate a DateValidator and Chooser
        DateValidator d = null;
        Chooser c = new Chooser(new String[] {
                "Stampa in formato IT",
                "Stampa il giorno della settimana in Italiano",
                "Stampa il giorno del mese in Italiano",
                "Stampa la data successiva in formato IT",
                "Stampare la data dopo X giorni in formato IT",
                "Quanti giorni mancano per una data futura"
        });

        // Loop to collect a valid date from the user
        do {
            try {
                System.out.print("Inserisci una data (gg/mm/aaaa): ");
                d = new DateValidator(Chooser.sc.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (d == null);

        // Choose an operation based on user input
        int selector = c.choose() - 1;
        int offsetDaysSelection = -1;
        DateValidator secondDate = null;

        switch (selector) {
            case 0:
                System.out.println(d.getDateEUFormat());
                break;
            case 1:
                System.out.println(d.getDayOfWeekAsString());
                break;
            case 2:
                System.out.println(d.getMonthAsString());
                break;
            case 3:
                System.out.println(addDays(d, 1));
                break;
            case 4:
                // Calculate date after adding X days
                while (offsetDaysSelection < 0 || offsetDaysSelection > 365) {
                    try {
                        System.out.print("Inserisci il numero di giorni da calcolare: ");
                        offsetDaysSelection = Integer.parseInt(Chooser.sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Errore durante l'inserimento, ritenta...");
                    }
                }
                System.out.println(addDays(d, offsetDaysSelection));
                break;
            case 5:
                // Collect a second date from the user
                do {
                    try {
                        System.out.print("Inserisci una seconda data (gg/mm/aaaa): ");
                        secondDate = new DateValidator(Chooser.sc.nextLine());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (secondDate == null);

                // Calculate the difference in days between the two dates
                long daysDifference = ChronoUnit.DAYS.between(d.getLocalDate(), secondDate.getLocalDate());
                System.out.printf("La differenza di giorni tra %s e %s è pari a %s\n",d.getDateEUFormat(),secondDate.getDateEUFormat(),daysDifference);
        }

        // Close the Scanner
        Chooser.sc.close();
    }

    /**
     * Adds a specified number of days to a given date and returns the result as a formatted string.
     *
     * @param d    The DateValidator object representing the initial date.
     * @param days The number of days to add.
     * @return A string representation of the date after adding the specified number of days.
     */
    public static String addDays(DateValidator d, int days) {
        return d.getLocalDate().plusDays(days).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}

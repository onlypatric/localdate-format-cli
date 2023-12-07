# Italian Date Utility App

This Java application provides a Command-Line Interface (CLI) for working with dates in the Italian language. It includes various functionalities to manipulate and display date-related information.

## Usage

1. **Run the Application:**
   - Compile and run the `MainApp` class to start the CLI interface.

2. **Choose an Operation:**
   - The CLI will prompt you to choose from the following options:
     1. Stampa in formato IT (Print in IT format)
     2. Stampa il giorno della settimana in Italiano (Print the day of the week in Italian)
     3. Stampa il giorno del mese in Italiano (Print the day of the month in Italian)
     4. Stampa la data successiva in formato IT (Print the next date in IT format)
     5. Stampare la data dopo X giorni in formato IT (Print the date after adding X days in IT format)
     6. Quanti giorni mancano per una data futura (How many days until a future date)

3. **Input a Date:**
   - Enter a date in the format (gg/mm/aaaa) when prompted.

4. **Review Output:**
   - The application will provide the result based on your chosen operation.

## Operations

- **Print in IT Format:**
  - Displays the current date in European (EU) format (dd-mm-yyyy).

- **Print Day of the Week in Italian:**
  - Prints the day of the week for the given date in Italian.

- **Print Month in Italian:**
  - Prints the month for the given date in Italian.

- **Print Next Date in IT Format:**
  - Displays the date following the current date in European (EU) format.

- **Print Date After Adding X Days in IT Format:**
  - Prompts for the number of days (X) and displays the date after adding X days in European (EU) format.

- **Calculate Days Until a Future Date:**
  - Prompts for a second date and calculates the difference in days between the two dates.

## Dependencies

- This application uses the `java.time` package for date manipulation.
- Input is collected using the `Scanner` class.

## Build and Run

- Compile and run the `MainApp` class using a Java compiler.

## Author

- Pintescul Patric

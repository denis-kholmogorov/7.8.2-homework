import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat simpleformat = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.HOUR, 2);
        Date afterTwoHours = calendar.getTime();

        Airport airport = Airport.getInstance();
        List <Terminal> terminals = airport.getTerminals();
        List <Flight> flights = new ArrayList<>();

        for (Terminal terminal: terminals){
            terminal.getFlights().stream().forEach(flights::add);
        }

        flights.stream().filter(f -> f.getDate().after(now) && f.getDate().before(afterTwoHours))
               .sorted(Comparator.comparing(Flight::getDate))
               .forEach(flight -> System.out.println(simpleformat.format(flight.getDate()) + " - " + flight.getAircraft()));


    }
}

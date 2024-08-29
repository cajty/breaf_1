import java.util.Date;
import java.util.List;

public class User {
    private final String name;
    private final int id;
    private List<Reservation> reservations;
    public User() {
        this.name = "ayoub";
        this.id = 1;

    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }




    public String createReservation(Date dateStart, Date dateEnd) {

        Reservation reservation = new Reservation();
        this.reservations.add(reservation);
        return reservation.toString();
    }
}

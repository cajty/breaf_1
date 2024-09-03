import java.time.LocalDate;


public class Reservation {
    private int idReservation;
    private int idUser;
    private Integer idRoom;
    private LocalDate dateStart;
    private LocalDate dateEnd;

    // Constructor
    public Reservation(Integer idReservation,Integer idUser, Integer idRoom, LocalDate dateStart, LocalDate dateEnd) {
        this.idReservation = idReservation;
        this.idUser = idUser;
        this.idRoom = idRoom;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    // Getters
    public Integer getIdReservation() {
        return idReservation;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    // Setters
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }
    @Override
    public String toString() {
        return "\n_______________________" +
                "\nReservation id :  =  " + idReservation +
                "\nroom = " + idRoom +
                "\ndate Start = " + dateStart +
                "\ndate End = " + dateEnd +
                "\n_______________________"
                ;
    }
}

import java.util.Date;

public class Reservation {
    private int idReservation;
    private int idUser;
    private Integer idRoom;
    private Date dateStart;
    private Date dateEnd;

    // Constructor
    public Reservation(Integer idReservation,Integer idUser, Integer idRoom, Date dateStart, Date dateEnd) {
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

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    // Setters
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    @Override
    public String toString() {
        return "Reservation : \n id  =  " + idReservation +
                "\n, room = " + idRoom +
                "\n  date Start = " + dateStart +
                "\n  date End = " + dateEnd
                ;
    }
}

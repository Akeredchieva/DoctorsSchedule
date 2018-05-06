package diplomna.entities;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "patients_times")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;

    public Time(Date date, Patients patient) {
        this.date = date;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }
}

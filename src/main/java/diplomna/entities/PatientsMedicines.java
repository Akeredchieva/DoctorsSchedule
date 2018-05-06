package diplomna.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patients_medicines")
public class PatientsMedicines implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicines medicine;

    @Column(name = "start_date",nullable = false)
    private String startDate;

    @Column(name = "end_date")
    private String endDate;
    private String description;

    public PatientsMedicines(Patients patient, Medicines medicine, String startDate) {
        this.setPatient(patient);
        this.setMedicine(medicine);
        this.setStartDate(startDate);
    }

    public PatientsMedicines(Patients patient, Medicines medicine, String startDate, String description) {
        this.setPatient(patient);
        this.setMedicine(medicine);
        this.setStartDate(startDate);
        this.setDescription(description);
    }
    public PatientsMedicines(Patients patient, Medicines medicine, String startDate,String endDate, String description) {
        this.setPatient(patient);
        this.setMedicine(medicine);
        this.setStartDate(startDate);
        this.setDescription(description);
        this.setEndDate(endDate);
    }
    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Medicines getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicines medicine) {
        this.medicine = medicine;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ApplicantDetails {
    public String fname;
    public String lname;
    public LocalDate dob;
    public String country;
    public String city;
    public String quali;
    public String intrper;
	public String dobFormatted;

    public ApplicantDetails(String fname, String lname, LocalDate dob, String country, String city, String quali, String intrper) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.dobFormatted = dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.country = country;
        this.city = city;
        this.quali = quali;
        this.intrper = intrper;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getQuali() {
        return quali;
    }

    public String getIntrper() {
    	return intrper;
    }
    public LocalDate getDob() {
        return dob;
    }

    public String getDobFormatted() {
        return dobFormatted;
    }

    }
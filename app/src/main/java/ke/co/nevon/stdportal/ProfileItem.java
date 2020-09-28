package ke.co.nevon.stdportal;

public class ProfileItem {
    String username,program,year,regNo,nationalId,contact,email;

    public ProfileItem(String username, String program, String year, String regNo, String nationalId, String contact, String email) {
        this.username = username;
        this.program = program;
        this.year = year;
        this.regNo = regNo;
        this.nationalId = nationalId;
        this.contact = contact;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getProgram() {
        return program;
    }

    public String getYear() {
        return year;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

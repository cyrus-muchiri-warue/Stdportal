package ke.co.nevon.stdportal;

public class LecturerDetails {
    String name,contact1,contact2,email,office,building;

    public LecturerDetails(String name, String contact1, String contact2, String email, String office, String building) {
        this.name = name;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.email = email;
        this.office = office;
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}

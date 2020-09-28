package ke.co.nevon.stdportal;

public class UnitDetails {
    String unitname,unitcode,status;

    public UnitDetails(String unitname, String unitcode, String status) {
        this.unitname = unitname;
        this.unitcode = unitcode;
        this.status = status;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

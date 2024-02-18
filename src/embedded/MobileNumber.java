package embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MobileNumber {
    @Column(name = "mobile_no_type")
    private String type;

    @Column(name = "mobile_number")
    private String mobileNumber;

    public MobileNumber() {
    }

    public MobileNumber(String type, String mobileNumber) {
        this.type = type;
        this.mobileNumber = mobileNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "MobileNumber{" +
                "type='" + type + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}

package projection;

public class CustomerProjection {
    private int cusId;
    private String name;

    public CustomerProjection() {
    }

    public CustomerProjection(int cusId, String name) {
        this.cusId = cusId;
        this.name = name;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerProjection{" +
                "cusId=" + cusId +
                ", name='" + name + '\'' +
                '}';
    }
}

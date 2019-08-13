package by.pvt.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "mouse")
public class Mouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "id", strategy = "increment")
    private int id;

    @Column
    private String type;

    @Column
    private double price;

    @Column
    private Date dateOfBuying;

    @Column
    private int warrantyMonth;

    Mouse() {
    }

    Mouse(int id, String type, double price, Date dateOfBuying, int warrantyMonth) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.dateOfBuying = dateOfBuying;
        this.warrantyMonth = warrantyMonth;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    public Date getDateOfBuying() {
        return dateOfBuying;
    }

    void setDateOfBuying(Date dateOfBuying) {
        this.dateOfBuying = dateOfBuying;
    }

    public int getWarrantyMonth() {
        return warrantyMonth;
    }

    void setWarrantyMonth(int warrantyMonth) {
        this.warrantyMonth = warrantyMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mouse mouse = (Mouse) o;

        if (id != mouse.id) return false;
        if (Double.compare(mouse.price, price) != 0) return false;
        if (warrantyMonth != mouse.warrantyMonth) return false;
        if (type != null ? !type.equals(mouse.type) : mouse.type != null) return false;
        return dateOfBuying != null ? dateOfBuying.equals(mouse.dateOfBuying) : mouse.dateOfBuying == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dateOfBuying != null ? dateOfBuying.hashCode() : 0);
        result = 31 * result + warrantyMonth;
        return result;
    }
}

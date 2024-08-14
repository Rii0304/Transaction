package transaction.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "owner_name")
    private String name;
    private double balance;
    @Column(name = "access_time")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date accessTime;
    private boolean looked;
    public AccountEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public boolean isLooked() {
        return looked;
    }

    public void setLooked(boolean looked) {
        this.looked = looked;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", accessTime=" + accessTime +
                ", looked=" + looked +
                '}';
    }
}

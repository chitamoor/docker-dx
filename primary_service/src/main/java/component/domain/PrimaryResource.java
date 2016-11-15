package component.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PrimaryResource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    //@Column(name = "attribute_one", nullable = false)
    private String attributeOne;

    //@Column(name = "attribute_one", nullable = false)
    private String attributeTwo;

    @Column(name="date_created")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

    @Column(name="date_modified")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateModified;

    public PrimaryResource() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAttributeOne() {
        return attributeOne;
    }

    public void setAttributeOne(String attributeOne) {
        this.attributeOne = attributeOne;
    }

    public String getAttributeTwo() {
        return attributeTwo;
    }

    public void setAttributeTwo(String attributeTwo) {
        this.attributeTwo = attributeTwo;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }


    @Override
    public String toString() {
        return "PrimaryServiceData{" +
                "id=" + id +
                ", attributeOne='" + attributeOne + '\'' +
                ", attributeTwo='" + attributeTwo + '\'' +
                '}';
    }
}

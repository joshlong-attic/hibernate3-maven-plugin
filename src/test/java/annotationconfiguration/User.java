package annotationconfiguration;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "users")
public class User
{
    private Date creationDate;

    private String email;

    private Date modificationDate;

    private String username;

    @Column(name = "creation_date", nullable = false)
    public Date getCreationDate()
    {
        return creationDate;
    }

    @Column(name = "email_address", length = 40, unique = true, nullable = false)
    public String getEmail()
    {
        return email;
    }

    @Column(name = "modification_date", nullable = false)
    public Date getModificationDate()
    {
        return modificationDate;
    }

    @Id
    @Column(name = "username")
    public String getUsername()
    {
        return username;
    }

    public void setCreationDate( Date creationDate )
    {
        this.creationDate = creationDate;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public void setModificationDate( Date modificationDate )
    {
        this.modificationDate = modificationDate;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }
}

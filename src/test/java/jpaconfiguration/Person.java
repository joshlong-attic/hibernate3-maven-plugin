package jpaconfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Person
    implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }
}
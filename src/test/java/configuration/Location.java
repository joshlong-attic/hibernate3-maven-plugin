package configuration;

import java.io.Serializable;
import java.util.Locale;

public class Location
    implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int streetNumber;

    private String city;

    private String streetName;

    private String countryCode;

    private Locale locale;

    private String description;

    public boolean equals( Object other )
    {
        Location l = (Location) other;
        return l.getCity().equals( city ) && l.getStreetName().equals( streetName ) &&
            l.getCountryCode().equals( countryCode ) && l.getStreetNumber() == streetNumber;
    }

    public int hashCode()
    {
        return streetName.hashCode();
    }

    /**
     * Returns the city.
     *
     * @return String
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city The city to set
     */
    public void setCity( String city )
    {
        this.city = city;
    }

    /**
     * Returns the countryCode.
     *
     * @return String
     */
    public String getCountryCode()
    {
        return countryCode;
    }

    /**
     * Sets the countryCode.
     *
     * @param countryCode The countryCode to set
     */
    public void setCountryCode( String countryCode )
    {
        this.countryCode = countryCode;
    }

    /**
     * Returns the description.
     *
     * @return String
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description The description to set
     */
    public void setDescription( String description )
    {
        this.description = description;
    }

    /**
     * Returns the locale.
     *
     * @return Locale
     */
    public Locale getLocale()
    {
        return locale;
    }

    /**
     * Sets the locale.
     *
     * @param locale The locale to set
     */
    public void setLocale( Locale locale )
    {
        this.locale = locale;
    }

    /**
     * Returns the streetName.
     *
     * @return String
     */
    public String getStreetName()
    {
        return streetName;
    }

    /**
     * Sets the streetName.
     *
     * @param streetName The streetName to set
     */
    public void setStreetName( String streetName )
    {
        this.streetName = streetName;
    }

    /**
     * Returns the streetNumber.
     *
     * @return int
     */
    public int getStreetNumber()
    {
        return streetNumber;
    }

    /**
     * Sets the streetNumber.
     *
     * @param streetNumber The streetNumber to set
     */
    public void setStreetNumber( int streetNumber )
    {
        this.streetNumber = streetNumber;
    }
}
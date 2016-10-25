package yahoofinancexml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rate {
    @XmlAttribute   private String id;

    @XmlElement
    private String Name;
    @XmlElement
    private double Rate;
    @XmlElement
    private String Date;
    @XmlElement
    private String Time;
    @XmlElement
    private String Ask;
    @XmlElement
    private String Bid;

}

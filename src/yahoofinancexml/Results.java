package yahoofinancexml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Results {
    @XmlElement
    public Rate[] rate;
}

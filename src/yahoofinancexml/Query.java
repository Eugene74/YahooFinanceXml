package yahoofinancexml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Query {
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")    private int count;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")    private String created;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")    private String lang;

    @XmlElement
    private Results results;
}

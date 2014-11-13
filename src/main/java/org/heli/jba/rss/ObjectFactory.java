//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.11.08 时间 10:22:10 PM EST 
//


package org.heli.jba.rss;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.heli.jba.rss package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Rss_QNAME = new QName("", "rss");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.heli.jba.rss
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TRss }
     * 
     */
    public TRss createTRss() {
        return new TRss();
    }

    /**
     * Create an instance of {@link TTextInput }
     * 
     */
    public TTextInput createTTextInput() {
        return new TTextInput();
    }

    /**
     * Create an instance of {@link TSource }
     * 
     */
    public TSource createTSource() {
        return new TSource();
    }

    /**
     * Create an instance of {@link TRssItem }
     * 
     */
    public TRssItem createTRssItem() {
        return new TRssItem();
    }

    /**
     * Create an instance of {@link TCategory }
     * 
     */
    public TCategory createTCategory() {
        return new TCategory();
    }

    /**
     * Create an instance of {@link TImage }
     * 
     */
    public TImage createTImage() {
        return new TImage();
    }

    /**
     * Create an instance of {@link TCloud }
     * 
     */
    public TCloud createTCloud() {
        return new TCloud();
    }

    /**
     * Create an instance of {@link TRssChannel }
     * 
     */
    public TRssChannel createTRssChannel() {
        return new TRssChannel();
    }

    /**
     * Create an instance of {@link TGuid }
     * 
     */
    public TGuid createTGuid() {
        return new TGuid();
    }

    /**
     * Create an instance of {@link TEnclosure }
     * 
     */
    public TEnclosure createTEnclosure() {
        return new TEnclosure();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRss }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rss")
    public JAXBElement<TRss> createRss(TRss value) {
        return new JAXBElement<TRss>(_Rss_QNAME, TRss.class, null, value);
    }

}

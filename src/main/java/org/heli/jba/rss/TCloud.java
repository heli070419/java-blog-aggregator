//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.11.08 时间 10:22:10 PM EST 
//


package org.heli.jba.rss;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a web service that supports the rssCloud interface which can be implemented in HTTP-POST, XML-RPC or SOAP 1.1. 
 * Its purpose is to allow processes to register with a cloud to be notified of updates to the channel, implementing a lightweight publish-subscribe protocol for RSS feeds.
 * 
 * <p>tCloud complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="tCloud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="domain" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="port" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="path" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="registerProcedure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="protocol" use="required" type="{}tCloudProtocol" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCloud")
public class TCloud {

    @XmlAttribute(name = "domain", required = true)
    protected String domain;
    @XmlAttribute(name = "port", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger port;
    @XmlAttribute(name = "path", required = true)
    protected String path;
    @XmlAttribute(name = "registerProcedure", required = true)
    protected String registerProcedure;
    @XmlAttribute(name = "protocol", required = true)
    protected TCloudProtocol protocol;

    /**
     * 获取domain属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 设置domain属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * 获取port属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPort() {
        return port;
    }

    /**
     * 设置port属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPort(BigInteger value) {
        this.port = value;
    }

    /**
     * 获取path属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置path属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * 获取registerProcedure属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterProcedure() {
        return registerProcedure;
    }

    /**
     * 设置registerProcedure属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterProcedure(String value) {
        this.registerProcedure = value;
    }

    /**
     * 获取protocol属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TCloudProtocol }
     *     
     */
    public TCloudProtocol getProtocol() {
        return protocol;
    }

    /**
     * 设置protocol属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TCloudProtocol }
     *     
     */
    public void setProtocol(TCloudProtocol value) {
        this.protocol = value;
    }

}

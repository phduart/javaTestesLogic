//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.04 at 01:01:40 PM EDT 
//


package br.com.projectSpringForTest.GNRE.retornoConsultaConfig;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TTipoValor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TTipoValor"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="T"/&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="PO"/&gt;
 *     &lt;enumeration value="TO"/&gt;
 *     &lt;enumeration value="AO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TTipoValor")
@XmlEnum
public enum TTipoValor {

    P,
    T,
    A,
    N,
    PO,
    TO,
    AO;

    public String value() {
        return name();
    }

    public static TTipoValor fromValue(String v) {
        return valueOf(v);
    }

}

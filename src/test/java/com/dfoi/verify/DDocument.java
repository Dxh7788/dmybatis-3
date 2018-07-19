package com.dfoi.verify;

import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by mybatis
 *
 * @author xh.d
 * @since 2018/7/18 18:29
 */
public class DDocument {
    @Test
    public void testCreateDocument() throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = loader.getResourceAsStream("org/apache/ibatis/builder/MapperConfig.xml");
        InputSource reader = new InputSource(inputStream);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(false);
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(false);
        factory.setCoalescing(false);
        factory.setExpandEntityReferences(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new XMLMapperEntityResolver());
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void error(SAXParseException exception) throws SAXException {
                throw exception;
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                throw exception;
            }

            @Override
            public void warning(SAXParseException exception) throws SAXException {
            }
        });
        Document document = builder.parse(reader);
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        Node node = (Node)xpath.evaluate("/configuration", document, XPathConstants.NODE);
        if (node!=null){
            //解析resources
            Node propertiesNode = (Node)xpath.evaluate("/properties", document, XPathConstants.NODE);
        }
    }
}

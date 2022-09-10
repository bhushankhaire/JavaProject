package com.basic.design.patterns.creational.factory;

import com.basic.design.patterns.creational.factory.documents.XMLDocument;

public class XMLDocumentViewer implements DataTypeDocumentViewer<XMLDocument> {

    @Override
    public void readDocument(XMLDocument xmlDocument) {
        xmlDocument.read();
    }
}

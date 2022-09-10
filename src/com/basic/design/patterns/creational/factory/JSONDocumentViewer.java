package com.basic.design.patterns.creational.factory;

import com.basic.design.patterns.creational.factory.documents.JSONDocument;

public class JSONDocumentViewer implements DataTypeDocumentViewer<JSONDocument> {

    @Override
    public void readDocument(JSONDocument jsonDocument) {
        jsonDocument.read();
    }
}

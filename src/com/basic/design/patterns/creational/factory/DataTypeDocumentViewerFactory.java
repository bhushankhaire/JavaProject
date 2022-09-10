package com.basic.design.patterns.creational.factory;

import com.basic.design.patterns.creational.factory.documents.JSONDocument;
import com.basic.design.patterns.creational.factory.documents.XMLDocument;

public class DataTypeDocumentViewerFactory implements AbstractDocumentViewer<DataTypeDocumentViewer> {


    public DataTypeDocumentViewer getDocumentViewer(DocType docType) {
        DataTypeDocumentViewer viewer = null;
        switch (docType) {
            case XML:
                viewer = new XMLDocumentViewer();
                break;
            case JSON:
                viewer = new JSONDocumentViewer();
                break;
        }
        return viewer;
    }

    public static void main(String[] args) {
        DataTypeDocumentViewerFactory factory=new DataTypeDocumentViewerFactory();
        DataTypeDocumentViewer viewer= factory.getDocumentViewer(DocType.JSON);
        viewer.readDocument(new JSONDocument());
        viewer= factory.getDocumentViewer(DocType.XML);
        viewer.readDocument(new XMLDocument());
    }

}

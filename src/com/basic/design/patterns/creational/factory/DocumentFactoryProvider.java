package com.basic.design.patterns.creational.factory;

import com.basic.design.patterns.creational.factory.documents.JSONDocument;
import com.basic.design.patterns.creational.factory.documents.PDFDocument;

public class DocumentFactoryProvider {

    public static AbstractDocumentViewer getFactory(DocType docType){

        AbstractDocumentViewer viewer = null;
        switch (docType) {
            case DATATYPE:
                viewer = new DataTypeDocumentViewerFactory();
                break;
            case FILETYPE:
                viewer = new FileTypeDocumentViewerFactory();
                break;
        }
        return viewer;
    }

    public static void main(String[] args) {
       JSONDocumentViewer documentViewer= (JSONDocumentViewer) DocumentFactoryProvider.getFactory(DocType.DATATYPE).getDocumentViewer(DocType.JSON);
        documentViewer.readDocument(new JSONDocument());
        PDFDocumentViewer pdfViewer= (PDFDocumentViewer) DocumentFactoryProvider.getFactory(DocType.FILETYPE).getDocumentViewer(DocType.PDF);
        pdfViewer.readDocument(new PDFDocument());
    }
}

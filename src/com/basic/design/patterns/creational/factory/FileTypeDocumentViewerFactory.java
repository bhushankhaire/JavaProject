package com.basic.design.patterns.creational.factory;

import com.basic.design.patterns.creational.factory.documents.PDFDocument;
import com.basic.design.patterns.creational.factory.documents.WordDocument;

public class FileTypeDocumentViewerFactory implements AbstractDocumentViewer<FileTypeDocumentViewer> {


     public FileTypeDocumentViewer getDocumentViewer(DocType docType) {
        FileTypeDocumentViewer viewer = null;
        switch (docType) {
            case PDF:
                viewer = new PDFDocumentViewer();
                break;
            case WORD:
                viewer = new WordDocumentViewer();
                break;
        }
        return viewer;
    }

    public static void main(String[] args) {
        FileTypeDocumentViewerFactory factory=new FileTypeDocumentViewerFactory();
        FileTypeDocumentViewer viewer= factory.getDocumentViewer(DocType.PDF);
        viewer.readDocument(new PDFDocument());
        viewer= factory.getDocumentViewer(DocType.WORD);
        viewer.readDocument(new WordDocument());
    }
}

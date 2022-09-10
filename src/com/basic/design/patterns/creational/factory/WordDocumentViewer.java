package com.basic.design.patterns.creational.factory;

import com.basic.design.patterns.creational.factory.documents.WordDocument;

public class WordDocumentViewer implements FileTypeDocumentViewer<WordDocument> {

    @Override
    public void readDocument(WordDocument wordDocument) {

        wordDocument.read();
    }
}

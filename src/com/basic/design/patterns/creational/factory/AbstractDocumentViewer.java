package com.basic.design.patterns.creational.factory;

public interface AbstractDocumentViewer<T> {
     T getDocumentViewer(DocType docType);
}

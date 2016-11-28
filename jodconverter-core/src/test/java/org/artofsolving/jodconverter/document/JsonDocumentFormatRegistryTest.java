//
// JODConverter - Java OpenDocument Converter
// Copyright 2004-2012 Mirko Nasato and contributors
//
// JODConverter is Open Source software, you can redistribute it and/or
// modify it under either (at your option) of the following licenses
//
// 1. The GNU Lesser General Public License v3 (or later)
// -> http://www.gnu.org/licenses/lgpl-3.0.txt
// 2. The Apache License, Version 2.0
// -> http://www.apache.org/licenses/LICENSE-2.0.txt
//
package org.artofsolving.jodconverter.document;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

@Test
public class JsonDocumentFormatRegistryTest {

    public void readJsonRegistry() throws IOException {

        InputStream input = getClass().getResourceAsStream("/document-formats.js");
        try {
            DocumentFormatRegistry registry = JsonDocumentFormatRegistry.create(input);
            DocumentFormat odt = registry.getFormatByExtension("odt");
            assertNotNull(odt);
            assertNotNull(odt.getStoreProperties(DocumentFamily.TEXT));
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

}

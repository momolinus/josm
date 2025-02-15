// License: GPL. For details, see LICENSE file.
package org.openstreetmap.josm.gui.io.importexport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.Test;
import org.openstreetmap.josm.gui.progress.NullProgressMonitor;
import org.openstreetmap.josm.testutils.JOSMTestRules;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Unit tests of {@link ImageImporter} class.
 */
class ImageImporterTest {

    /**
     * Setup test
     */
    @RegisterExtension
    @SuppressFBWarnings(value = "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD")
    public JOSMTestRules test = new JOSMTestRules();

    /**
     * Non-regression test for <a href="https://josm.openstreetmap.de/ticket/14868">Bug #14868</a>.
     * @throws IOException if an error occurs
     */
    @Test
    void testTicket14868() throws IOException {
        List<File> files = new ArrayList<>();
        ImageImporter.addRecursiveFiles(files, new HashSet<>(), Arrays.asList(
                new File("foo.jpg"), new File("foo.jpeg")
                ), NullProgressMonitor.INSTANCE);
        assertEquals(2, files.size());
        assertEquals("foo.jpg", files.get(0).getName());
        assertEquals("foo.jpeg", files.get(1).getName());
    }
}

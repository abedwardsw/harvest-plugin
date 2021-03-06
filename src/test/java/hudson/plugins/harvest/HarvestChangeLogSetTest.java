package hudson.plugins.harvest;

import hudson.scm.ChangeLogSet;
import org.junit.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HarvestChangeLogSetTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSaveToChangeLog() {
    }

    @Test
    public void testParseCheckout() throws IOException, SAXException {
        InputStream syncIs = getClass().getResourceAsStream("/hco.sync.txt");
        HarvestSCM scm = new HarvestSCM("", "", "", "", "", "", "", "", "", "", false, "");
        List<HarvestChangeLogEntry> listOfChanges = new ArrayList<HarvestChangeLogEntry>();
        scm.parse(syncIs, listOfChanges);
        InputStream xmlIs = getClass().getResourceAsStream("/changelog.xml");
        ChangeLogSet<HarvestChangeLogEntry> xmlChanges = HarvestChangeLogSet.parse(null, xmlIs);
        assertEquals(listOfChanges.size(), xmlChanges.getItems().length);
    }

    @Test
    public void testParseSync() throws IOException, SAXException {
        InputStream syncIs = getClass().getResourceAsStream("/hco.sync.txt");
        HarvestSCM scm = new HarvestSCM("", "", "", "", "", "", "", "", "", "", true, "");
        List<HarvestChangeLogEntry> listOfChanges = new ArrayList<HarvestChangeLogEntry>();
        scm.parse(syncIs, listOfChanges);
        InputStream xmlIs = getClass().getResourceAsStream("/changelog.xml");
        ChangeLogSet<HarvestChangeLogEntry> xmlChanges = HarvestChangeLogSet.parse(null, xmlIs);
        assertEquals(listOfChanges.size(), xmlChanges.getItems().length);
    }
}

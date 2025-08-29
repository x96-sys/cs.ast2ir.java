package org.x96.sys.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Text;

class WordToTextTest {
    @Test
    void happy() {
        Word w = new Word("cs".getBytes());
        assertPrintLn("word > 'cs'", () -> w.prettyPrint(""));
        Text t = new WordToText().convert(w);
        assertPrintLn("Text > cs", () -> t.prettyPrint(""));
        assertArrayEquals(w.raw(), t.raw());
    }
}

package org.x96.sys.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Identity;

class GlyphToIdentityTest {
    @Test
    void happy() {
        Glyph glyph = new Glyph("cs".getBytes());
        Identity identity = new GlyphToIdentity().convert(glyph);
        assertArrayEquals(glyph.raw(), identity.raw());
    }
}

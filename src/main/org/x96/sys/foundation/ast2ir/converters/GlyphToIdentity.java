package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToIdentity;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Identity;

public class GlyphToIdentity implements ToIdentity {
    @Override
    public Identity convert(Glyph glyph) {
        return new Identity(glyph.raw());
    }
}

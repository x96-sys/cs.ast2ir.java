package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Identity;

public interface ToIdentity {
    public Identity convert(Glyph glyph);
}

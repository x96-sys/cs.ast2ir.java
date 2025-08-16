package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Identity;

public interface ToIdentity {
    public Identity convert(Glyph glyph);
}

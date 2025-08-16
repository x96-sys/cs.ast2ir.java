package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.Pattern;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.Facet;

public interface ToFacet {
    public Facet convert(Pattern pattern);
}

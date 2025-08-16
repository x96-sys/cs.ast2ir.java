package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.Casing;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.Mesh;

public interface ToMesh {
    public Mesh convert(Casing casing);
}

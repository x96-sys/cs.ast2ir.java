package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.Passage;
import org.x96.sys.cs.ir.manuscript.manifest.Manifest;

public interface ToManifest {
    public Manifest convert(Passage passage);
}

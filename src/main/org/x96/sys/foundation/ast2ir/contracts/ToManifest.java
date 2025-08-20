package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.Passage;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.Manifest;

public interface ToManifest {
    public Manifest convert(Passage passage);
}

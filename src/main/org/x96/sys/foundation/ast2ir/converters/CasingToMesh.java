package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToMesh;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Casing;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.Mesh;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Nucleus;

import java.util.ArrayList;
import java.util.List;

public class CasingToMesh implements ToMesh {

    @Override
    public Mesh convert(Casing casing) {
        List<Nucleus> n = new ArrayList<>();
        for (Core c : casing.cores()) {
            n.add(new CoreToNucleus().convert(c));
        }
        return new Mesh(
                n.toArray(Nucleus[]::new),
                new QuantifierToOccurrence().convert(casing.quantifier()));
    }
}

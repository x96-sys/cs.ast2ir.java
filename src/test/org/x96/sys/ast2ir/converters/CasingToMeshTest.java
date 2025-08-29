package org.x96.sys.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.cs.ast.book.passage.pattern.Casing;
import org.x96.sys.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.Mesh;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Switch;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Term;

import java.util.Optional;

class CasingToMeshTest {
    @Test
    void happy() {
        Casing casing =
                new Casing(
                        new Core[] {
                            new Unit(
                                    Optional.of(new Bang((byte) '!')),
                                    new Glyph("cs".getBytes()),
                                    Optional.empty()),
                            new Choices(
                                    new Core[] {
                                        new Word("cs".getBytes()), new Word("sc".getBytes())
                                    },
                                    Optional.of(new OneOrMore("+".getBytes()[0])))
                        },
                        Optional.empty());

        Mesh mesh = new CasingToMesh().convert(casing);
        assertEquals(2, mesh.nuclei().length);
        assertInstanceOf(Term.class, mesh.nuclei()[0]);
        assertInstanceOf(Switch.class, mesh.nuclei()[1]);
    }
}

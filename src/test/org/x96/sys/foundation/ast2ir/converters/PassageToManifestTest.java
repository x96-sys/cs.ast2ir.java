package org.x96.sys.foundation.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.Passage;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Casing;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Inhibitor;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.Manifest;

import java.util.Optional;

class PassageToManifestTest {
    @Test
    void happy() {
        Glyph glyph = new Glyph("cs".getBytes());
        Passage passage =
                new Passage(
                        glyph,
                        Optional.of(new Ghost("_".getBytes()[0])),
                        new Casing(
                                new Core[] {
                                    new Unit(
                                            Optional.of(new Inhibitor('!')),
                                            new Glyph("cs".getBytes()),
                                            Optional.empty()),
                                    new Choices(
                                            new Core[] {
                                                new Word("cs".getBytes()), new Word("sc".getBytes())
                                            },
                                            Optional.of(new OneOrMore("+".getBytes()[0])))
                                },
                                Optional.empty()));

        Manifest manifest = new PassageToManifest().convert(passage);
    }
}

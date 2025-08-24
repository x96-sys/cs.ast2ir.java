package org.x96.sys.foundation.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.Book;
import org.x96.sys.foundation.cs.ast.book.passage.Passage;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Casing;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.foundation.cs.ir.manuscript.Manuscript;

import java.util.Optional;

class BookToManuscriptTest {
    @Test
    void happy() {
        Book book =
                new Book(
                        new Passage[] {
                            new Passage(
                                    new Glyph("book".getBytes()),
                                    Optional.of(new Ghost("_".getBytes()[0])),
                                    new Casing(
                                            new Core[] {
                                                new Unit(
                                                        Optional.of(new Bang((byte) '!')),
                                                        new Glyph("cs".getBytes()),
                                                        Optional.empty()),
                                                new Choices(
                                                        new Core[] {
                                                            new Word("cs".getBytes()),
                                                            new Word("sc".getBytes())
                                                        },
                                                        Optional.of(
                                                                new OneOrMore("+".getBytes()[0])))
                                            },
                                            Optional.empty()))
                        });

        book.prettyPrint("");
        Manuscript manuscript = new BookToManuscript().convert(book);
        manuscript.prettyPrint("");
    }
}

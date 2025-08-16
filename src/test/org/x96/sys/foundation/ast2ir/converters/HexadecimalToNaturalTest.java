package org.x96.sys.foundation.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Hexadecimal;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Natural;

class HexadecimalToNaturalTest {
    @Test
    void happy() {
        Hexadecimal hexadecimal = new Hexadecimal(0xFF);
        assertPrintLn("hex > [0xFF]", () -> hexadecimal.prettyPrint(""));
        Natural natural = new HexadecimalToNatural().convert(hexadecimal);
        assertPrintLn("Natural > 255", () -> natural.prettyPrint(""));
        assertEquals(natural.b(), hexadecimal.raw());
    }
}

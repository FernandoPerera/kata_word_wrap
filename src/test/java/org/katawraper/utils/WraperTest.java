package org.katawraper.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.katawraper.exceptions.NegativeNumberException;

import static org.junit.jupiter.api.Assertions.*;

public class WraperTest {

    /*
    *   Casos de uso :
    *
    *       - Si se introduce una cadena vacía que devuelva 0.
    *
    *       - Si el número introducido es negativo o menor que 0 devolver un
    *         throw.
    *
    *       - Si se introduce un número de columna mayor que el de palabras
    *         devolver la misma línea.
    *
    *       - Si se introduce una cadena y un número correcto de columna
     *        devolver la cadena con los saltos de línea correctos.
    */

    @Test
    public void give_empty_string_return_0() throws NegativeNumberException {

        assertEquals("0", Wraper.wrap("", 1));
    }

    @Test
    public void give_negative_column_number_or_equal_to_zero_return_throw() {

        NegativeNumberException thrown = assertThrows(NegativeNumberException.class, () ->
                Wraper.wrap("Negative number test", -10));

        assertTrue(thrown.getMessage().contentEquals("Negative number not allowed"));
    }

    @Test
    public void give_largest_column_number_than_string_length_return_same_string() throws NegativeNumberException {

        assertEquals("Test from largest column number", Wraper.wrap("Test from largest column number", 10));
    }

    @Test
    public void give_correct_string_and_correct_number_return_string_with_correct_line_breaks() throws NegativeNumberException {

        String stringTest = "Test from the correct situation Nando, Rober, Ana, Nico and Aitor this is a test";
        String correctResponse = "Test from the\ncorrect situation Nando,\nRober, Ana, Nico\nand Aitor this\nis a test";

        assertEquals(correctResponse, Wraper.wrap(stringTest, 3));
    }

}
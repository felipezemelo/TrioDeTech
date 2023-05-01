import entities.Produto;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

    class ProdutoTest {

        @Test
        void testEquals() {
            Produto produto1 = new Produto("RTX 3080", 5500.99);
            Produto produto2 = new Produto("RTX 3080", 5500.99);
            Produto produto3 = new Produto("RX 6800", 5600.99);

            // Testa se objetos iguais são considerados iguais
            assertTrue(produto1.equals(produto2));

            // Testa se objetos diferentes são considerados diferentes
            assertFalse(produto1.equals(produto3));
        }

        @Test
        void testHashCode() {
            Produto produto1 = new Produto("RTX 3080", 5500.99);
            Produto produto2 = new Produto("RTX 3080", 5500.99);
            Produto produto3 = new Produto("RX 6800", 5600.99);

            //
            assertEquals(produto1.hashCode(), produto2.hashCode());


            assertNotEquals(produto1.hashCode(), produto3.hashCode());
        }
    }



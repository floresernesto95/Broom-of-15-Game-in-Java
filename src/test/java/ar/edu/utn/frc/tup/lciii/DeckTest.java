package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void createDeckTest() {
        // TODO: Crear un test que valide que el mazo se crea con 40 cartas,
        //  que no se incluyen los 8 y 9.
        //  Validar que todas las cartas de un mazo de 40 cartas estén presentes.
        Deck deck = new Deck();
        Stack<Card> cards = deck.getCards();

        // Verificar que el mazo tiene 40 cartas
        assertEquals(40, cards.size(), "El mazo debe tener 40 cartas");

        // Verificar que el mazo no incluye cartas con número 8 o 9
        for (Card card : cards) {
            assertNotEquals(8, card.getNumber(), "El mazo no debe contener cartas con el número 8");
            assertNotEquals(9, card.getNumber(), "El mazo no debe contener cartas con el número 9");
        }

        // Verificar que todas las cartas de un mazo de 40 cartas están presentes
            int[] countBySuit = new int[4]; // Contador para cada palo

        for (Card card : cards) {
            int number = card.getNumber();
            CardSuit suit = card.getCardSuit();

            // Contar cartas por palo
            switch (suit) {
                case BASTOS:
                    countBySuit[0]++;
                    break;
                case COPAS:
                    countBySuit[1]++;
                    break;
                case OROS:
                    countBySuit[2]++;
                    break;
                case ESPADAS:
                    countBySuit[3]++;
                    break;
            }

            // Verificar los números de las cartas en el rango esperado
            assertTrue(number >= 1 && number <= 12 && number != 8 && number != 9,
                    "El número de carta debe estar en el rango de 1 a 7, 10 a 12");
        }

        // Verificar que hay 10 cartas por palo
        for (int count : countBySuit) {
            assertEquals(10, count, "Cada palo debe tener 10 cartas");
        }
    }

    @Test
    void takeCardTest() {
        // TODO: Crear un test que valide que al tomar una carta del mazo,
        //  la cantidad de cartas en el mazo disminuye en 1 y que la carta tomada
        //  es la que se esperaba; es decir la que está al tope de la pila.
        Deck deck = new Deck();
        Stack<Card> cards = deck.getCards();

        // Guardar el tamaño inicial del mazo
        int initialSize = cards.size();

        // Guardar la carta esperada (la que está al tope de la pila)
        Card expectedCard = cards.peek();

        // Tomar una carta del mazo
        Card takenCard = deck.takeCard();

        // Verificar que la cantidad de cartas en el mazo disminuye en 1
        assertEquals(initialSize - 1, cards.size(), "La cantidad de cartas en el mazo debe disminuir en 1");

        // Verificar que la carta tomada es la que se esperaba
        assertEquals(expectedCard, takenCard, "La carta tomada debe ser la que está al tope de la pila");
    }

    @Test
    void isEmptyTest() {
        // TODO: Crear un test que valide que el mazo está vacío cuando no tiene cartas
        //  y que no está vacío cuando tiene al menos una carta.
        // Crear un mazo y verificar que no está vacío inicialmente
        Deck deck = new Deck();
        assertFalse(deck.isEmpty(), "El mazo no debe estar vacío justo después de ser creado");

        // Tomar todas las cartas del mazo
        while (!deck.isEmpty()) {
            deck.takeCard();
        }

        // Verificar que el mazo está vacío después de tomar todas las cartas
        assertTrue(deck.isEmpty(), "El mazo debe estar vacío después de tomar todas las cartas");
    }

    @Test
    void shuffleDeckTest() {
        // TODO: Crear un test que valide que al mezclar el mazo, las cartas no están en el mismo orden
        //  que al crear el mazo.

        // Crear un mazo sin mezclar
        Deck deck = new Deck();
        Stack<Card> originalOrder = (Stack<Card>) deck.getCards().clone();

        // Mezclar el mazo
        deck.shuffleDeck();
        Stack<Card> shuffledOrder = deck.getCards();

        // Verificar que las cartas no están en el mismo orden que al crear el mazo
        boolean isShuffled = false;
        for (int i = 0; i < originalOrder.size(); i++) {
            if (!originalOrder.get(i).equals(shuffledOrder.get(i))) {
                isShuffled = true;
                break;
            }
        }

        assertTrue(isShuffled, "Las cartas no deben estar en el mismo orden después de mezclar el mazo");
    }
}
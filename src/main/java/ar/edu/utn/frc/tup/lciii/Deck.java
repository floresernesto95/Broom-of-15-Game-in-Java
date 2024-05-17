package ar.edu.utn.frc.tup.lciii;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Clase que representa un mazo de cartas españolas.
 */
public class Deck {

    /**
     * Lista de cartas del mazo
     */
    private final Stack<Card> cards;

    public Stack<Card> getCards() {
        return cards;
    }

    /**
     * Constructor de la clase Deck
     * El constructor crea la lista de cartas y las mezcla
     * Como el juego se juega con 40 cartas, el constructor retorna un mazo sin los 8 y 9 y sin los Jokers
     *
     * @see Deck#cards
     * @see Card
     * @see Stack
     * @see Deck#createDeck()
     */
    public Deck() {
        this.cards = new Stack<Card>();
        createDeck();
        shuffleDeck();
    }

    /**
     * Crea las cartas del mazo
     * El mazo se crea con 40 cartas, sin los 8 y 9 y sin los Jokers
     *
     * @see Deck#cards
     * @see Card
     */
    private void createDeck() {
        // TODO: Implementar la creación de las cartas del mazo. Recuerde que son barajas de 40 cartas
        //  y que no se incluyen los 8 y 9.
        //  Las cartas poseen un CardSuit, un número y un valor.
        //  Los valores de las cartas son los siguientes:
        //  - 1 al 7: su valor es el mismo que su número
        //  - 10: su valor es 8
        //  - 11: su valor es 9
        //  - 12: su valor es 10
        int num1 = 1, num2 = 1, num3 = 1, num4 = 1, val1= 1, val2 = 1, val3 = 1, val4 = 1;

        do {
            Card card1 = new Card(CardSuit.BASTOS, num1++, val1++);
            Card card2 = new Card(CardSuit.COPAS, num2++, val2++);
            Card card3 = new Card(CardSuit.OROS, num3++, val3++);
            Card card4 = new Card(CardSuit.ESPADAS, num4++, val4++);

            cards.add(card1);
            cards.add(card2);
            cards.add(card3);
            cards.add(card4);
        }
        while (cards.size() < 40);

        for (Card card : cards) {
            if (card.getNumber() == 8) {
                card.setNumber(10);
            }
            else if (card.getNumber() == 9) {
                card.setNumber(11);
            }
            else if (card.getNumber() == 10) {
                card.setNumber(12);
            }
        }
    }

    /**
     * Toma una carta del mazo y la quita del mismo
     *
     * @return la carta tomada
     *
     * @see Deck#cards
     * @see Card
     * @see Stack
     */
    public Card takeCard() {
        return cards.pop();
    }

    /**
     * Verifica si el mazo está vacío
     *
     * @return true si el mazo está vacío, false en caso contrario
     *
     * @see Deck#cards
     * @see Stack#isEmpty()
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Mezcla la lista de cartas que recibe como parámetro
     *
     * @see Deck#cards
     * @see Collections#shuffle(List)
     */
    void shuffleDeck() {
        Collections.shuffle(cards);
    }
}

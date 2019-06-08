import Money.Coin.Coin;
import Money.Coin.CoinType;
import Products.Crisp;
import Products.Drink;
import Products.EmptyProductObj;
import Products.Sweet;
import VendingShelves.Slot;
import VendingShelves.SlotCode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SlotTest {

    private ArrayList<Slot> slots;
    private VendingMachine vendingMachine;
    private Coin ONE;
    private Coin TWO;
    private Coin FIVE;
    private Coin TEN;
    private Coin TWENTY;
    private Coin FIFTY;
    private Coin ONEPOUND;
    private Slot A1Drink;
    private Slot B1Crisps;
    private Slot C1Sweet;
    private Slot empty;
    private ArrayList<Coin> coinsThatCanBeAccepted;
    private Crisp crisps;
    private Sweet sweet;
    private Drink drink;
    private EmptyProductObj emptyProductObj;

    @Before
    public void setUp(){

        coinsThatCanBeAccepted = new ArrayList<Coin>();
        vendingMachine = new VendingMachine(coinsThatCanBeAccepted);
        slots = new ArrayList<Slot>();

        ONE = new Coin(CoinType.ONE);
        TWO = new Coin(CoinType.TWO);
        FIVE = new Coin(CoinType.FIVE);
        TEN = new Coin(CoinType.TEN);
        TWENTY = new Coin(CoinType.TWENTY);
        FIFTY = new Coin(CoinType.FIFTY);
        ONEPOUND = new Coin(CoinType.ONEPOUND);

        crisps = new Crisp("Salt & Vinegar", "Walkers");
        sweet = new Sweet("Toffee Crisp", "Nestle");
        drink = new Drink("Coca Cola", "Nestle");
        emptyProductObj = new EmptyProductObj("", "");
        A1Drink = new Slot(SlotCode.A1, 1.00, drink);
        B1Crisps = new Slot(SlotCode.B1, 0.50, crisps);
        C1Sweet = new Slot(SlotCode.C1, 0.65, sweet);
        empty = new Slot(SlotCode.A2, 0.00, emptyProductObj);

    }

    @Test
    public void canGetPriceAsString() {
        vendingMachine.assignSlotsToVendingMachine();
        vendingMachine.assignProductToEmptySlot(sweet, 0.65);

        assertEquals("0.65", C1Sweet.makePriceString());
    }
}

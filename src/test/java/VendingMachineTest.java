import Money.Coin.Coin;
import Money.Coin.CoinType;
import Products.Crisp;
import Products.Drink;
import Products.Product;
import Products.Sweet;
import VendingShelves.Slot;
import VendingShelves.SlotCode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

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
    private ArrayList<Coin> coinsThatCanBeAccepted;
    private Crisp crisps;
    private Sweet sweet;
    private Drink drink;

    @Before
    public void setUp(){
        crisps = new Crisp("Salt & Vinegar", "Walkers");
        sweet = new Sweet("Toffee Crisp", "Nestle");
        drink = new Drink("Coca Cola", "Nestle");

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

        A1Drink = new Slot(SlotCode.A1, 1.00, drink);
        B1Crisps = new Slot(SlotCode.B1, 0.50, crisps);
        C1Sweet = new Slot(SlotCode.C1, 0.65, sweet);
    }

    @Test
    public void canAddMoney() {
        vendingMachine.addCoinToAcceptedList(FIVE, TEN, TWENTY, FIFTY, ONEPOUND);
        vendingMachine.addMoney(FIFTY);
        assertEquals(1, vendingMachine.checkCoinsReceivedArraySize());
    }

    @Test
    public void canRefuseCoins(){
        vendingMachine.addCoinToAcceptedList(FIVE, TEN, TWENTY, FIFTY, ONEPOUND);
        vendingMachine.addMoney(TWENTY);
        vendingMachine.addMoney(TEN);
        vendingMachine.addMoney(ONE);
        assertEquals(2, vendingMachine.checkCoinsReceivedArraySize());
        assertEquals(false, vendingMachine.addMoney(ONE));
    }

    @Test
    public void checkVendingMachineHasSlots() {
        vendingMachine.assignSlotsToVendingMachine();
        assertEquals(15, vendingMachine.checkMachineHasSlots());
    }

    @Test
    public void canAssignProductToSlot(){
        vendingMachine.assignSlotsToVendingMachine();
        vendingMachine.assignProductToSlot(A1Drink);
        assertEquals(slots, vendingMachine.returnSlotArray());
    }

    //        @Test
//    public void canAddMoneyToMachine() {
//        vendingMachine.assignSlotsToVendingMachine();
//        vendingMachine.addCoinToAcceptedList(FIVE, TEN, TWENTY, FIFTY, ONEPOUND);
//        vendingMachine.addMoney(FIFTY);
//        vendingMachine.addMoney(TWENTY);
//        vendingMachine.selectItemCode(SlotCode.B1);
//        vendingMachine.checkEnoughFunds();
//        vendingMachine.dispenseProduct();
//    }
}

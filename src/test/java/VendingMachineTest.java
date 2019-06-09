import Money.Coin.Coin;
import Money.Coin.CoinType;
import Products.*;
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
    private Slot empty;
    private Slot slotToSell;
    private Slot emptySlot;
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

        slotToSell = new Slot(SlotCode.A1, 0.65, crisps);
        emptySlot = new Slot(SlotCode.A1, 0.00, emptyProductObj);



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
        vendingMachine.addMoney(ONE);
        vendingMachine.addMoney(TWENTY);
        vendingMachine.addMoney(TEN);
        assertEquals(2, vendingMachine.checkCoinsReceivedArraySize());
        assertEquals(1, vendingMachine.returnRejectedCoinArraySize());
    }

    @Test
    public void checkVendingMachineHasSlots() {
        vendingMachine.assignSlotsToVendingMachine();
        assertEquals(15, vendingMachine.checkMachineHasSlots());
    }

    //in slot class
    @Test
    public void canReturnSlotCode(){
        assertEquals(SlotCode.A1, A1Drink.selectItemCode(A1Drink));
    }

    @Test
    public void canReturnEmptySlot() {
        vendingMachine.assignSlotsToVendingMachine();
        assertEquals(0, vendingMachine.returnEmptySlotIndex());
    }

    @Test
    public void canInsertProductAtEmptySlot(){
        vendingMachine.assignSlotsToVendingMachine();
        vendingMachine.returnEmptySlotIndex();
        vendingMachine.assignProductToEmptySlot(drink, 1.00);
        assertEquals(1, vendingMachine.returnEmptySlotIndex());
    }

    @Test
    public void returnSlotsWithCrisps(){
        vendingMachine.assignSlotsToVendingMachine();
        vendingMachine.returnEmptySlotIndex();
        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
        vendingMachine.assignProductToEmptySlot(drink, 1.00);
        assertEquals(2, vendingMachine.returnNumberOfCodesWithCrisps());
    }

    @Test
    public void canReturnListOfCodesAndTheirContents() {
//        ArrayList<Slot> contents = new ArrayList<Slot>();
        vendingMachine.assignSlotsToVendingMachine();
        vendingMachine.returnEmptySlotIndex();
        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
        vendingMachine.assignProductToEmptySlot(drink, 1.00);
        assertEquals("A1", vendingMachine.returnEverything() );
    }

    @Test
    public void canGetTotalAmountCoinsReceived() {
        vendingMachine.addCoinToAcceptedList(FIVE, TEN, TWENTY, FIFTY, ONEPOUND);
        vendingMachine.addMoney(TWENTY);
        vendingMachine.addMoney(FIFTY);
        assertEquals(0.70, vendingMachine.getCoinsReceivedTotal(), 0.1);
    }

    @Test
    public void canBuyProduct() {
        vendingMachine.addCoinToAcceptedList(FIVE, TEN, TWENTY, FIFTY, ONEPOUND);
        vendingMachine.addMoney(TWENTY);
        vendingMachine.addMoney(FIFTY);
        vendingMachine.assignSlotsToVendingMachine();
        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
        vendingMachine.assignProductToEmptySlot(drink, 1.00);
//        vendingMachine.sellProduct(SlotCode.A1);
        assertEquals(crisps, vendingMachine.sellProduct(slotToSell));
        assertEquals(0, vendingMachine.returnEmptySlotIndex());
        assertEquals(0, vendingMachine.getCoinsReceivedTotal(), 0.1);
    }

    //////didn't have time to figure out how to return product OR double, can we go thorugh this please?
    ///i assume this will be casting but not sure how it works??////////

//    @Test
//    public void canReturnAmountStillOwed(){
//        vendingMachine.addCoinToAcceptedList(FIVE, TEN, TWENTY, FIFTY, ONEPOUND);
//        vendingMachine.addMoney(TWENTY);
//        vendingMachine.assignSlotsToVendingMachine();
//        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
//        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
//        vendingMachine.assignProductToEmptySlot(drink, 1.00);
//        assertEquals(0, vendingMachine.sellProduct(slotToSell));
//    }

    // return the full slot list, find out how to return object contents too








    //    @Test
//    public void canSelectItemByCode(){
//        vendingMachine.assignSlotsToVendingMachine();
//        vendingMachine.returnEmptySlotIndex();
//        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
//        vendingMachine.assignProductToEmptySlot(crisps, 0.65);
//        vendingMachine.assignProductToEmptySlot(drink, 1.00);
//    }



}

import Money.Coin.Coin;
import Money.Coin.CoinType;
import Products.EmptySlot;
import Products.Product;
import VendingShelves.Slot;
import VendingShelves.SlotCode;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Coin> coinsReceived;
    private ArrayList<Coin> coinsThatCanBeAccepted;
    private ArrayList<Slot> slotsInMachine;



    public VendingMachine(ArrayList<Coin> coinsThatCanBeAccepted){
        this.coinsThatCanBeAccepted = new ArrayList<Coin>();
        this.coinsReceived = new ArrayList<Coin>();
        this.slotsInMachine = new ArrayList<Slot>();
    }

    public void addCoinToAcceptedList(Coin coin1, Coin coin2, Coin coin3, Coin coin4, Coin coin5){
        this.coinsThatCanBeAccepted.add(coin1);
        this.coinsThatCanBeAccepted.add(coin2);
        this.coinsThatCanBeAccepted.add(coin3);
        this.coinsThatCanBeAccepted.add(coin4);
        this.coinsThatCanBeAccepted.add(coin5);
    }

    public int checkCoinsReceivedArraySize(){
        return this.coinsReceived.size();
    }

    public ArrayList<Coin> returnCoinsReceivedArray(){
        return this.coinsReceived;
    }

    public Boolean addMoney(Coin coin){
        boolean accept = true;
       if (coinsThatCanBeAccepted.contains(coin)){
           this.coinsReceived.add(coin);
       } else {
           accept = false;
       }
       return accept;
    }

    public void assignSlotsToVendingMachine(){
        EmptySlot product = new EmptySlot("", "");
    SlotCode[] allSlots = SlotCode.values();
        for (SlotCode slot: allSlots){
        Slot newSlot = new Slot(slot, 0.0, product);
        this.slotsInMachine.add(newSlot);
        }
    }

    public int checkMachineHasSlots(){
        return this.slotsInMachine.size();
    }

    public ArrayList<Slot> returnSlotArray(){
        return this.slotsInMachine;
    }

//    public ArrayList<Slot> assignProductToSlot(Slot slot){
//        int thisSlot = this.slotsInMachine.indexOf(slot.);
//        this.slotsInMachine.set(thisSlot, slot);
//        return this.slotsInMachine;
//    }

}

import Money.Coin.Coin;
import Products.Crisp;
import Products.EmptyProductObj;
import Products.Product;
import VendingShelves.Slot;
import VendingShelves.SlotCode;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Coin> coinsReceived;
    private ArrayList<Coin> coinsThatCanBeAccepted;
    private ArrayList<Coin> rejectedCoins;

    private ArrayList<Slot> slotsInMachine;
    private ArrayList<SlotCode> slotsWithCrisps;
    private Slot slot;
    private Product product;
    private EmptyProductObj emptyProduct;



    public VendingMachine(ArrayList<Coin> coinsThatCanBeAccepted){
        this.coinsThatCanBeAccepted = new ArrayList<Coin>();
        this.coinsReceived = new ArrayList<Coin>();
        this.rejectedCoins = new ArrayList<Coin>();
        this.slotsInMachine = new ArrayList<Slot>();
        this.slotsWithCrisps = new ArrayList<SlotCode>();
        this.slot = slot;
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

    public void addMoney(Coin coin){
       if (coinsThatCanBeAccepted.contains(coin)){
           this.coinsReceived.add(coin);
       } else {
           this.rejectedCoins.add(coin);
       }
    }

    public int returnRejectedCoinArraySize(){
        return this.rejectedCoins.size();
    }

    public ArrayList<Coin> returnRejectedCoins(){
        return this.rejectedCoins;
    }

    public void assignSlotsToVendingMachine(){
        EmptyProductObj product = new EmptyProductObj("", "");
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

//    public String makeSlotStringObject(){
//        String all = "";
//        for (Slot slot: slotsInMachine) {
//            all = (this.slot.makeSlotCodeString() +
//                    this.slot.makePriceString() +
//                    this.slot.makeProductString() +
//                    this.slot.getProduct().getBrand() +
//                    this.slot.getProduct().getName());
//        }
//        return all;
//    }




    public ArrayList<String> returnEverything(){
        ArrayList<String> contents = new ArrayList<String>();
         for (Slot slot: slotsInMachine){
            String stringObj = slot.returnStringObject();
            contents.add(stringObj);
         }
         return contents;
    }

    public int returnEmptySlotIndex(){
        int index = -1;
        for (Slot slot: this.slotsInMachine){
            if (slot.getPrice() == 0 ){
                index = this.slotsInMachine.indexOf(slot);
                break;
            }
        }
        return index;
    }

    public void assignProductToEmptySlot(Product product, double price){
        int emptySlot = returnEmptySlotIndex();
        Slot fillSlot = slotsInMachine.get(emptySlot);
        fillSlot.setPrice(price);
        fillSlot.setProduct(product);
    }

    public ArrayList<SlotCode> returnAllCodesWithCrisps(){
//        Crisp crisp;
//        SlotCode[] slotsWithCrisps;
        for (Slot slot: slotsInMachine){
            Product eachSlot = slot.getProduct();
            SlotCode slotCode = slot.selectItemCode(slot);
            if (eachSlot instanceof Crisp){
                slotsWithCrisps.add(slotCode);
            }
        }
        return slotsWithCrisps;
    }

    public int returnNumberOfCodesWithCrisps(){
        return returnAllCodesWithCrisps().size();
    }

    public double getCoinsReceivedTotal(){
        double total = 0;
        for ( Coin coin: this.coinsReceived){
            total += coin.getCoinValueFromEnum();
        }
        return total;
    }

    public double returnHowMuchStillOwed(Slot choice){
        double amount = 0;
        if (getCoinsReceivedTotal() < choice.getPrice()){
            amount = (getCoinsReceivedTotal() - choice.getPrice()) * -1;
        }
        return amount;
    }

    public Product sellProduct(Slot choice) {
        Slot slotToChange = slot;
        Product productToSell = product;
        EmptyProductObj newProduct = emptyProduct;
        for (int index = 0; index < slotsInMachine.size(); index++) {
            slot = slotsInMachine.get(index);
            if (choice.getProduct() == slot.getProduct()) {

                    slotToChange = slotsInMachine.get(index);
                    productToSell = slotToChange.getProduct();
                    slotToChange.setPriceAndProduct(0.00, newProduct);
                    this.coinsReceived.clear();
            }
        }
        return productToSell;
    }

            // return the object at the slotcode index and replace it with empty object


//            if ( choice.returnCode() == slot.returnCode()){
//
//            }
//        }
//        if ( getCoinsReceivedTotal() >= choice.getPrice()){
//            this.slotsInMachine.get(choice.)



}

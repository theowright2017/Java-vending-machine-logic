package VendingShelves;

import Products.Product;

public class Slot {

    private SlotCode slotCode;
    private double price;
    private Product product;
    private Slot slot;

    public Slot(SlotCode slotCode, double price, Product product){
        this.slotCode = slotCode;
        this.price = price;
        this.product = product;
        this.slot = slot;
    }

    public SlotCode selectItemCode(Slot slot){
        return slot.slotCode;
    }

    public SlotCode returnCode(){
        return this.slot.slotCode;
    }

    public void setSlotCode(SlotCode slotCode) {
        this.slotCode = slotCode;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public Slot getSlot() {
        return slot;
    }

    public String makeSlotCodeString(){
        return this.slotCode.toString();
    }
    public String makeProductString(){
        return this.product.getThisClassAsString();
    }
    public String makePriceString(){
        return String.valueOf(this.price);
    }

    public String returnStringObject(){
        return "|||||   " + makeSlotCodeString() + ", " +
                makeProductString() + ", " +
                makePriceString() + ", " +
                this.product.getName() + ", " +
                this.product.getBrand();
    }

//    public String makeSlotStringObject(){
////        return this.slot.makeSlotCodeString() +
////                this.slot.makePriceString() +
////                this.slot.makeProductString() +
////                this.slot.getProduct().getBrand() +
////                this.slot.getProduct().getName();
////    }

//    public String makeSlotStringObject(){
//
//    }
}

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
    }

    public Slot selectItemCode(Slot slot){
        return this.slot;
    }
}

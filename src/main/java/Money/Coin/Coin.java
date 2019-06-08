package Money.Coin;

public class Coin {

    private CoinType coinType;

    public Coin(CoinType coinType){
        this.coinType = coinType;
    }

    public CoinType getCoinType() {
        return coinType;
    }

   public double getCoinValueFromEnum(){
         double amount = this.coinType.getCoinValue();
       return amount;
   }
}

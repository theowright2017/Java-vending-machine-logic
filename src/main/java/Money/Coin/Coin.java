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
        return this.coinType.getCoinValue();
   }
}

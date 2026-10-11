import java.math.BigDecimal;

public class Printer extends Device{
    public enum Type
    {
        laser,
        phun
    }
    private Type type;
    private int trang;
    private boolean mau;

    public Printer(String id, String name, BigDecimal price , int year,
            Type type, int trang, boolean network, boolean mau) {
        super(id, name, price, year);
        this.type = type;
        this.trang = trang;
        this.mau = mau;
    }

    @Override
    public BigDecimal chiphiBaotri() {
        // Ví dụ công thức: Chi phí bảo trì máy in = 10% giá trị máy
        BigDecimal price = getPrice();
        double rate = 0.04;
        double costTrang = 500000;
        double costMau = 300000;
        BigDecimal mainCost = price.multiply(BigDecimal.valueOf(rate));
        if(trang > 100000){
            mainCost = mainCost.add(BigDecimal.valueOf(costTrang));
        }
        if(mau){
            mainCost = mainCost.add(BigDecimal.valueOf(costMau));
        }

        return mainCost;
    }
}

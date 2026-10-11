import java.math.BigDecimal;

public class Projector extends Device{
    private int doSang;
    private int soGio;

    public Projector(String id, String name, BigDecimal price , int year,
                    int doSang, int soGio) {
        super(id, name, price, year);
        this.doSang = doSang;
        this.soGio = soGio;
    }

    @Override
    public BigDecimal chiphiBaotri() {
        // Ví dụ công thức: Chi phí bảo trì máy in = 10% giá trị máy
        BigDecimal cost = getPrice().multiply(new BigDecimal("0.10"));

        return cost;
    }
}

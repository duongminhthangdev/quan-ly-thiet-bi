import java.math.BigDecimal;
import java.time.Year;

public abstract class Device {
    protected String id ;
    protected String name;
    protected BigDecimal price;
    protected int serviceYear;
    public enum Status
    {
        Active,
        UnderMaintenance,
        Retired
    }
    private Status status;
//    Hàm khởi tạo đang nhiều tham số
    public Device(String id,String name, BigDecimal price ,int year){
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã thiết bị không được để rỗng.");
        }
        this.id = id;
        this.name = name;
        setPrice(price);
        setYear(year);
    }

    public void setPrice ( BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Giá mua phải lớn hơn 0.");
        }
        this.price = price;
    }
    public void setYear (int year){
        int currentYear = Year.now().getValue();
        if (year > currentYear) {
            throw new IllegalArgumentException("Năm đưa vào sử dụng (" + year + ") không được lớn hơn năm hiện tại (" + currentYear + ").");
        }
        this.serviceYear =year;
    }
    public void setStarus (Status status){
        this.status = status;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public String getId(){
        return id;
    }
    public int getYear(){ return serviceYear;}

    public abstract BigDecimal chiphiBaotri();
    @Override
    public String toString() {
        return String.format("[Mã: %s] %s | Năm sử dụng: %d | Giá mua: %,.2f | Trạng thái: %s",
                id, name, serviceYear, price, status);
    }



}

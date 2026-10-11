import java.math.BigDecimal;
import java.time.Year;

public class Computer extends Device implements INetworkable {
    private int ram;
    private String boXuly;
    private boolean gpu;
    private String ipAddress;
    private boolean connected;

    // Constructor kế thừa từ lớp Device
    public Computer(String id,String name, BigDecimal price ,int year,
                    int ram, String boXuly, boolean gpu) {
        super(id, name, price, year);
        this.ram = ram;
        this.boXuly = boXuly;
        this.gpu = gpu;
    }

    @Override
    public BigDecimal chiphiBaotri() {
        // Ví dụ công thức: Chi phí cơ bản = 5% giá mua
        BigDecimal price = getPrice();
        double cost = 0.05;
        double gpuCost = 0.02;
        double namCost = 0.01;
        int nam = Year.now().getValue() - serviceYear;
        if (gpu) {
            cost += gpuCost;
        }
        if (nam > 5) {
            cost += namCost;
        }
        return price.multiply(BigDecimal.valueOf(cost));    }

    // Getters và Setters cho các thuộc tính riêng của Computer
    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public String getBoXuly() { return boXuly; }
    public void setBoXuly(String boXuly) { this.boXuly = boXuly; }

    public boolean isGpu() { return gpu; }
    public void setGpu(boolean gpu) { this.gpu = gpu; }



    // ghi đè interface
    @Override
    public String getIpAddress() {
        return this.ipAddress;
    }

    @Override
    public void connect(String ipAddress) {
        this.ipAddress = ipAddress;
        this.connected = true;
        System.out.println("Đã kết nối tới IP: " + ipAddress);
    }

    @Override
    public void disconnect() {
        this.connected = false;
        System.out.println("Đã ngắt kết nối.");
    }

    @Override
    public boolean isConnected() {
        return this.connected;
    }
}
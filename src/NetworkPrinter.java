import java.math.BigDecimal;

public class NetworkPrinter extends Printer implements INetworkable {
    private String ipAddress;

    // Khớp chính xác kiểu dữ liệu và thứ tự với constructor của lớp Printer
    public NetworkPrinter(String id, String name, BigDecimal price, int year,
                          Type type, int trang, boolean mau) {
        // Truyền đủ 8 tham số: id, name, price, year, type, trang, true (network), mau
        super(id, name, price, year, type, trang, true, mau);
        this.ipAddress = "";
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public boolean isConnected() {
        return ipAddress != null && !ipAddress.isEmpty();
    }

    @Override
    public void connect(String ipAddress) {
        if (ipAddress == null || ipAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Địa chỉ IP không được rỗng.");
        }
        if (isConnected()) {
            throw new IllegalStateException("Thiết bị đang kết nối.");
        }
        this.ipAddress = ipAddress;
    }

    @Override
    public void disconnect() {
        this.ipAddress = "";
    }

//    @Override
//    public boolean checkConnection() {
//        return isConnected();
//    }
}
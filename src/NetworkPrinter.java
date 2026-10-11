import java.math.BigDecimal;

public class NetworkPrinter extends Printer implements INetworkable {
    private String ipAddress;

    // Cập nhật constructor nhận String ipAddress làm tham số cuối
    public NetworkPrinter(String id, String name, BigDecimal price, int year,
                          Type type, int trang, String ipAddress) {
        // Truyền đủ 8 tham số cho lớp cha Printer:
        // (id, name, price, year, type, trang, network = true, mau = false mặc định)
        super(id, name, price, year, type, trang, true, false);
        this.ipAddress = ipAddress;
    }

    // Nếu bạn muốn hỗ trợ cả thuộc tính 'mau' (màu sắc), có thể dùng constructor này:
    public NetworkPrinter(String id, String name, BigDecimal price, int year,
                          Type type, int trang, boolean mau, String ipAddress) {
        super(id, name, price, year, type, trang, true, mau);
        this.ipAddress = ipAddress;
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
        this.ipAddress = ipAddress;
    }

    @Override
    public void disconnect() {
        this.ipAddress = "";
    }
}
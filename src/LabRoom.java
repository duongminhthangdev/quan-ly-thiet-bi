import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LabRoom {
    private String id;
    private String name;
    private int sucChua;
    private List<Device> devices;

    // Constructor
    public LabRoom(String id, String name, int sucChua) {
        this.id = id;
        this.name = name;
        this.sucChua = sucChua;
        this.devices = new ArrayList<>(); // Khởi tạo ArrayList tránh NullPointerException
    }

    // 1. Thêm thiết bị vào phòng
    public void addDevice(Device device) {
        if (device == null) {
            throw new IllegalArgumentException("Thiết bị không được để trống.");
        }

        // Kiểm tra xem mã thiết bị đã tồn tại trong phòng chưa
        for (Device d : devices) {
            // Giả sử Device có phương thức getId() hoặc thuộc tính protected id
            if (d.getId().equals(device.getId())) {
                throw new IllegalArgumentException("Mã thiết bị đã tồn tại trong phòng!");
            }
        }

        this.devices.add(device);
    }

    // 2. Xóa thiết bị theo ID (Trả về true nếu xóa thành công)
    public boolean removeDevice(String deviceId) {
        if (deviceId == null || deviceId.trim().isEmpty()) {
            return false;
        }
        return this.devices.removeIf(d -> d.getId().equals(deviceId));
    }

    // 3. Tìm kiếm thiết bị theo ID
    public Device findDevice(String deviceId) {
        if (deviceId == null) return null;

        for (Device d : devices) {
            if (d.getId().equals(deviceId)) {
                return d; // Tìm thấy
            }
        }
        return null; // Không tìm thấy
    }

    // 4. Tính tổng chi phí bảo trì của tất cả thiết bị trong phòng lab
    public BigDecimal calculateAnnualMaintenanceCost() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (Device d : devices) {
            if (d != null) {
                totalCost = totalCost.add(d.chiphiBaotri());
            }
        }
        return totalCost;
    }

    // 5. Lọc danh sách thiết bị cần bảo trì
    public List<Device> getDevicesRequiringMaintenance() {
        List<Device> requiresMaintenance = new ArrayList<>();
        for (Device d : devices) {
            if (d.getYear() > 5) {
                    requiresMaintenance.add(d);
            }
        }
        return requiresMaintenance;
    }

    // Getter và Setter
    public String getId() { return id; }
    public String getName() { return name; }
    public int getSucChua() { return sucChua; }
    public List<Device> getDevices() { return devices; }
}
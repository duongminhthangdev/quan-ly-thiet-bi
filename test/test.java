import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    @Test
    void testToanBoNghiepVuThietBi() {
        // --- 1. KHỞI TẠO CÁC THIẾT BỊ ---
        // (Điều chỉnh lại số lượng tham số cho khớp đúng với constructor bạn đang viết trong Computer, Printer, Projector)
        Computer pc1 = new Computer("PC01", "Gaming PC", new BigDecimal("25000000"), 2023, 16, "Intel i7", true);
        Computer pc2 = new Computer("PC02", "Office PC", new BigDecimal("12000000"), 2022, 8, "Intel i5", false);

        Printer printer1 = new Printer("PR01", "Heavy Printer", new BigDecimal("15000000"), 2021, Printer.Type.laser, 120000, false, false);
        Printer printer2 = new Printer("PR02", "Normal Printer", new BigDecimal("4000000"), 2023, Printer.Type.phun, 5000, false, false);

        Projector projector1 = new Projector("PJ01", "Hall Projector", new BigDecimal("18000000"), 2020, 4000, 3500);

        // Hai phòng thực hành
        LabRoom room1 = new LabRoom("LAB1", "Phòng Lab 1", 30);
        LabRoom room2 = new LabRoom("LAB2", "Phòng Lab 2", 30);

        // --- Thao tác 1: Thêm thiết bị vào phòng ---
        room1.addDevice(pc1);
        room1.addDevice(printer1);
        room1.addDevice(projector1);

        room2.addDevice(pc2);
        room2.addDevice(printer2);

        assertEquals(3, room1.getDevices().size(), "Phòng 1 phải có 3 thiết bị");
        assertEquals(2, room2.getDevices().size(), "Phòng 2 phải có 2 thiết bị");

        // --- Thao tác 2: Thử thêm thiết bị trùng mã (Phải báo lỗi) ---
        Computer duplicatePC = new Computer("PC01", "Trung Ma", new BigDecimal("10000000"), 2024, 8, "AMD", false);
        assertThrows(IllegalArgumentException.class, () -> {
            room1.addDevice(duplicatePC);
        }, "Phải ném ngoại lệ khi thêm thiết bị trùng mã!");

        // --- Thao tác 3: In danh sách thiết bị ---
        System.out.println("=== DANH SÁCH THIẾT BỊ PHÒNG 1 ===");
        for (Device d : room1.getDevices()) {
            System.out.println(d);
        }

        // --- Thao tác 4: Tính tổng chi phí bảo trì ---
        BigDecimal costRoom1 = room1.calculateAnnualMaintenanceCost();
        assertNotNull(costRoom1);
        assertTrue(costRoom1.compareTo(BigDecimal.ZERO) > 0, "Chi phí bảo trì phải lớn hơn 0");
        System.out.println("Tổng chi phí bảo trì Phòng 1: " + costRoom1);

        // --- Thao tác 5: Liệt kê thiết bị cần bảo trì ---
        List<Device> needMaintenance = room1.getDevicesRequiringMaintenance();
        assertTrue(needMaintenance.size() >= 1, "Phải tìm thấy thiết bị cần bảo trì");

        // --- Thao tác 6: Kết nối mạng thiết bị ---
        System.out.println("=== KẾT NỐI MẠNG THIẾT BỊ ===");
        for (Device device : room1.getDevices()) {
            if (device instanceof INetworkable) {
                INetworkable netDevice = (INetworkable) device;
                netDevice.connect("192.168.1.10");
                assertTrue(netDevice.isConnected(), "Thiết bị mạng phải chuyển sang trạng thái đã kết nối");
            }
        }
    }
}
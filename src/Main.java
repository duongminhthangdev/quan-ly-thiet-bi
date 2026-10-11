import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== KHOI TAO DU LIEU KIEM THU TOI THIEU ===");

        // 1. Tạo hai máy tính (1 máy có GPU rời, 1 máy không)
        // Constructor: Computer(id, name, price, serviceYear, ram, boxXuly, gpu)
        Computer comp1 = new Computer("PC01", "Gaming PC", new BigDecimal("1500.00"), 2, 16, "Intel Core i7", true);
        Computer comp2 = new Computer("PC02", "Office PC", new BigDecimal("600.00"), 3, 8, "Intel Core i5", false);

        // 2. Tạo hai máy in (1 máy in trên 100.000 trang)
        // Constructor: Printer(id, name, price, year, type, trang, network) hoặc NetworkPrinter
        Printer printer1 = new Printer("PR01", "HP LaserPrinter", new BigDecimal("300.00"), 1, Printer.Type.laser, 120000, false, false);
        NetworkPrinter printer2 = new NetworkPrinter("PR02", "Network Office Printer", new BigDecimal("450.00"), 2, Printer.Type.phun, 50000, "192.168.1.50");

        // 3. Tạo một máy chiếu có số giờ sử dụng trên 3.000 giờ (> 3000)
        // Constructor: Projector(id, name, price, year, doSang, soGio)
        Projector proj1 = new Projector("PJ01", "Sony Projector", new BigDecimal("800.00"), 2, 3500, 3500);

        // 4. Tạo hai phòng thực hành
        // Constructor: LabRoom(id, name, sucChua)
        LabRoom lab1 = new LabRoom("LAB1", "Phong Thuc Hanh 1", 30);
        LabRoom lab2 = new LabRoom("LAB2", "Phong Thuc Hanh 2", 25);

        System.out.println("\n--- 1. THEM THIET BI VAO PHONG ---");
        lab1.addDevice(comp1);
        lab1.addDevice(printer1);
        lab1.addDevice(proj1);

        lab2.addDevice(comp2);
        lab2.addDevice(printer2);

        System.out.println("Them thanh cong cac thiet bi vao LAB1 va LAB2.");

        System.out.println("\n--- 2. THU THEM MOT THIET BI BI TRUNG MA ---");
        // Thử thêm một máy tính có id trùng với comp1 ("PC01") vào lab2
        Computer duplicateComp = new Computer("PC01", "Duplicate PC", new BigDecimal("700.00"), 1, 8, "AMD Ryzen 5", false);
        lab2.addDevice(duplicateComp);

        System.out.println("\n--- 3. IN DANH SACH THIET BI TRONG TUNG PHONG ---");
        System.out.println("Phong: " + lab1.getName());
        for (Device d : lab1.getDevices()) {
            System.out.println(" - " + d.toString());
        }

        System.out.println("Phong: " + lab2.getName());
        for (Device d : lab2.getDevices()) {
            System.out.println(" - " + d.toString());
        }

        System.out.println("\n--- 4. TINH TONG CHI PHI BAO TRI DU KIEN CUA MOI PHONG ---");
        System.out.println("Tong chi phi bao tri LAB1: " + lab1.calculateAnnualMaintenanceCost() + " USD");
        System.out.println("Tong chi phi bao tri LAB2: " + lab2.calculateAnnualMaintenanceCost() + " USD");

        System.out.println("\n--- 5. LIET KE THIET BI CAN BAO TRI TRONG CAC PHONG ---");
        System.out.println("Cac thiet bi can bao tri tai LAB1:");
        for (Device d : lab1.getDevicesRequiringMaintenance()) {
            System.out.println(" - ID: " + d.getId() + " | Name: " + d.getName() + " | Chi phi: " + d.chiphiBaotri());
        }

        System.out.println("Cac thiet bi can bao tri tai LAB2:");
        for (Device d : lab2.getDevicesRequiringMaintenance()) {
            System.out.println(" - ID: " + d.getId() + " | Name: " + d.getName() + " | Chi phi: " + d.chiphiBaotri());
        }

        System.out.println("\n--- 6. KET NOI MANG CHO CAC DOI TUONG THUC THI INetworkable ---");
        // Sưu tầm tất cả thiết bị hỗ trợ INetworkable trong hệ thống để kết nối mạng
        connectAndTestNetwork(comp1);
        connectAndTestNetwork(printer2); // NetworkPrinter thực thi INetworkable

        System.out.println("\n=== HOAN THANH KIEM THU ===");
    }

    // --- 7. DUYET CAC THIET BI MANG THONG QUA KIEU INetworkable ---
    public static void connectAndTestNetwork(INetworkable netDevice) {
        System.out.println("Dang xu ly thiet bi mang co IP: " + netDevice.getIpAddress());
        if (!netDevice.isConnected()) {
            netDevice.connect(netDevice.getIpAddress());
        }
        System.out.println("Trang thai ket noi (isConnected): " + netDevice.isConnected());
    }
}
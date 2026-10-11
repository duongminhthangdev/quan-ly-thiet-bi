import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;


public class ComputerTest {

    @Test
    void testChiphiBaotriWithGpu() {
        // Khởi tạo một Computer để test
        // Tham số tùy theo constructor hiện tại của bạn: id, name, price, year, ram, boXuly, gpu...
        Computer comp = new Computer(
                "PC001",
                "Gaming PC",
                new BigDecimal("10000000"),
                2023,
                16,
                "Intel Core i5",
                true
        );

        // Kiểm tra xem phương thức chiphiBaotri() có hoạt động đúng không
        // Giả sử logic tính toán của bạn trả về một giá trị BigDecimal lớn hơn 0
        BigDecimal cost = comp.chiphiBaotri();

        assertNotNull(cost);
        // Kiểm tra chi phí phải lớn hơn 0
        assertTrue(cost.compareTo(BigDecimal.ZERO) > 0);
    }
}
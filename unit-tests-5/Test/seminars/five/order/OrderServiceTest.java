package seminars.five.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService = new OrderService(new PaymentService());

    @Test
    void placeOrder() {
        boolean result = orderService.placeOrder("a3", 500.00);

        assertTrue(result);
    }
}
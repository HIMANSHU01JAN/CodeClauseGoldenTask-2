public class PaymentProcessor {
    public static void main(String[] args) {
        // Initialize the payment gateway SDK with your API credentials
        PaymentGatewayClient paymentGateway = new PaymentGatewayClient("your_api_key");

        // Create a payment request
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(100.00);
        paymentRequest.setCurrency("USD");
        paymentRequest.setCardNumber("1234-5678-9012-3456");
        paymentRequest.setExpirationDate("12/25");
        paymentRequest.setCvv("123");

        // Process the payment
        PaymentResponse paymentResponse = paymentGateway.processPayment(paymentRequest);

        // Check the payment status and handle the response
        if (paymentResponse.isSuccess()) {
            System.out.println("Payment successful!");
            // Perform post-payment actions (e.g., update order status)
        } else {
            System.out.println("Payment failed: " + paymentResponse.getErrorMessage());
            // Handle payment failure (e.g., display an error message to the user)
        }
    }
}

package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.services.CheckoutService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // Get the cart from the purchase object
        Cart cart = purchase.getCart();

        // Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Get cart items from purchase and associate them with the cart
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> item.setCart(cart));

        // Set the customer in the cart
        cart.setCustomer(purchase.getCustomer());

        // Change cart status to ordered
        cart.setStatus(Cart.StatusType.ordered);

        // Save the cart
        cartRepository.save(cart);

        // Return the response with the tracking number
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // Generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}

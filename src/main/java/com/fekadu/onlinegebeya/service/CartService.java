package com.fekadu.onlinegebeya.service;

import com.fekadu.onlinegebeya.domain.Cart;
import com.fekadu.onlinegebeya.domain.CartEntry;
import com.fekadu.onlinegebeya.domain.Receipt;

import java.util.List;

public interface CartService {
    public Cart saveCart(Cart cart);
    public void removeCart(Cart cart);
    public CartEntry findById(Long id);
    public Cart findCartById(Long id);
    public List<CartEntry> getOrders();

    public CartEntry getCartEntryById(Long id);

    public List<CartEntry> getPendingOrders();

    public void saveCartEntry(CartEntry ce);

    public Receipt getReceipt(Long id);
}

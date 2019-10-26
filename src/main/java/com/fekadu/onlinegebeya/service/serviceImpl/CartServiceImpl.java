package com.fekadu.onlinegebeya.service.serviceImpl;

import com.fekadu.onlinegebeya.domain.Cart;
import com.fekadu.onlinegebeya.domain.CartEntry;
import com.fekadu.onlinegebeya.domain.Receipt;
import com.fekadu.onlinegebeya.repository.CartEntryRepo;
import com.fekadu.onlinegebeya.repository.CartRepo;
import com.fekadu.onlinegebeya.repository.ReceiptRepo;
import com.fekadu.onlinegebeya.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartEntryRepo cartEntryRepo;
    @Autowired
    private ReceiptRepo receiptRepo;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    public void removeCart(Cart cart) {
         cartRepo.delete(cart);
    }

    @Override
    public CartEntry findById(Long id) {
        return cartEntryRepo.getOne(id);
    }

    @Override
    public Cart findCartById(Long id) {
        return cartRepo.getOne(id);
    }

    @Override
    public List<CartEntry> getOrders() {
        return cartEntryRepo.getAllPending();
    }

    @Override
    public CartEntry getCartEntryById(Long id) {
        return cartEntryRepo.findById(id).get();
    }

    @Override
    public List<CartEntry> getPendingOrders() {
        return cartEntryRepo.getAllPending();
    }

    @Override
    public void saveCartEntry(CartEntry ce) {
        cartEntryRepo.save(ce);
    }

    @Override
    public Receipt getReceipt(Long id) {
        return receiptRepo.findById(id).get();
    }

}

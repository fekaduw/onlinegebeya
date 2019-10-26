package com.fekadu.onlinegebeya.service.serviceImpl;

import com.fekadu.onlinegebeya.domain.*;
import com.fekadu.onlinegebeya.repository.*;
import com.fekadu.onlinegebeya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    BuyerRepo buyerRepo;

    @Autowired
    SellerRepo sellerRepo;

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    RoleRepo roleRepo;

    public User save(User u){
        // Encode plaintext password
        u.setPassword(u.getPassword());
        //setting active 0 if seller
        if(u.getRole().equals("ROLE_SELLER")){
            u.setActive(false);
        }
        u.setActive(true);

        return userRepo.save(u);
    }

    @Override
    public List<User> findAll() {
        return (List)userRepo.findAll();
    }

    @Override
    public List<User> findAllByRole(String role) {
        return userRepo.findAllByRole(role);
    }

    @Override
    public User findById(Long i) {
        if(userRepo.findById(i).isPresent())
            return userRepo.findById(i).get();
        else
            return null;
    }

    @Override
    public Buyer saveBuyer(Buyer b) {
        return buyerRepo.save(b);
    }

    @Override
    public Seller saveSeller(Seller s) {
        return sellerRepo.save(s);
    }

    @Override
    public Seller getSellerById(Long id) {
        return sellerRepo.getOne(id);
    }

    @Override
    public List<Seller> getSellerByApproved(boolean b) {
        return sellerRepo.findByApproved(b);
    }

    @Override
    public List<Seller> getSellers() {
        return (List)sellerRepo.findAll();
    }

    @Override
    public Buyer getBuyerByUserId(Long id) {
        return buyerRepo.findByUserId(id);
    }


//    @Override
//    public User findById(Long i) {
//        if(userRepo.findById(i).isPresent())
//            return userRepo.findById(i).get();
//        else
//            return null;
//    }

    @Override
    public Admin saveAdmin(Admin a) {
        return adminRepo.save(a);
    }

    @Override
    public Buyer getBuyerById(Long id) {
        return buyerRepo.getOne(id);
    }

    @Override
    public List<Seller> getSellerByApproved(Boolean b) {
        return sellerRepo.findByApproved(b);
    }

    @Override
    public Seller findSellerByUserId(Long id) {
        return sellerRepo.findSellerByUserId(id);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepo.getOne(id);
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepo.findAll();
    }

    @Override
    public boolean checkRole(Long id, String role) {
        System.out.println("checking role +"+role+":"+userRepo.findById(id).get().getRole().getRole().equals(role));
        return userRepo.findById(id).get().getRole().getRole().equals(role);
    }

    @Override
    public User findByEmail(String uid) {
        return userRepo.findByEmail(uid);
    }
}

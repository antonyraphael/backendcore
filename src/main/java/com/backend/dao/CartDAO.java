package com.backend.dao;
import java.util.List;

import com.backend.model.Cart;

public interface CartDAO {
	public boolean addCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public boolean updateCart(Cart cart);
	public Cart getCart(int cardID);
	
public List<Cart> listCart(String username);
}

package com.amit.MovieFlix.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amit.MovieFlix.entity.User;
import com.amit.MovieFlix.exception.MissingUserDetails;
import com.amit.MovieFlix.exception.PasswordException;
import com.amit.MovieFlix.exception.AlreadyExistsException;
import com.amit.MovieFlix.exception.UserNotFoundException;
import com.amit.MovieFlix.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}
	
	@Override
	public User findOne(String id) {
		User existing = repository.findOne(id);
		if(existing == null)
			throw new UserNotFoundException("No user with ID- "+id+" found");
		return existing;
	}

	@Override
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null)
			throw new AlreadyExistsException("User eith email "+user.getEmail()+" already exists"); 
		else if(user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null)
			throw new MissingUserDetails("Missing parameters to create a new user");
		else if( user.getPassword() == null || user.getPassword().length() < 6)
			throw new PasswordException("Password too small");
		 
		return repository.create(user);
	}

	@Override
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if(existing == null)
			throw new UserNotFoundException("User doesn't exist");
		return repository.update(user);
	}

	@Override
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing == null)
			throw new UserNotFoundException("No user with ID- "+id+" found");
		repository.delete(existing);
	}

	private Session session;
    private int count = 0;

	@Override
	public boolean login(String email, String password) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		new Configuration().configure("/hibernate.cfg.xml");
		
		session = factory.openSession();
        String query = "select u from User u where u.email='" + email + "' and u.password='" + password + "'";
        Query DBquery = session.createQuery(query);
        for (Iterator<?> it = DBquery.iterate(); 
        		it.hasNext();
        		) 
        { 
        	it.next();
            count++;
        }
        System.out.println("Total rows: " + count);
        if (count == 1) {
            return true;
        } 
        else {
            return false;
        }    
	}
}

package com.beginner.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.beginner.workshop.exceptions.ControllerNotFoundException;
import com.beginner.workshop.exceptions.DataBaseException;
import com.beginner.workshop.models.User;
import com.beginner.workshop.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		try {
			User newEntity = repository.getReferenceById(id);
			newUpdate(newEntity, obj);
			return repository.save(newEntity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException(id);
		}
	}

	private void newUpdate(User newEntity, User obj) {
		newEntity.setName(obj.getName());
		newEntity.setEmail(obj.getEmail());
		newEntity.setPhone(obj.getPhone());
	}

}

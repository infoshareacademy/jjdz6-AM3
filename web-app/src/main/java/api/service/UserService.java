package api.service;

import api.domain.User;
import api.repository.UserRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserService {

    @Inject
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

}
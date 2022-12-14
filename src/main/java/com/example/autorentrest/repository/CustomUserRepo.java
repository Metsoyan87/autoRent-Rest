//package com.example.autorentrest.repository;
//
//import com.example.autorentrest.dto.UserFilterDto;
//import com.example.autorentrest.model.User;
//
//import com.querydsl.jpa.impl.JPAQuery;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Component
//public class CustomUserRepo {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public List<User> users(UserFilterDto userFilterDto) {
//        QUser qUser = QUser.user;
//        var jpaQuery = new JPAQuery(entityManager);
//        var from = jpaQuery.from(qUser);
//
//        if (userFilterDto.getName() != null && !userFilterDto.getName().equals("")) {
//            from.where(qUser.name.contains(userFilterDto.getName()));
//        }
//        if (userFilterDto.getSurname() != null && !userFilterDto.getSurname().equals("")) {
//            from.where(qUser.surname.contains(userFilterDto.getSurname()));
//        }
//        if (userFilterDto.getEmail() != null && !userFilterDto.getEmail().equals("")) {
//            from.where(qUser.email.contains(userFilterDto.getEmail()));
//        }
//        if (userFilterDto.getRole() != null) {
//            from.where(qUser.role.eq(userFilterDto.getRole()));
//        }
//        return from.fetch();
//
//
//    }
//
//}

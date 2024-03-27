package com.IMSBackend.IMS_Backend.dao;

import com.IMSBackend.IMS_Backend.model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberSearch {

    private final EntityManager em;
    public List<Member> findAllBySimpleQuery(
            String firstName,
            String lastName,
            String address
    ){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);

        Root<Member> root = criteriaQuery.from(Member.class);

        Predicate firstNamePredicate = criteriaBuilder
                .like(root.get("firstName"), "%" + firstName + "%");

        Predicate lastNamePredicate = criteriaBuilder
                .like(root.get("lastName"), "%" + lastName + "%");

        Predicate addressPredicate = criteriaBuilder
                .like(root.get("address"), "%" + address + "%");

        Predicate fnameorlnamePredicate = criteriaBuilder.or(
                firstNamePredicate,
                lastNamePredicate);

        var andAddressPredicate =  criteriaBuilder.and(fnameorlnamePredicate, addressPredicate);
        criteriaQuery.where(andAddressPredicate);

        TypedQuery<Member> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }


    public List<Member> findAllByCriteria(
            SearchRequest searchRequest
    ){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<Member> root = criteriaQuery.from(Member.class);
        if (searchRequest.getFirstName() != null){
            Predicate firstNamePredicate = criteriaBuilder
                    .like(root.get("firstName"), "%" + searchRequest.getFirstName() + "%");
            predicates.add(firstNamePredicate);
        }

        if (searchRequest.getLastName() != null){
            Predicate lastNamePredicate = criteriaBuilder
                    .like(root.get("lastName"), "%" + searchRequest.getLastName() + "%");
            predicates.add(lastNamePredicate);
        }

        if (searchRequest.getAddress() != null){
            Predicate addressPredicate = criteriaBuilder
                    .like(root.get("address"), "%" + searchRequest.getAddress() + "%");
            predicates.add(addressPredicate);
        }

        criteriaQuery.where(
                criteriaBuilder.or(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Member> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }
}

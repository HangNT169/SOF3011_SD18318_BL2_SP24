package com.sof3011.hangnt169.B10_Hibernate.repository;

import com.sof3011.hangnt169.B10_Hibernate.config.HibernateConfig;
import com.sof3011.hangnt169.B10_Hibernate.entity.Category1;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {

    // Viet ham CRUD (CREATE/READ/UPDATE/ DELETE)
    private Session session;

    public CategoryRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    // Get all
    public List<Category1> getAll() {
        List<Category1> lists = session.createQuery("FROM Category1 ").list();
        return lists;
    }

    // get one : select * from where id = ?
    public Category1 getOne(Long id) {
        return session.find(Category1.class, id);
    }

    // add
    public void add(Category1 c){
        try {
            session.beginTransaction().begin(); // Mo ra 1 transation => Loi => rollback
            session.persist(c); // Add => persist
            session.beginTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            // Loi => co the rollback o day
            session.beginTransaction().rollback();
        }
    }

    // update
    public void update(Category1 c){
        try {
            session.beginTransaction().begin(); // Mo ra 1 transation => Loi => rollback
            session.merge(c); // Update => merge
            session.beginTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            // Loi => co the rollback o day
            session.beginTransaction().rollback();
        }
    }

    // xoa
    public void xoa(Category1 c){
        try {
            session.beginTransaction().begin(); // Mo ra 1 transation => Loi => rollback
            session.delete(c); // Delete => merge
            session.beginTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            // Loi => co the rollback o day
            session.beginTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }
}

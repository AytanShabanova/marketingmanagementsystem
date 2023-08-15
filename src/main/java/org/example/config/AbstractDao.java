package org.example.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AbstractDao {
  private static EntityManagerFactory emf=null;
   public static EntityManager em(){
if (emf==null){
emf= Persistence.createEntityManagerFactory("myapp");
}
EntityManager entityManager=emf.createEntityManager();
return entityManager;
   }
   public static void closeEmf(){
emf.close();
   }
}

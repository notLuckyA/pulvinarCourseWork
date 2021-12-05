package com.alekssh.pulvinarcoursework.test;

import com.alekssh.pulvinarcoursework.functional.HibernateSession;
import com.alekssh.pulvinarcoursework.functional.InterfaceDB;
import com.alekssh.pulvinarcoursework.tables.Product;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTests {
    public static Product expected = new Product();

    @BeforeClass
    public static void expProduct() {
        expected.setNameProduct("test");
        expected.setTypeOfProduct("test");
        expected.setFillerPillows("test");
        expected.setSizeProduct("test");
        expected.setProductPrice(0);
    }

    @Test
    public void check1ProductCreate() {
        InterfaceDB.createProduct(expected);
        Product real = (Product) HibernateSession.getSessionFactory().openSession().createQuery("FROM Product P WHERE P.nameProduct = 'test'").uniqueResult();
        Assertions.assertTrue(real.getNameProduct().equals(expected.getNameProduct()) && real.getTypeOfProduct().equals(expected.getTypeOfProduct())
                && real.getFillerPillows().equals(expected.getFillerPillows()) && real.getSizeProduct().equals(expected.getSizeProduct())
                && real.getProductPrice().equals(expected.getProductPrice()));
    }

    @Test
    public void check2ProductUpdate() {
        Product real = (Product) HibernateSession.getSessionFactory().openSession().createQuery("FROM Product P WHERE P.nameProduct = 'test'").uniqueResult();
        real.setNameProduct("test1");
        expected.setNameProduct("test1");
        InterfaceDB.updateProductr(real);
        Assertions.assertTrue(real.getNameProduct().equals(expected.getNameProduct()) && real.getTypeOfProduct().equals(expected.getTypeOfProduct())
                && real.getFillerPillows().equals(expected.getFillerPillows()) && real.getSizeProduct().equals(expected.getSizeProduct())
                && real.getProductPrice().equals(expected.getProductPrice()));
    }

    @Test
    public void check3ProductDelete() {
        Product real = (Product) HibernateSession.getSessionFactory().openSession().createQuery("FROM Product P WHERE P.nameProduct = 'test1'").uniqueResult();
        InterfaceDB.deleteProduct(real);
        Assertions.assertNull(HibernateSession.getSessionFactory().openSession().createQuery("FROM Product P WHERE P.nameProduct = 'test1'").uniqueResult());
    }
}
//package com.devcamp.eztour.domain.rvw;
//
//import com.devcamp.eztour.domain.reserv.PageHandlerProduct;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class PageHandlerTest {
//    @Test
//    public void test() {
//        PageHandlerProduct ph = new PageHandlerProduct(250, 1);
//        ph.print();
//        System.out.println("ph = " + ph);
//        assertTrue(ph.getBeginPage() ==1);
//        assertTrue(ph.getEndPage() ==5);
//    }
//
//    @Test
//    public void test2() {
//        PageHandlerProduct ph = new PageHandlerProduct(250, 6);
//        ph.print();
//        System.out.println("ph = " + ph);
//        assertTrue(ph.getBeginPage() ==6);
//        assertTrue(ph.getEndPage() ==10);
//    }
//
//    @Test
//    public void test3() {
//        PageHandlerProduct ph = new PageHandlerProduct(255, 25);
//        ph.print();
//        System.out.println("ph = " + ph);
//        assertTrue(ph.getBeginPage() ==26);
//        assertTrue(ph.getEndPage() ==30);
//    }
//
//}
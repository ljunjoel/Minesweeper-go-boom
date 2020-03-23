/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author joel
 */
public class KassapaateTest {
    Kassapaate kassapaate;
    Maksukortti maksukortti;
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        maksukortti = new Maksukortti(1000);
    }
    
    @Test
    public void setUpOikein() {
        assertTrue(kassapaate.kassassaRahaa() == 100000);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 0);
        kassapaate = new Kassapaate();
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kateisostoToimiiEdullisestiKassaan() {
        kassapaate.syoEdullisesti(500);
        assertTrue(kassapaate.kassassaRahaa() == 100240);
    }
    
    @Test
    public void kateisostoVaihtoraha() {
        assertEquals(kassapaate.syoEdullisesti(250), 10);
        assertEquals(kassapaate.syoMaukkaasti(500), 100);
    }
    
    @Test
    public void kateisostoToimiiMaukkaastiKassaan() {
        kassapaate.syoMaukkaasti(500);
        assertTrue(kassapaate.kassassaRahaa() == 100400);
    }
    
    @Test
    public void kateisostoNostaaSaldoja() {
        kassapaate.syoMaukkaasti(400);
        kassapaate.syoEdullisesti(240);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 1);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void kateisostoKieltaaOikein() {
        kassapaate.syoEdullisesti(200);
        kassapaate.syoMaukkaasti(300);
        assertEquals(kassapaate.syoEdullisesti(200), 200);
        assertEquals(kassapaate.syoMaukkaasti(300), 300);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty()== 0);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 0);
        assertEquals(kassapaate.kassassaRahaa(), 100000);
    }
    
    @Test
    public void korttiostoToimiiOikein() {
        assertTrue(kassapaate.syoEdullisesti(maksukortti) == true);
        assertTrue(maksukortti.saldo() == 760);
        assertTrue(kassapaate.syoMaukkaasti(maksukortti) == true);
        assertTrue(maksukortti.saldo() == 360);
        assertEquals(kassapaate.edullisiaLounaitaMyyty(), 1);
        assertEquals(kassapaate.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kassapaate.kassassaRahaa(), 100000);
    }
    
    @Test
    public void korttiostoKieltaaOikein() {
        maksukortti = new Maksukortti(200);
        assertEquals(kassapaate.syoEdullisesti(maksukortti), false);
        assertEquals(kassapaate.syoMaukkaasti(maksukortti), false);
        assertEquals(kassapaate.edullisiaLounaitaMyyty(), 0);
        assertEquals(kassapaate.maukkaitaLounaitaMyyty(), 0);
        assertTrue(maksukortti.saldo() == 200);
        assertEquals(kassapaate.kassassaRahaa(), 100000);
    }
    
    @Test
    public void kortinLataaminenToimiiOikein() {
        kassapaate.lataaRahaaKortille(maksukortti, 1000);
        kassapaate.lataaRahaaKortille(maksukortti, -200);
        assertEquals(maksukortti.saldo(), 2000);
        assertEquals(kassapaate.kassassaRahaa(), 101000);
    }
}

package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoOikeinAlussa() {
        assertTrue(kortti.saldo() == 10);
    }
    
    @Test
    public void lataaminenToimiiOikein() {
        kortti.lataaRahaa(20);
        assertTrue(kortti.saldo() == 30);
    }
    
    @Test
    public void saldoVäheneeOikeinKunRiittää() {
        assertTrue(kortti.otaRahaa(10) == true);
        
    }
    
    @Test
    public void saldoPalauttaaFalseKunEiRiitä() {
        assertTrue(kortti.otaRahaa(20) == false);
    }
    
    @Test
    public void saldoEiMuutuKunEiRiitä() {
        kortti.otaRahaa(20);
        assertTrue(kortti.saldo() == 10);
    }
}

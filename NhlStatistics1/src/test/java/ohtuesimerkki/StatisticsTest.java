/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author sampo
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void test0() {
        System.out.println("OK!!");
    }

    @Test
    public void test1a() {

        Player pelaaja;
        pelaaja = stats.search("Semenko");
        String nimi = pelaaja.getName();
        assertEquals("Semenko", nimi);
    }

    @Test
    public void test1b() {

        Player pelaaja;
        pelaaja = stats.search("Ketola");
        assertNull(pelaaja);

    }

    @Test
    public void test2a() {

        List<Player> players3 = stats.team("PIT");
        Player pelaaja = players3.get(0);

        String nimi = players3.get(0).getName();

        assertEquals("Lemieux", nimi);

    }

    @Test
    public void test2b() {

        ArrayList<Player> vertaa = new ArrayList<Player>();
        List<Player> players = stats.team("OTT");
        assertEquals(vertaa, players);

    }

    @Test
    public void test3a() {
        // Nolla pienemmän määrän haku
        ArrayList<Player> vertaa = new ArrayList<Player>();
        List<Player> players = stats.topScorers(-1);        
        assertEquals(vertaa, players);

    }

    @Test
    public void test3b() {
        // Nolla pienemmän määrän haku

//        ArrayList<Player> vertaa = new ArrayList<Player>();
//        List<Player> players = stats.topScorers(1);
//        String nimi = players.get(0).getName();
//        assertEquals("Gretzky", nimi);

        assertEquals("Gretzky", stats.topScorers(1).get(0).getName());

        

    }
    
    
    
}

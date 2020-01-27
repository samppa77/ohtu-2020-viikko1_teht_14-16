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

//        List<Player> players2 = new ArrayList<>();
//        players2.add(new Player("Lemieux", "PIT", 45, 54));
//        players2.add(new Player("Semenko", "EDM", 4, 12));
//        players2.add(new Player("Kurri", "EDM", 37, 53));
//        players2.add(new Player("Gretzky", "EDM", 35, 89));
//        String tiimi = stats.team("PIT").getTeam();
//        ArrayList<Player> players3 = stats.team("PIT");
        List<Player> players3 = stats.team("PIT");
        Player pelaaja = players3.get(0);

        String nimi = players3.get(0).getName();
        /*
                
                .getName());
        System.out.println(players3);
         */

//        System.out.println("Joukkue on: " + tiimi);
        assertEquals("Lemieux", nimi);

    }

    @Test
    public void test2b() {

//        List<Player> players2 = new ArrayList<>();
//        players2.add(new Player("Lemieux", "PIT", 45, 54));
        ArrayList<Player> vertaa = new ArrayList<Player>();

        List<Player> players = stats.team("OTT");

//        assertNull(players);
        assertEquals(vertaa, players);

    }
}

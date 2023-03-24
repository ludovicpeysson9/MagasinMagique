package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestMagasin {

    @Test
    void testList() {
        Item[] items = new Item[]{new Item("kryptonite", 20, 30)};
        Magasin app = new Magasin(items);
        if (app.nomArticles.contains((items[0].name).toUpperCase())) {
            assertEquals("kryptonite", app.items[0].name);
        } else {
            assertEquals("kryponite", app.items[0].name);
        }
    }


    @Test
    void lambdaProductTest() {
        Item[] items = new Item[]{new Item("lambda", 20, 30)};
        Magasin app = new Magasin(items);
        for (int i = 0; i < 30; i++) {
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }
        assertEquals("lambda", app.items[0].name);
    }

    @Test
    void kryptoniteProductTest() {
        Item[] items = new Item[]{new Item("Kryptonite", 15, 15)};
        Magasin app = new Magasin(items);
        for (int i = 0; i < 10; i++) {
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }
        assertEquals("Kryptonite", app.items[0].name);
    }

    @Test
    void comteProductTest() {
        Item[] items = new Item[]{new Item("Comté", 5, 30)};
        Magasin app = new Magasin(items);
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }
        assertEquals("Comté", app.items[0].name);

    }

    @Test
    void vipProductTest() {
        Item[] items = new Item[]{new Item("Pass VIP Concert", 12, 30)};
        Magasin app = new Magasin(items);
        for (int i = 0; i < 20; i++) {
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }

        assertEquals("Pass VIP Concert", app.items[0].name);
    }

    @Test
    void pouvoirsMagiquesProductTest() {
        Item[] items = new Item[]{new Item("Pouvoirs Magiques", 10, 30)};
        Magasin app = new Magasin(items);
        for (int i = 0; i < 20; i++) {
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }
        assertEquals("Pouvoirs Magiques", app.items[0].name);
    }

    @Test
    void testMaxValueQualityOfItems() {
        Item[] items = new Item[]{
                new Item("Kryptonite", 10, 80),
                new Item("Kryptonite", 10, 15),
                new Item("Comté", 8, 45),
                new Item("Pass VIP Concert", 20, 40)
        };

        Magasin app = new Magasin(items);


        for (int i = 0; i < 10; i++) {
            app.updateQuality();
        }
        assertTrue(items[0].quality == 80);
        assertTrue(items[1].quality == 80);
        assertTrue(items[2].quality == 50);
        assertTrue(items[3].quality == 50);
    }

    @Test
    void testValuePassVipConcertWhenSellInZero() {
        Item[] items = new Item[]{
                new Item("Pass VIP Concert", 1, 50)
        };

        Magasin app = new Magasin(items);

        app.updateQuality();

        assertTrue(items[0].quality == 0);
    }

    @Test
    void testValueVipConcertBetweenTenAndFiveDaysLeft() {
        Item[] items = new Item[]{
                new Item("Pass VIP Concert", 11, 40),
                new Item("Pass VIP Concert", 9, 40),
                new Item("Pass VIP Concert", 4, 40)
        };

        Magasin app = new Magasin(items);

        app.updateQuality();

        assertTrue(items[0].quality == 41);
        assertTrue(items[1].quality == 42);
        assertTrue(items[2].quality == 43);
    }

    @Test
    void testIfQualityDropsByTwoWhenSellInIsOver(){
        Item[] items = new Item[]{
                new Item("lambda", 0, 20),
                new Item("Pouvoirs Magiques", 0, 40)
        };

        Magasin app = new Magasin(items);

        for(int i = 0; i < 5; i++){
            app.updateQuality();
        }

        assertTrue(items[0].quality == 10);
        assertTrue(items[1].quality == 20);
    }

    @Test
    void testIfComteGainQualityOverTime(){
        Item[] items = new Item[]{
                new Item("Comté", 6, 20),
                new Item("Comté", 0, 20),
        };

        Magasin app = new Magasin(items);

        for(int i = 0; i < 5; i++){
            app.updateQuality();
        }

        assertTrue(items[0].quality == 25);
        assertTrue(items[1].quality == 30);
    }

    @Test
    void testMinQualityValueOfItems(){
        Item[] items = new Item[]{
                new Item("lambda", 0, 1),
                new Item("Pouvoirs Magiques", 0, 2),
                new Item("Pass VIP Concert", 2, 40)
        };
        Magasin app = new Magasin(items);

        for(int i = 0; i < 5; i++){
            app.updateQuality();
        }

        assertTrue(items[0].quality >= 0);
        assertTrue(items[1].quality >= 0);
        assertTrue(items[2].quality >= 0);
    }
}

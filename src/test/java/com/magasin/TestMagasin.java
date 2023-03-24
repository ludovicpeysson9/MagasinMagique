package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMagasin {

    @Test
    void testList(){
        Item[] items = new Item[] { new Item("kryptonite", 20, 30)};
        Magasin app = new Magasin(items);
        if(app.nomArticles.contains((items[0].name).toUpperCase())){
            assertEquals("kryptonite", app.items[0].name);
        }else{
            assertEquals("kryponite", app.items[0].name);
        }
    }


    @Test
    void lambdaProductTest() {
        Item[] items = new Item[] { new Item("lambda", 20, 30) };
        Magasin app = new Magasin(items);
        for(int i = 0; i < 30; i++){
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }
        assertEquals("lambda", app.items[0].name);
    }

    @Test
    void kryptoniteProductTest(){
        Item[] items = new Item[] { new Item("Kryptonite", 15, 15) };
        Magasin app = new Magasin(items);
        for(int i = 0; i < 10; i++){
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }
        assertEquals("Kryptonite",app.items[0].name);
    }
    @Test
    void comteProductTest(){
        Item[] items = new Item[] { new Item("Comté", 5, 30) };
        Magasin app = new Magasin(items);
        for(int i = 0; i < 50; i++){
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }
        assertEquals("Comté",app.items[0].name);

    }
    @Test
    void vipProductTest(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 12, 30) };
        Magasin app = new Magasin(items);
        for(int i = 0; i < 20; i++){
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }

        assertEquals("Pass VIP Concert",app.items[0].name);
    }

    @Test
    void pouvoirsMagiquesProductTest(){
        Item[] items = new Item[] { new Item("Pouvoirs Magiques", 10, 30) };
        Magasin app = new Magasin(items);
        for(int i = 0; i < 20; i++){
            app.updateQuality();
            System.out.println(items[0].name);
            System.out.println(items[0].sellIn);
            System.out.println(items[0].quality);
        }
        assertEquals("Pouvoirs Magiques",app.items[0].name);
    }

//    @Test
//    void testMaxValueQualityOfItems(){
//        Item[] items = new Item[] { new Item("Pouvoirs Magiques", 10, 30) };
//        Magasin app = new Magasin(items);
//    }


}

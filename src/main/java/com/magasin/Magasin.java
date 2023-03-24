package com.magasin;

import java.util.List;

class Magasin {
    Item[] items;
    public List<String> nomArticles = List.of(
            "Kryptonite",
            "Comté",
            "Pass VIP Concert",
            "Pouvoirs Magiques"
    );


    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (nomArticles.contains(item.name)) {
                if (item.name.equals("Comté")) {
                    updateComte(item);
                }
                if (item.name.equals("Kryptonite")) {
                    updateKryptonite(item);
                }
                if (item.name.equals("Pass VIP Concert")) {
                    updatePassVipConcert(item);
                }
                if (item.name.equals("Pouvoirs Magiques")) {
                    updatePouvoirsMagiques(item);
                }
            } else {
                updateLambdaItem(item);
            }
        }
    }


    public void updateLambdaItem(Item item) {
        if (item.sellIn > 0) {
            item.quality--;
        }
        if (item.sellIn <= 0) {
            item.quality -= 2;
        }
        if (item.quality <= 0) {
            item.quality = 0;
        }
        item.sellIn--;
    }

    public void updateComte(Item item) {
        if (item.sellIn > 0) {
            item.quality++;
        } else if (item.sellIn <= 0) {
            item.quality += 2;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
        item.sellIn--;
    }

    public void updatePassVipConcert(Item item) {
        if (item.sellIn > 0) {
            if (item.sellIn >= 11) {
                item.quality++;
            }
            if (item.sellIn <= 5) {
                item.quality += 3;
            } else if (item.sellIn <= 10) {
                item.quality += 2;
            }
            item.sellIn--;
        }
        if (item.sellIn == 0) {
            item.quality = 0;
            item.sellIn--;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

    //    public void updateKryptonite() {
//        for (Item item : items) {
//            if (nomArticles.contains(item.name)) {
//                item.quality = 80;
//            }
//        }
//    }
    public void updateKryptonite(Item item) {
        item.quality = 80;
    }

    public void updatePouvoirsMagiques(Item item) {
        if (nomArticles.contains(item.name) && item.sellIn >= 1) {
            item.quality -= 2;
        }
        if (nomArticles.contains(item.name) && item.sellIn <= 0) {
            item.quality -= 4;
        }
        if (item.quality <= 0) {
            item.quality = 0;
        }
        item.sellIn--;
    }
}

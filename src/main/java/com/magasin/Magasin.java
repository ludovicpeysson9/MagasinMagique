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
                    updateComte();
                }
                if (item.name.equals("Kryptonite")) {
                    updateKryptonite();
                }
                if (item.name.equals("Pass VIP Concert")) {
                    updatePassVipConcert();
                }
                if (item.name.equals("Pouvoirs Magiques")) {
                    updatePouvoirsMagiques();
                }
            } else {
                updateLambdaItem();
            }
        }
    }


    public void updateLambdaItem() {
        for (Item item : items) {
            if (!nomArticles.contains(item.name) && item.sellIn > 0) {
                item.quality--;
            }
            if (!nomArticles.contains(item.name) && item.sellIn <= 0) {
                item.quality -= 2;
            }
            if (item.quality <= 0) {
                item.quality = 0;
            }
            item.sellIn--;
        }
    }

    public void updateComte() {
        for (Item item : items) {
            if (nomArticles.contains(item.name) && item.sellIn > 0) {
                item.quality++;
            } else if (nomArticles.contains(item.name) && item.sellIn <= 0) {
                item.quality += 2;
            }
            if (item.quality > 50) {
                item.quality = 50;
            }
            item.sellIn--;
        }
    }

    public void updatePassVipConcert() {
        for (Item item : items) {
            if (nomArticles.contains(item.name) && item.sellIn > 0) {
                if (nomArticles.contains(item.name) && item.sellIn >= 11) {
                    item.quality++;
                }
                if (nomArticles.contains(item.name) && item.sellIn <= 5) {
                    item.quality += 3;
                } else if (nomArticles.contains(item.name) && item.sellIn <= 10) {
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
    }

    public void updateKryptonite() {
        for (Item item : items) {
            if (nomArticles.contains(item.name)) {
                item.quality = 80;
            }
        }
    }

    public void updatePouvoirsMagiques() {
        for (Item item : items) {
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
}

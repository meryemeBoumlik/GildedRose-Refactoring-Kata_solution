package com.gildedrose;


class GildedRose {
    Item[] items;
    enum levels {
        Sulfuras {
            public String toString() {
                return "Sulfuras, Hand of Ragnaros";
            }
        },
        Backstage {
            public String toString() {
                return "Backstage passes to a TAFKAL80ETC concert";
            }
        },
        AGED {
            public String toString() {
                return "Aged Brie";
            }
        };
    }


    public GildedRose(Item[] items) {
        this.items = items;
    }


  public void  changequality( Item item){
      if (item.quality < 50) {
          item.quality =+ 1;
      }
      if (item.quality > 0) {
          item.quality = item.quality - 1;
      }
  }

    public void updateQuality() {
        for (Item item :items) {
            if (!levels.AGED.equals(item.name) && !levels.Backstage.equals(item.name)){
                    changequality(item);
            } else {
                changequality(item);

                    if (levels.Backstage.equals(item.name)) {
                        if (item.sellIn < 11) {
                            changequality(item);
                        }
                        if (item.sellIn < 6) {
                            changequality(item);
                        }

                }
            }

            if (!levels.Sulfuras.equals(item.name)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!levels.AGED.equals(item.name)) {
                    if (!levels.Backstage.equals(item.name)) {
                        if (item.quality > 0) {
                            if (!levels.Sulfuras.equals(item.name)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    changequality(item);
                }
            }
        }
    }
}

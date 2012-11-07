package net.takaiwa.enumsample;

import android.content.res.Resources;

public enum Sweets {

    ECLAIR(R.string.spin_product_name_eclair, R.string.spin_product_price_eclair),
    FROZEN_YOGURT(R.string.spin_product_name_froyo, R.string.spin_product_price_froyo),
    GINGERBREAD(R.string.spin_product_name_gingerbread, R.string.spin_product_price_gingerbread),
    ICE_CREAM_SANDWICH(R.string.spin_product_name_ics, R.string.spin_product_price_ics);

    int id_name,id_price;
    Sweets(int id_name, int id_price) {
        this.id_name = id_name;
        this.id_price = id_price;
    }

    public String getName(Resources r) {
        return r.getString(this.id_name);
    }

    public String getPrice(Resources r) {
        return r.getString(this.id_price);
    }
}

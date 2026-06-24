package org.example;

import com.google.gson.annotations.SerializedName;

public enum OrderSide {
    @SerializedName("bid")
    BID,
    @SerializedName("offer")
    OFFER
}

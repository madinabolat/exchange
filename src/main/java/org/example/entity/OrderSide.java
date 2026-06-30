package org.example.entity;

import com.google.gson.annotations.SerializedName;

public enum OrderSide {
    @SerializedName("bid")
    BID,
    @SerializedName("offer")
    OFFER
}

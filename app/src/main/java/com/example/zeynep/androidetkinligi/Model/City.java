package com.example.zeynep.androidetkinligi.Model;

/**
 * Created by Zeynep on 25.06.2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class City  implements Serializable {




    public City(String adi) {
        this.adi = adi;

    }

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("adi")
        @Expose
        private String adi;
        @SerializedName("radi")
        @Expose
        private String radi;



    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAdi() {
            return adi;
        }

        public void setAdi(String adi) {
            this.adi = adi;
        }

        public String getRadi() {
            return radi;
        }

        public void setRadi(String radi) {
            this.radi = radi;
        }


    @Override
    public String toString() {
            if(adi==null)
                adi = "";
        return adi;
    }
}


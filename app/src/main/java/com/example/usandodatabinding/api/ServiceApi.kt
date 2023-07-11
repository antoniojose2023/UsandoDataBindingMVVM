package com.example.usandodatabinding.api

import com.example.usandodatabinding.model.Time

class ServiceApi {
    companion object{
        fun getListTimes(): MutableList<Time>{
             return mutableListOf(
                 Time(1,"Cruzeiro"),
                 Time(2,"Ceara"),
                 Time(3,"Flamengo"),
                 Time(4,"Vasco"),
                 Time(5,"Cuiaba")
             )
        }
    }
}
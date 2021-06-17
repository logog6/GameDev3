package com.example.gamedev
import java.io.Serializable

class Modal(name: String, image: Int, description:String) :Serializable {
    var name:String?= name
    var image:Int?= image
    var description:String? = description
}
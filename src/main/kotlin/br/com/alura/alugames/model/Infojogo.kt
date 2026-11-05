package br.com.alura.alugames.model

import com.google.gson.annotations.SerializedName

class Infojogo(@SerializedName("info") val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}
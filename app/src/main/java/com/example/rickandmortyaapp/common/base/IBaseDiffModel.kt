package com.example.rickandmortyaapp.common.base

interface IBaseDiffModel {
    val id: Int
    override fun equals(other: Any?): Boolean
}
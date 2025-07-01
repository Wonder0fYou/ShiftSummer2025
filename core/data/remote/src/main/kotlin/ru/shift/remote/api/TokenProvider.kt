package ru.shift.remote.api

interface TokenProvider {
    fun getToken(): String
}
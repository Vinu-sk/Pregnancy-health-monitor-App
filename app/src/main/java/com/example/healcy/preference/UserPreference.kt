package com.example.healcy.preference

import android.content.Context
import com.example.healcy.data.User

class UserPreference (context: Context){
    companion object{
        const val EXTRA_LOGIN = "login"
        const val EXTRA_ID = "id"
        const val EXTRA_NAME ="name"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_TOKEN = "token"
        const val LOGIN_STATE = "login_state"
    }

    val preferences = context.getSharedPreferences(EXTRA_LOGIN, Context.MODE_PRIVATE)

    fun setUser(user: User){
        val login = preferences.edit()
        login.putString(EXTRA_ID, user.id)
        login.putString(EXTRA_NAME, user.name)
        login.putString(EXTRA_EMAIL, user.email)
        login.putString(EXTRA_TOKEN, user.token)
        login.putBoolean(LOGIN_STATE, user.isLogin)
        login.apply()
    }

    fun getUser(): User {
        return User(
            preferences.getString(EXTRA_ID, "") ?: "",
            preferences.getString(EXTRA_NAME, "") ?: "",
            preferences.getString(EXTRA_EMAIL, "") ?: "",
            preferences.getString(EXTRA_TOKEN, "") ?: "",
            preferences.getBoolean(LOGIN_STATE, false)
        )
    }

    fun logout(){
        val user = preferences.edit()
        user.remove(EXTRA_NAME)
        user.remove(EXTRA_TOKEN)
        user.putBoolean(LOGIN_STATE, false)
        user.apply()
    }
}
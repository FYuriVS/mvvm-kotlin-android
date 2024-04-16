package com.yurivital.mvvm_example

class PersonRepository {

    fun login(email: String, password: String): Boolean{
        if(email.isNotEmpty() && password.isNotEmpty()){
            return true
        } else {
            return  false
        }
    }
}
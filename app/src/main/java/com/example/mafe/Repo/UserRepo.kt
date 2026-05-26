package com.example.mafe.Repo

import com.example.mafe.ForgotPassword
import com.example.mafe.Model.UserModel
import com.example.mafe.Register
import javax.security.auth.callback.Callback

interface UserRepo {
    fun Login(
        email: String, password: String,
        callback: (Boolean, String)-> Unit
    )
    //authentication function
    fun Register(email: String, password: String,userModel: UserModel,callback: (Boolean, String, String) -> Unit)


    //database function
    fun addUser(id: String,userModel: UserModel,callback: (Boolean, String) -> Unit)

    fun ForgotPassword(email: String,callback: (Boolean, String) -> Unit)

    fun getUserById(id: String, callback: (Boolean, String, UserModel?) -> Unit)

    fun getAllUser(callback: (Boolean, String, List<UserModel?>) -> Unit)

    fun editProfile(id: String, userModel: UserModel, callback: (Boolean, String) -> Unit)

    fun deleteAccount(id: String, callback: (Boolean, String) -> Unit)

    fun Logout(callback: (Boolean, String) -> Unit)
}
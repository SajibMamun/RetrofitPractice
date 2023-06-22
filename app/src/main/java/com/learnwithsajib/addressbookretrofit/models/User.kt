package com.learnwithsajib.addressbookretrofit.models

data class User(
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var address: address,
    var phone: String,
    var website: String,
    var company: company

)

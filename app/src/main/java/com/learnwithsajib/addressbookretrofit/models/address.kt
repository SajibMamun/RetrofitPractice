package com.learnwithsajib.addressbookretrofit.models

data class address(
    var street: String,
    var suite: String,
    var city: String,
    var zipcode: String,
    var geo: geo
)

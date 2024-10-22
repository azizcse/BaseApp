package com.tsl.baseapp.data.model.response

/**
 * @author md-azizul-islam
 * Created 10/22/24 at 3:01 PM
 */
class UserResponse : ArrayList<UserResponseItem>()

data class UserResponseItem(
    val address: Address? = null,
    val company: Company? = null,
    val email: String = "",
    val id: Int = 9,
    val name: String = "",
    val phone: String = "",
    val username: String = "",
    val website: String = ""
)

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)

data class Company(
    val bs: String,
    val catchPhrase: String,
    val name: String
)

data class Geo(
    val lat: String,
    val lng: String
)

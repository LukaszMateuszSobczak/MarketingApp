package com.lukaszsobczak.marketingapp

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val availableDate: String,
    val junior: Boolean,
    val immediateStart: Boolean,
    val jobTitle: String
) : Serializable {

//    fun getFullJobDescription(): String? {
//        // standard if-else
////        if (junior) {
////            return "junior $jobTitle"
////        } else {
////            return jobTitle
////        }
//        // kotlin 'return' if-else
////        return if (junior) {
////            "junior $jobTitle"
////        } else {
////            jobTitle
////        }
//        // one line if-else
//        return if(junior) "junior $jobTitle" else jobTitle
//    }

    fun getFullJobDescription() = if(junior) "a junior $jobTitle" else "an $jobTitle"

    fun checkAvailability() = if(immediateStart) "immediate" else "from $availableDate"
}
package com.infos.panikat.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.infos.panikat.data.ResultData
import com.infos.panikat.data.cardData

class HomeViewModel: ViewModel() {

    private var list = mutableListOf<cardData>()
    private val _card = MutableLiveData<List<cardData>>()
    val card: LiveData<List<cardData>> = _card
    private val db by lazy { FirebaseFirestore.getInstance() }


    fun getData() {
        db.collection("CardCollection").document("Card").get()
            .addOnSuccessListener { documentSnapshot ->
                val user = documentSnapshot.toObject<ResultData>()
                if (user != null) {
                    for (item in user.list!!) {
                        val title = item.title
                        val desc = item.desc
                        val time = item.time
                        val card1 = cardData(title, desc, time)
                        list.add(card1)
                    }
                    _card.value = list
                }
            }.addOnFailureListener {
                println(it.localizedMessage)
            }
    }


    /*fun pushData(){
        val pushList= mutableListOf<cardData>()
        val card = cardData("teststsdfa","testsfds","32")
        pushList.add(card)
        db.collection("CardCollection").document("Card").set(ResultData(pushList)).addOnCompleteListener {

        }
    }*/
}
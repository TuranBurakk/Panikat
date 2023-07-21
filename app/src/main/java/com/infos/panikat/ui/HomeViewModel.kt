package com.infos.panikat.ui

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.infos.panikat.data.cardData

class HomeViewModel: ViewModel() {
    private var list = mutableListOf<cardData>()
    private val _card = MutableLiveData<List<cardData>>()
    val card: LiveData<List<cardData>> = _card

    private val db by lazy {
        FirebaseFirestore.getInstance()
    }
    fun getData(context: Context){
        db.collection("CardCollection").document("Card").get().addOnSuccessListener {DocumentSnapshot ->

            val dataList = DocumentSnapshot.toObject<cardData>()
            if (dataList != null) {
                list.add(dataList)
                _card.value = list
            }
            else{
                Toast.makeText(context,"data error",Toast.LENGTH_LONG).show()
            }
        }
    }
}
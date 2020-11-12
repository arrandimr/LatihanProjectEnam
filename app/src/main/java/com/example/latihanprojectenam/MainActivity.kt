package com.example.latihanprojectenam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneData()
        rv_parts.layoutManager = LinearLayoutManager(this)
        rv_parts.setHasFixedSize(true)
        rv_parts.adapter = ContactAdapter(testData, {phoneItem : PhoneData -> phoneItemClicked(phoneItem)})
    }
    private fun phoneItemClicked(phoneItem : PhoneData) {
        val showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, phoneItem.contactName)
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData() : List<PhoneData>{
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData("+62 851-5530-6005","Januar"))
        partList.add(PhoneData("+62 895-6323-32675","Nizar"))
        partList.add(PhoneData("+62 851-0599-1200","Aldo"))
        partList.add(PhoneData("+62 821-3588-8551","Yudha"))
        partList.add(PhoneData("+62 899-3704-720", "Helmy"))
        return partList
    }
}
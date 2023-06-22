package com.learnwithsajib.addressbookretrofit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.learnwithsajib.addressbookretrofit.databinding.AdresslayoutitemBinding
import com.learnwithsajib.addressbookretrofit.models.User

class AddressAdapter ():ListAdapter<User,AddressAdapter.AddressViewHolder>(comparator) {

    class AddressViewHolder(var binding: AdresslayoutitemBinding) :
        RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        return AddressViewHolder(AdresslayoutitemBinding.inflate(LayoutInflater.from(parent.context),parent
        ,false))
    }




    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
      getItem(position).let {
          holder.binding.nameText.text=it.name
          holder.binding.emailText.text=it.email
          holder.binding.phoneText.text=it.phone
          holder.binding.streetText.text=it.address.street
          holder.binding.suiteText.text=it.address.suite
          holder.binding.cityText.text=it.address.city
          holder.binding.zipcodeText.text=it.address.zipcode
          holder.binding.companyNameText.text=it.company.name
          holder.binding.catchphraseText.text=it.company.catchPhrase
          holder.binding.businessStatementText.text=it.company.bs

      }

    }








    companion object {

        var comparator = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }


        }
    }


}
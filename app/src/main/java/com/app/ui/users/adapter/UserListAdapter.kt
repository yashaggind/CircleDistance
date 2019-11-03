package com.app.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.callBacks.DiffUtilCallback
import com.app.great_circle_distance.R
import com.app.great_circle_distance.databinding.AdapterUserListBinding
import com.app.model.UserEntity
import kotlin.properties.Delegates

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.MyViewHolder>(), DiffUtilCallback {

    var items : List<UserEntity> by Delegates.observable(emptyList()) { _, oldItem, newItem ->
        autoNotify(oldItem, newItem) { old, new -> old.userId == new.userId }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: AdapterUserListBinding = DataBindingUtil
            .inflate(LayoutInflater.from(parent.context), R.layout.adapter_user_list, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    // Gets the number of Items in the list
    override fun getItemCount(): Int = items.size

    inner class MyViewHolder(private val binding: AdapterUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(usersEntity: UserEntity) {
            binding.entity = usersEntity
        }
    }
}

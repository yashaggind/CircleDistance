package com.app.ui.users.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.great_circle_distance.R
import com.app.model.UserEntity
import com.app.ui.users.adapter.UserListAdapter
import com.app.ui.users.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_user_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class UserListActivity : AppCompatActivity() {

    // FOR DATA ---
    private val userVM : UserViewModel by viewModel()
    private val userListAdapter = UserListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        initRecyclerView()

        userVM.getUserData().observe(this, Observer {

            it?.let {
                if (it.isNotEmpty()) {
                    sortUserId(it)
                    userListAdapter.items = it
                }
            }
        })
    }

    //Setup the adapter class for the RecyclerView
    private fun initRecyclerView() {
        recylv_users?.layoutManager = LinearLayoutManager(this)
        recylv_users?.adapter = userListAdapter
    }

    private fun sortUserId(list: ArrayList<UserEntity>) =
        list.sortWith(Comparator { lhs, rhs -> lhs.userId.compareTo(rhs.userId) })
}

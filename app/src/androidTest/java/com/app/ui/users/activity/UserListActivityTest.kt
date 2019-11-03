package com.app.ui.users.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.app.great_circle_distance.R
import com.app.utils.RecyclerViewMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class UserListActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<UserListActivity>
            = ActivityTestRule(UserListActivity::class.java)

    @Test
    fun match_data_in_Recyclerview() {

        onView(RecyclerViewMatcher(R.id.recylv_users)
            .atPositionOnView(1, R.id.tv_user_id))
            .check(matches(withText("User Id : 5")))
            .perform(click())

        onView(RecyclerViewMatcher(R.id.recylv_users)
                .atPositionOnView(2, R.id.tv_user_name))
                .check(matches(withText("User Name : Theresa Enright")))
                .perform(click())

        onView(RecyclerViewMatcher(R.id.recylv_users)
            .atPositionOnView(3, R.id.tv_user_distance))
            .check(matches(withText("User distance : 72  Km")))
            .perform(click())

    }
}
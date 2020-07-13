package com.ciriti.bookapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.util.test.matchAtPositionInRecyclerView
import com.util.test.waitAndRetry
import org.hamcrest.CoreMatchers

class BooksListRobot {

    suspend fun verifyTitle(title: String, position: Int): BooksListRobot = apply {
        waitAndRetry {
            Espresso.onView(ViewMatchers.withId(R.id.books_list))
                .check(
                    ViewAssertions.matches(
                        matchAtPositionInRecyclerView(
                            position, ViewMatchers.hasDescendant(
                                CoreMatchers.allOf(
                                    ViewMatchers.withId(R.id.title),
                                    ViewMatchers.withText(title)
                                )
                            )
                        )
                    )
                )
        }
    }

    suspend fun sortByFavorites(): BooksListRobot = apply {
        waitAndRetry {
            Espresso.onView(ViewMatchers.withId(R.id.action_sort_desc_favorites))
                .perform(ViewActions.click())
        }
    }
}

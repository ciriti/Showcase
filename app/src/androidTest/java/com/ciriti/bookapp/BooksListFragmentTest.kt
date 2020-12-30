package com.ciriti.bookapp

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import arrow.core.Either
import com.ciriti.bookapp.di.ModuleKey
import com.ciriti.bookapp.ui.bookslist.BooksListUseCase
import com.ciriti.bookapp.ui.bookslist.MainActivity
import com.ciriti.bookapp.ui.bookslist.components.toBook4View
import com.ciriti.datalayer.network.BooksListNullable
import com.ciriti.datalayer.network.toBook
import com.util.test.TestUtilGson
import com.util.test.runBlockingUnit
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import java.security.InvalidParameterException
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class BooksListFragmentTest : KoinTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    // mock data
    val mockList by lazy {
        TestUtilGson.run { "books.json".createListObjByJsonFile<BooksListNullable>() }
            .results?.books?.map {
                it.toBook().toBook4View()
            } ?: throw InvalidParameterException("=======> Test data set wrong!!! <=======")
    }

    @MockK
    lateinit var mockUseCase: BooksListUseCase

    // Koin mock module, only the BooksListUseCase is been used by the SUT so I need to mock only it
    val mockModule = module(override = true) {
        factory(qualifier = named(ModuleKey.KEY_BOOKS_USE_CASE)) { mockUseCase }
    }

    @Before
    fun setup() {
        /** mocked variable */
        MockKAnnotations.init(this, relaxUnitFun = true)
        coEvery { mockUseCase.getListBooks(any(), any()) } returns Either.right(mockList)
    }

    @Test
    fun first_element_has_the_smallest_rank_number() = runBlockingUnit {
        // 1. replace the module
        loadKoinModules(mockModule)
        // 2. start activity
        activityRule.launchActivity(Intent())

        val titleByAscRank = mockList.minBy { it.rank }!!.title
        val titleByDescWeek = mockList.maxBy { it.weeksOnList }!!.title

        BooksListRobot()
            .verifyTitle(titleByAscRank, 0)
            .sortByFavorites()
            .verifyTitle(titleByDescWeek, 0)
    }
}

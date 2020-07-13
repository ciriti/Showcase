package com.util.test

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Assert
import java.security.InvalidParameterException
import java.util.concurrent.TimeoutException

interface TestUtilGson {

    companion object {
        /**
         * Parse file.json and return list of objects
         */
        inline fun <reified K> String.createListObjByJsonFile(): K {
            val typeToken = object : TypeToken<K>() {}.type
            val jsonString = this.jsonFile2String()
            return Gson().fromJson(jsonString, typeToken)
        }

        /**
         * Receive file.json and return the content as string
         */
        fun String.jsonFile2String(): String = Thread.currentThread()
            .contextClassLoader
            .getResourceAsStream(this)
            .bufferedReader().use { it.readText() }
    }
}

infix fun <T> T.assertEquals(t: T) = apply { Assert.assertEquals(t, this) }
fun Boolean.assertTrue() = apply { Assert.assertTrue(this) }
fun Boolean.assertFalse() = apply { Assert.assertFalse(this) }

/**
 * If you use the runBlocking factory you need to have as last expression Unit
 * The following factory avoid that
 */
fun runBlockingUnit(
    block: suspend CoroutineScope.() -> Unit
) = runBlocking { block() }

fun matchAtPositionInRecyclerView(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
    return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("has item at position $position: ")
            itemMatcher.describeTo(description)
        }

        override fun matchesSafely(view: RecyclerView): Boolean {
            val viewHolder = view.findViewHolderForAdapterPosition(position) ?: return false
            return itemMatcher.matches(viewHolder.itemView)
        }
    }
}

@Throws(Exception::class)
suspend inline fun waitAndRetry(crossinline task: () -> Unit) {
    var counter = 20
    while (counter > 0) {
        if (checkCondition(task)) return
        delay(250)
        counter--
    }
    throw TimeoutException("====> Timeout ${20 * 250 / 100} seconds, no the condition has not been met <====")
}

inline fun checkCondition(crossinline task: () -> Unit): Boolean {
    return try {
        task()
        true
    } catch (th: Throwable) {
        false
    }
}
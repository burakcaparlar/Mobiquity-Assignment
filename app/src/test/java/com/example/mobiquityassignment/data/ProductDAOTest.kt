package com.example.mobiquityassignment.data

import com.example.mobiquityassignment.data.base.LocalDatabase
import com.example.mobiquityassignment.MockTestData.getMockCategoryEntities
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [31])
class ProductDAOTest : LocalDatabase() {

    @Test
    fun `insert and read categories`() {
        val mockTestData = getMockCategoryEntities()
        runBlocking {
            database.getProductDAO().insertCategory(mockTestData)
            val localCategories = database.getProductDAO().getCategories()
            MatcherAssert.assertThat(localCategories[0].id, `is`("mockCategoryId"))
            MatcherAssert.assertThat(localCategories[0].name, `is`("mockCategoryName"))
            MatcherAssert.assertThat(localCategories[0].description, `is`("mockCategoryDesc"))
        }
    }
}

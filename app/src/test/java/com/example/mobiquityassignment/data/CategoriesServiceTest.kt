package com.example.mobiquityassignment.data

import com.example.mobiquityassignment.data.base.ApiAbstract
import com.example.mobiquityassignment.data.remote.CategoriesService
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import java.io.IOException
import kotlin.jvm.Throws

class CategoriesServiceTest : ApiAbstract<CategoriesService>() {

    private lateinit var target: CategoriesService

    @Before
    fun initService() {
        this.target = createService(CategoriesService::class.java)
    }

    @Throws(IOException::class)
    @Test
    fun `service fetchCategories()`() {
        enqueueResponse("/categoriesResponse.json")
        runBlocking {
            target.getCategories().let {
                MatcherAssert.assertThat(it[0].id, CoreMatchers.`is`("36802"))
                MatcherAssert.assertThat(it[0].name, CoreMatchers.`is`("Food"))
                MatcherAssert.assertThat(it[0].description, CoreMatchers.`is`(""))
            }
        }
    }
}
package com.example.mobiquityassignment.core

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mobiquityassignment.R
import com.example.mobiquityassignment.core.data.State
import com.example.mobiquityassignment.core.ui.LayoutViewState
import com.example.mobiquityassignment.util.`should be`
import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

@RunWith(AndroidJUnit4::class)
@Config(sdk = [31])
class LayoutViewStateTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val httpException = mockk<HttpException>()
    private lateinit var layoutViewState: LayoutViewState

    @Test
    fun `when state is Loading, then isLoading() returns true`() {
        // Given
        layoutViewState = LayoutViewState(State.Loading)

        // When
        val result = layoutViewState.isLoading()

        // Then
        result `should be` true
    }

    @Test
    fun `when state is not Loading, then isLoading() returns false`() {
        // Given
        layoutViewState = LayoutViewState(State.Success(null))

        // When
        val result = layoutViewState.isLoading()

        // Then
        result `should be` false
    }

    @Test
    fun `when state is Error, then isError() returns true`() {
        // Given
        layoutViewState = LayoutViewState(State.Error(Exception()))

        // When
        val result = layoutViewState.isError()

        // Then
        result `should be` true
    }

    @Test
    fun `when state is not Error, then isError() returns false`() {
        // Given
        layoutViewState = LayoutViewState(State.Success(null))

        // When
        val result = layoutViewState.isError()

        // Then
        result `should be` false
    }

    @Test
    fun `when state is Success, then isSuccess() returns true`() {
        // Given
        layoutViewState = LayoutViewState(State.Success(true))

        // When
        val result = layoutViewState.isSuccess()

        // Then
        result `should be` true
    }

    @Test
    fun `when state is not Success, then isSuccess() returns false`() {
        // Given
        layoutViewState = LayoutViewState(State.Loading)

        // When
        val result = layoutViewState.isSuccess()

        // Then
        result `should be` false
    }

    @Test
    fun `when state is Error and exception is IO, then getErrorImage() returns ic_no_connection`() {
        // Given
        layoutViewState = LayoutViewState(State.Error(IOException()))

        // When
        val result = layoutViewState.getErrorImage()

        // Then
        result `should be` R.drawable.ic_no_connection
    }

    @Test
    fun `when state is Error and exception is not IO, then getErrorImage() returns ic_error`() {
        // Given
        layoutViewState = LayoutViewState(State.Error(NullPointerException()))

        // When
        val result = layoutViewState.getErrorImage()

        // Then
        result `should be` R.drawable.ic_error
    }

    @Test
    fun `when state is not Error, then getErrorImage() returns null`() {
        // Given
        layoutViewState = LayoutViewState(State.Loading)

        // When
        val result = layoutViewState.getErrorImage()

        // Then
        result `should be` null
    }

    @Test
    fun `when exception is Http, then getErrorMessage() returns http message`() {
        // Given
        every { httpException.message() } returns "Error Message"
        layoutViewState = LayoutViewState(State.Error(httpException))

        // When
        val result = layoutViewState.getErrorMessage(context)

        // Then
        result `should be` "Error Message"
    }

    @Test
    fun `when exception is IO, then getErrorMessage() returns no_internet_connection`() {
        // Given
        layoutViewState = LayoutViewState(State.Error(IOException()))

        // When
        val result = layoutViewState.getErrorMessage(context)

        // Then
        result `should be` context.getString(R.string.no_internet_connection)
    }

    @Test
    fun `when exception is SocketTimeout, then getErrorMessage() returns timeout_error_message`() {
        // Given
        layoutViewState = LayoutViewState(State.Error(SocketTimeoutException()))

        // When
        val result = layoutViewState.getErrorMessage(context)

        // Then
        result `should be` context.getString(R.string.timeout_error_message)
    }

    @Test
    fun `when exception is not one of these, then getErrorMessage() returns something_went_wrong`() {
        // Given
        layoutViewState = LayoutViewState(State.Error(NullPointerException()))

        // When
        val result = layoutViewState.getErrorMessage(context)

        // Then
        result `should be` context.getString(R.string.something_went_wrong)
    }

    @Test
    fun `when state is not Error, then getErrorMessage() returns empty`() {
        // Given
        layoutViewState = LayoutViewState(State.Loading)

        // When
        val result = layoutViewState.getErrorMessage(context)

        // Then
        result `should be` ""
    }
}
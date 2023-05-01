package com.itbproject.savethecat.ui.viewmodels

import com.itbproject.savethecat.coroutines.AppDispatchers
import com.itbproject.savethecat.data.models.AddressDto
import com.itbproject.savethecat.data.models.CompanyDto
import com.itbproject.savethecat.data.models.GeoDto
import com.itbproject.savethecat.data.models.UserDto
import com.itbproject.savethecat.data.network.CatApiService
import com.itbproject.savethecat.data.network.UsersApiService
import com.itbproject.savethecat.ui.models.LoginUiModel
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.kotlin.doSuspendableAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.coroutines.ContinuationInterceptor

class MainViewmodelTest {
    @get:Rule
    val mainCourotineRule = MainCourotineRule()

    private val usersApiService = mock<UsersApiService>()

    private lateinit var viewModel: MainViewmodel

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = AppDispatchers(
        IO = TestCoroutineDispatcher()
    )

    @Before
    fun setUp(){
        viewModel = MainViewmodel(
            apiService = usersApiService,
            appDispatchers = testDispatcher
        )
    }

    @Test
    fun loadingStateWorks() = runBlocking {
        whenever(usersApiService.getUsers()).doSuspendableAnswer {
            withContext(Dispatchers.IO) { delay(5000) }
            emptyList()
        }
        viewModel.checkCredentials()
        Assert.assertEquals(LoginState.LOADING(LoginUiModel(user="", pssw="")), viewModel.loginState.value)
    }

    @Test
    fun successStateWorks() = runBlocking {
        whenever(usersApiService.getUsers()).thenReturn(
            listOf(
                UserDto(
                    id = 0,
                    name = "",
                    username = "Bret",
                    email = "",
                    address = AddressDto(
                        street = "",
                        suite = "",
                        city = "",
                        zipcode = "",
                        geo = GeoDto(
                            lat = "",
                            lng = ""
                        )
                    ),
                    phone = "",
                    website = "",
                    company = CompanyDto(
                        bs = "",
                        catchPhrase = "",
                        name = ""
                    )
                )
            )
        )

        viewModel.updateUsername("Bret")
        viewModel.updatePassword("Bret123")
        viewModel.checkCredentials()
        Assert.assertEquals(LoginState.SUCCESS, viewModel.loginState.value)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class MainCourotineRule : TestWatcher(),
    TestCoroutineScope by TestCoroutineScope() {
    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(
            this.coroutineContext[ContinuationInterceptor] as CoroutineDispatcher
        )
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}